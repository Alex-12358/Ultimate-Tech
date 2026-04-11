package org.mod.ultimate_tech.core.datagen.providers.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.init.Registry;
import org.mod.ultimate_tech.common.material.ModGames;
import org.mod.ultimate_tech.common.material.ModMaterial;
import org.mod.ultimate_tech.core.registry.block.generator.*;
import org.mod.ultimate_tech.core.registry.item.material.*;
import org.mod.ultimate_tech.core.registry.item.tool.*;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        // ORE -> INGOT
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasOre() || !material.hasIngot()) continue;

            if (ModBlocksOre.ORES.containsKey(material) && ModItemsIngot.INGOTS.containsKey(material)) {
                ItemLike ore = ModBlocksOre.ORES.get(material).get();
                ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

                oreSmelting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
                oreBlasting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
            }
        }

        // DEEPSLATE ORE -> INGOT
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasDeepOre() || !material.hasIngot()) continue;

            if (ModBlocksDeepslateOre.ORES.containsKey(material) && ModItemsIngot.INGOTS.containsKey(material)) {
                ItemLike ore = ModBlocksDeepslateOre.ORES.get(material).get();
                ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

                oreSmelting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
                oreBlasting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
            }
        }

        // NETHER ORE -> INGOT
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasNetherOre() || !material.hasIngot()) continue;

            if (ModBlocksNetherOre.ORES.containsKey(material) && ModItemsIngot.INGOTS.containsKey(material)) {
                ItemLike ore = ModBlocksNetherOre.ORES.get(material).get();
                ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

                oreSmelting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
                oreBlasting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
            }
        }

        // END ORE -> INGOT
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasEndOre() || !material.hasIngot()) continue;

            if (ModBlocksEndOre.ORES.containsKey(material) && ModItemsIngot.INGOTS.containsKey(material)) {
                ItemLike ore = ModBlocksEndOre.ORES.get(material).get();
                ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

                oreSmelting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
                oreBlasting(pWriter, List.of(ore), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
            }
        }

        // RAW MATERIALS -> RAW_BLOCKS
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasBlockRaw() || !material.hasItemRaw() || !material.hasIngot()) continue;

            if (ModBlocksRaw.RAW_BLOCKS.containsKey(material) && ModItemsRaw.RAW_ITEMS.containsKey(material)) {
                ItemLike raw = ModItemsRaw.RAW_ITEMS.get(material).get();
                ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();
                ItemLike rawBlock = ModBlocksRaw.RAW_BLOCKS.get(material).get();

                // RAW -> RAW_BLOCKS (9 raw items)
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rawBlock)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', raw)
                        .unlockedBy(getHasName(raw), has(raw))
                        .save(pWriter);

                // RAW_BLOCKS -> RAW
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, raw, 9)
                        .requires(rawBlock)
                        .unlockedBy(getHasName(rawBlock), has(rawBlock))
                        .save(pWriter);

                // RAW -> INGOT (SMELTING + BLASTING)
                oreSmelting(pWriter, List.of(raw), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
                oreBlasting(pWriter, List.of(raw), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
            }
        }

        // INGOT BLOCK RECIPES (9 ingots -> block, block -> 9 ingots)
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasBlock() || !material.hasIngot()) continue;

            if (ModBlocksBlock.BLOCK.containsKey(material) && ModItemsIngot.INGOTS.containsKey(material)) {
                ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();
                ItemLike ingotBlock = ModBlocksBlock.BLOCK.get(material).get();

                // 9 ingots -> ingot block
                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ingotBlock)
                        .pattern("III")
                        .pattern("III")
                        .pattern("III")
                        .define('I', ingot)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(pWriter, Ultimate_tech.MOD_ID + ":storage_" + material.getName());

                // ingot block -> 9 ingots
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
                        .requires(ingotBlock)
                        .unlockedBy(getHasName(ingotBlock), has(ingotBlock))
                        .save(pWriter, Ultimate_tech.MOD_ID + ":" + material.getName() + "_from_storage");
            }
        }

        // NUGGET RECIPES (9 nuggets -> ingot)
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasNugget() || !material.hasIngot()) continue;

            if (ModItemsNugget.NUGGETS.containsKey(material) && ModItemsIngot.INGOTS.containsKey(material)) {
                ItemLike nugget = ModItemsNugget.NUGGETS.get(material).get();
                ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

                // 9 nuggets -> ingot
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
                        .pattern("NNN")
                        .pattern("NNN")
                        .pattern("NNN")
                        .define('N', nugget)
                        .unlockedBy(getHasName(nugget), has(nugget))
                        .save(pWriter, Ultimate_tech.MOD_ID + ":" + material.getName() + "_from_nuggets");

                // ingot -> 9 nuggets
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
                        .requires(ingot)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(pWriter, Ultimate_tech.MOD_ID + ":" + material.getName() + "_nuggets");
            }
        }

        // TOOL RECIPES for ModGames (драгоценности)
        for (ModGames material : ModGames.values()) {
            ItemLike ingot = ModGamesItem.INGOTS.get(material).get();

            // SWORD
            if (material.hasSword() && ModItemsToolSword.SWORDS.containsKey(material)) {
                ItemLike sword = ModItemsToolSword.SWORDS.get(material).get();
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, sword)
                        .pattern("I")
                        .pattern("I")
                        .pattern("S")
                        .define('I', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(pWriter);
            }

            // PICKAXE
            if (material.hasPickaxe() && ModItemsToolPickaxe.PICKAXES.containsKey(material)) {
                ItemLike pickaxe = ModItemsToolPickaxe.PICKAXES.get(material).get();
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                        .pattern("III")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('I', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(pWriter);
            }

            // AXE
            if (material.hasAxe() && ModItemsToolAxe.AXES.containsKey(material)) {
                ItemLike axe = ModItemsToolAxe.AXES.get(material).get();
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                        .pattern("II")
                        .pattern("IS")
                        .pattern(" S")
                        .define('I', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(pWriter);
            }

            // SHOVEL
            if (material.hasShovel() && ModItemsToolShovel.SHOVELS.containsKey(material)) {
                ItemLike shovel = ModItemsToolShovel.SHOVELS.get(material).get();
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                        .pattern("I")
                        .pattern("S")
                        .pattern("S")
                        .define('I', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(pWriter);
            }

            // HOE
            if (material.hasHoe() && ModItemsToolHoe.HOES.containsKey(material)) {
                ItemLike hoe = ModItemsToolHoe.HOES.get(material).get();
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                        .pattern("II")
                        .pattern(" S")
                        .pattern(" S")
                        .define('I', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(pWriter);
            }
        }

        // ELEVATOR RECIPES - для каждого цвета
        for (DyeColor color : DyeColor.values()) {
            ItemLike elevatorBlock = Registry.ELEVATOR_BLOCKS.get(color).get();

            // Основной рецепт лифта
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, elevatorBlock)
                    .pattern("WWW")
                    .pattern("WEW")
                    .pattern("WWW")
                    .define('W', Items.WHITE_WOOL)  // Упрощено - только белая шерсть
                    .define('E', Items.ENDER_PEARL)
                    .unlockedBy("has_wool", has(Items.WHITE_WOOL))
                    .save(pWriter);
        }
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Ultimate_tech.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
