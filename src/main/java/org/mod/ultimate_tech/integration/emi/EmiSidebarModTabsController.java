package org.mod.ultimate_tech.integration.emi;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;
import org.mod.ultimate_tech.Ultimate_tech;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Adds right-side square mod tabs for EMI and filters index source by selected namespace.
 */
public final class EmiSidebarModTabsController {
    private static final int TAB_SIZE = 20;
    private static final int GAP = 2;
    private static final int TOP_MARGIN = 28;
    private static final int RIGHT_MARGIN = 4;
    private static final int TABS_PER_PAGE = 8;
    private static final Path ICONS_CONFIG = FMLPaths.CONFIGDIR.get().resolve("ultimate_tech_emi_tabs_icons.properties");

    private static boolean initialized;
    private static List<String> namespaces = List.of();
    private static Map<String, TabIconSpec> iconSpecs = Map.of();
    private static int pageIndex;

    private EmiSidebarModTabsController() {
    }

    public static void bootstrap() {
        if (initialized || !ModList.get().isLoaded("emi")) {
            return;
        }
        initialized = true;
        namespaces = collectNamespaces();
        iconSpecs = loadIconSpecs();
        EmiSidebarModTabState.setActiveNamespace(null);
    }

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (!initialized) {
            return;
        }

        // EMI sidebar is relevant only for container-like screens (inventory, chests, machines).
        if (!(event.getScreen() instanceof AbstractContainerScreen<?>)) {
            return;
        }

        int maxPage = getMaxPage();
        if (pageIndex > maxPage) {
            pageIndex = maxPage;
        }

        int x = event.getScreen().width - TAB_SIZE - RIGHT_MARGIN;
        int y = TOP_MARGIN;

        Button pagePrev = Button.builder(Component.literal("^") , b -> {
            pageIndex = pageIndex <= 0 ? getMaxPage() : pageIndex - 1;
            event.getScreen().init(Minecraft.getInstance(), event.getScreen().width, event.getScreen().height);
        }).bounds(x, y, TAB_SIZE, TAB_SIZE).build();
        pagePrev.active = !namespaces.isEmpty();
        pagePrev.setTooltip(net.minecraft.client.gui.components.Tooltip.create(Component.literal("Previous mod page")));
        event.addListener(pagePrev);
        y += TAB_SIZE + GAP;

        Button allButton = Button.builder(Component.literal("A"), b -> {
            EmiSidebarModTabState.setActiveNamespace(null);
            event.getScreen().init(Minecraft.getInstance(), event.getScreen().width, event.getScreen().height);
        }).bounds(x, y, TAB_SIZE, TAB_SIZE).build();
        allButton.active = EmiSidebarModTabState.getActiveNamespace() != null;
        allButton.setTooltip(net.minecraft.client.gui.components.Tooltip.create(Component.literal("All mods")));
        event.addListener(allButton);
        y += TAB_SIZE + GAP;

        List<String> pageItems = getPageItems(pageIndex);
        for (int i = 0; i < TABS_PER_PAGE; i++) {
            final String namespace = i < pageItems.size() ? pageItems.get(i) : null;
            Button tab;
            if (namespace == null) {
                tab = Button.builder(Component.literal("-"), b -> {
                }).bounds(x, y, TAB_SIZE, TAB_SIZE).build();
                tab.active = false;
            } else {
                TabIconSpec spec = iconSpecs.get(namespace);
                ItemStack fallback = getDefaultItemIcon(namespace);
                boolean selected = namespace.equals(EmiSidebarModTabState.getActiveNamespace());
                tab = new EmiSquareIconButton(
                        x,
                        y,
                        TAB_SIZE,
                        Component.literal(namespace),
                        spec != null ? spec.texture : null,
                        spec != null ? spec.item : null,
                        fallback,
                        () -> namespace.equals(EmiSidebarModTabState.getActiveNamespace()),
                        b -> {
                            EmiSidebarModTabState.setActiveNamespace(namespace);
                            event.getScreen().init(Minecraft.getInstance(), event.getScreen().width, event.getScreen().height);
                        }
                );
                tab.active = !selected;
            }
            event.addListener(tab);
            y += TAB_SIZE + GAP;
        }

