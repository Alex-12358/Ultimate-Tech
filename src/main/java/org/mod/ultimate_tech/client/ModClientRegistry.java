package org.mod.ultimate_tech.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.client.render.ModBlurRenderer;
import org.mod.ultimate_tech.common.block.ElevatorBlock;
import org.mod.ultimate_tech.client.gui.ElevatorScreen;
import org.mod.ultimate_tech.client.render.ModColorCamoElevator;
import org.mod.ultimate_tech.client.render.ModElevatorBakedModel;
import org.mod.ultimate_tech.client.render.ModToolItemColor;
import org.mod.ultimate_tech.common.init.Registry;
import org.mod.ultimate_tech.core.registry.item.tool.*;

@Mod.EventBusSubscriber(modid = Ultimate_tech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientRegistry {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ModBlurRenderer.init();
            MenuScreens.register(Registry.ELEVATOR_CONTAINER.get(), ElevatorScreen::new);
        });
    }

    @SubscribeEvent
    public static void onBlockColorHandlersRegistry(RegisterColorHandlersEvent.Block e) {
        e.register(
                new ModColorCamoElevator(),
                Registry.ELEVATOR_BLOCKS.values().stream().map(RegistryObject::get).toArray(ElevatorBlock[]::new)
        );
    }

    @SubscribeEvent
    public static void onItemColorHandlersRegistry(RegisterColorHandlersEvent.Item e) {
        ModToolItemColor toolColor = new ModToolItemColor();

        // Мечи
        registerSwordColors(e, toolColor);

        // Кирки
        registerPickaxeColors(e, toolColor);

        // Топоры
        registerAxeColors(e, toolColor);

        // Лопаты
        registerShovelColors(e, toolColor);

        // Мотыги
        registerHoeColors(e, toolColor);
    }

    private static void registerSwordColors(RegisterColorHandlersEvent.Item e, ModToolItemColor toolColor) {
        e.register(toolColor, ModItemsToolSword.SWORDS.values().stream().map(RegistryObject::get).toArray(Item[]::new));
    }

    private static void registerPickaxeColors(RegisterColorHandlersEvent.Item e, ModToolItemColor toolColor) {
        e.register(toolColor, ModItemsToolPickaxe.PICKAXES.values().stream().map(RegistryObject::get).toArray(Item[]::new));
    }

    private static void registerAxeColors(RegisterColorHandlersEvent.Item e, ModToolItemColor toolColor) {
        e.register(toolColor, ModItemsToolAxe.AXES.values().stream().map(RegistryObject::get).toArray(Item[]::new));
    }

    private static void registerShovelColors(RegisterColorHandlersEvent.Item e, ModToolItemColor toolColor) {
        e.register(toolColor, ModItemsToolShovel.SHOVELS.values().stream().map(RegistryObject::get).toArray(Item[]::new));
    }

    private static void registerHoeColors(RegisterColorHandlersEvent.Item e, ModToolItemColor toolColor) {
        e.register(toolColor, ModItemsToolHoe.HOES.values().stream().map(RegistryObject::get).toArray(Item[]::new));
    }


    @SubscribeEvent
    public static void onModelRegistry(ModelEvent.RegisterAdditional e) {
        e.register(new ResourceLocation("ultimate_tech", "arrow"));
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.ModifyBakingResult e) {
        e.getModels().entrySet().stream()
                .filter(entry -> "ultimate_tech".equals(entry.getKey().getNamespace()) && entry.getKey().getPath().contains("elevator_"))
                .forEach(entry -> e.getModels().put(entry.getKey(), new ModElevatorBakedModel(entry.getValue())));
    }




}
