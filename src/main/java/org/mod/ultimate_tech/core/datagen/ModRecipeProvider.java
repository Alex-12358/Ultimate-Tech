package org.mod.ultimate_tech.core.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.core.registry.block.generator.*;
import org.mod.ultimate_tech.core.registry.item.material.ModItemsIngot;
import org.mod.ultimate_tech.core.registry.item.material.ModItemsRaw;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ModBlocksRaw.RAW_BLOCKS.forEach((material, block) -> {

            if (!ModItemsRaw.RAW_ITEMS.containsKey(material)) return;
            if (!ModItemsIngot.INGOTS.containsKey(material)) return;

            ItemLike raw = ModItemsRaw.RAW_ITEMS.get(material).get();
            ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();
            ItemLike rawBlock = block.get();

            // RAW -> RAW_BLOCKS
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
        });

        // ORE -> INGOT
        ModBlocksOre.ORES.forEach((material, block) -> {
            if (!ModItemsIngot.INGOTS.containsKey(material)) return;

            ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

            oreSmelting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
            oreBlasting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
        });

        ModBlocksDeepslateOre.ORES.forEach((material, block) -> {
            if (!ModItemsIngot.INGOTS.containsKey(material)) return;

            ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

            oreSmelting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
            oreBlasting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
        });

        ModBlocksNetherOre.ORES.forEach((material, block) -> {
            if (!ModItemsIngot.INGOTS.containsKey(material)) return;

            ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

            oreSmelting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
            oreBlasting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
        });

        ModBlocksEndOre.ORES.forEach((material, block) -> {
            if (!ModItemsIngot.INGOTS.containsKey(material)) return;

            ItemLike ingot = ModItemsIngot.INGOTS.get(material).get();

            oreSmelting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 200, material.name().toLowerCase());
            oreBlasting(pWriter, List.of(block.get()), RecipeCategory.MISC, ingot, 0.7f, 100, material.name().toLowerCase());
        });
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