        Button pageNext = Button.builder(Component.literal("v"), b -> {
            pageIndex = pageIndex >= getMaxPage() ? 0 : pageIndex + 1;
            event.getScreen().init(Minecraft.getInstance(), event.getScreen().width, event.getScreen().height);
        }).bounds(x, y, TAB_SIZE, TAB_SIZE).build();
        pageNext.active = !namespaces.isEmpty();
        pageNext.setTooltip(net.minecraft.client.gui.components.Tooltip.create(Component.literal("Next mod page")));
        event.addListener(pageNext);
    }


    private static int getMaxPage() {
        if (namespaces.isEmpty()) {
            return 0;
        }
        return (namespaces.size() - 1) / TABS_PER_PAGE;
    }

    private static List<String> getPageItems(int page) {
        if (namespaces.isEmpty()) {
            return List.of();
        }
        int from = page * TABS_PER_PAGE;
        if (from >= namespaces.size()) {
            return List.of();
        }
        int to = Math.min(namespaces.size(), from + TABS_PER_PAGE);
        return namespaces.subList(from, to);
    }

    private static List<String> collectNamespaces() {
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (ResourceLocation id : ForgeRegistries.ITEMS.getKeys()) {
            counts.merge(id.getNamespace(), 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(counts.entrySet());
        sorted.sort(Comparator
                .comparing((Map.Entry<String, Integer> e) -> e.getKey().equals(Ultimate_tech.MOD_ID) ? 0 : 1)
                .thenComparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
                .thenComparing(Map.Entry<String, Integer>::getKey));

        List<String> result = new ArrayList<>(sorted.size());
        for (Map.Entry<String, Integer> entry : sorted) {
            result.add(entry.getKey());
        }
        return result;
    }

    private static ItemStack getDefaultItemIcon(String namespace) {
        for (ResourceLocation id : ForgeRegistries.ITEMS.getKeys()) {
            if (namespace.equals(id.getNamespace())) {
                Item item = ForgeRegistries.ITEMS.getValue(id);
                if (item != null && item != Items.AIR) {
                    return new ItemStack(item);
                }
            }
        }
        return new ItemStack(Items.BARRIER);
    }

    private static Map<String, TabIconSpec> loadIconSpecs() {
        ensureIconsConfigExists();
        Properties props = new Properties();
        try (Reader reader = Files.newBufferedReader(ICONS_CONFIG, StandardCharsets.UTF_8)) {
            props.load(reader);
        } catch (IOException ignored) {
            return Map.of();
        }

        Map<String, TabIconSpec> result = new HashMap<>();
        for (String key : props.stringPropertyNames()) {
            String namespace = key.trim();
            String value = props.getProperty(key, "").trim();
            if (namespace.isEmpty() || value.isEmpty()) {
                continue;
            }

            TabIconSpec spec = parseIconSpec(value);
            if (spec != null) {
                result.put(namespace, spec);
            }
        }
        return result;
    }

    private static TabIconSpec parseIconSpec(String value) {
        ResourceLocation texture = null;
        ItemStack item = ItemStack.EMPTY;

        if (value.startsWith("tex:")) {
            ResourceLocation id = ResourceLocation.tryParse(value.substring("tex:".length()));
            if (id != null) {
                texture = id;
            }
        } else {
            String itemIdText = value.startsWith("item:") ? value.substring("item:".length()) : value;
            ResourceLocation itemId = ResourceLocation.tryParse(itemIdText);
            if (itemId != null) {
                Item resolved = ForgeRegistries.ITEMS.getValue(itemId);
                if (resolved != null && resolved != Items.AIR) {
                    item = new ItemStack(resolved);
                }
            }
        }

        if (texture == null && item.isEmpty()) {
            return null;
        }
        return new TabIconSpec(texture, item);
    }

    private static void ensureIconsConfigExists() {
        try {
            if (Files.exists(ICONS_CONFIG)) {
                return;
            }
            Files.createDirectories(ICONS_CONFIG.getParent());
            try (Writer writer = Files.newBufferedWriter(ICONS_CONFIG, StandardCharsets.UTF_8)) {
                writer.write("# EMI mod tab icons.\n");
                writer.write("# Format: <namespace>=item:<modid:item> OR <namespace>=tex:<modid:textures/path/file.png>\n");
                writer.write("# Example item icon:\n");
                writer.write("# ultimate_tech=item:minecraft:diamond\n");
                writer.write("# Example custom texture icon:\n");
                writer.write("# minecraft=tex:ultimate_tech:textures/gui/emi_tabs/minecraft.png\n");
            }
        } catch (IOException ignored) {
            // Config generation is best-effort only.
        }
    }

    private static final class TabIconSpec {
        private final ResourceLocation texture;
        private final ItemStack item;

        private TabIconSpec(ResourceLocation texture, ItemStack item) {
            this.texture = texture;
            this.item = item;
        }
    }
}
