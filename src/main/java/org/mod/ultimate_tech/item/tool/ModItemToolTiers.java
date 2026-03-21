package org.mod.ultimate_tech.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.item.custom_item.ModGamesItem;
import org.mod.ultimate_tech.material.ModGames;
import org.mod.ultimate_tech.util.ModTags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItemToolTiers {
    private static final Map<ModGames, Tier> TIERS = new HashMap<>();

    public static void generate() {
        TIERS.put(ModGames.RUBY, TierSortingRegistry.registerTier(
                new ForgeTier(
                        5, 1500, 5f, 4f, 25,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.RUBY).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "ruby"),
                List.of(Tiers.NETHERITE),
                List.of()
        ));

        TIERS.put(ModGames.SAPPHIRE, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1200, 6f, 3f, 20,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.SAPPHIRE).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "sapphire"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.TOPAZ, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1100, 6.5f, 3.5f, 19,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.TOPAZ).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "topaz"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.AMETHYST, TierSortingRegistry.registerTier(
                new ForgeTier(
                        3, 950, 7f, 2.5f, 18,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.AMETHYST).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "amethyst"),
                List.of(Tiers.IRON),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.GARNET, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1300, 6f, 3.5f, 21,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.GARNET).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "garnet"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.OPAL, TierSortingRegistry.registerTier(
                new ForgeTier(
                        3, 1000, 6.5f, 2.5f, 17,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.OPAL).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "opal"),
                List.of(Tiers.IRON),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.JADE, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1400, 5.5f, 4f, 22,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.JADE).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "jade"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.MALACHITE, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1250, 6f, 3f, 20,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.MALACHITE).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "malachite"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.AQUAMARINE, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1150, 7f, 3f, 19,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.AQUAMARINE).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "aquamarine"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.SPINEL, TierSortingRegistry.registerTier(
                new ForgeTier(
                        5, 1600, 6.5f, 4.5f, 24,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.SPINEL).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "spinel"),
                List.of(Tiers.NETHERITE),
                List.of()
        ));

        TIERS.put(ModGames.ZIRCON, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1200, 6f, 3f, 20,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.ZIRCON).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "zircon"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));

        TIERS.put(ModGames.MORGANITE, TierSortingRegistry.registerTier(
                new ForgeTier(
                        4, 1180, 6.5f, 3f, 19,
                        ModTags.Blocks.NEED_TOOL,
                        () -> Ingredient.of(ModGamesItem.INGOTS.get(ModGames.MORGANITE).get())
                ),
                new ResourceLocation(Ultimate_tech.MOD_ID, "morganite"),
                List.of(Tiers.DIAMOND),
                List.of(Tiers.NETHERITE)
        ));
    }

    public static Tier getTier(ModGames material) {
        Tier tier = TIERS.get(material);
        if (tier == null) {
            throw new IllegalStateException("Тир не зарегистрированный для материала: " + material.name());
        }
        return tier;
    }
}
