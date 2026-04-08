package org.mod.ultimate_tech.integration.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.core.registry.block.generator.*;
import org.mod.ultimate_tech.core.registry.fluid.ModFluids;
import org.mod.ultimate_tech.core.registry.item.material.*;
import org.mod.ultimate_tech.core.registry.item.tool.*;

import java.util.ArrayList;
import java.util.List;

@EmiEntrypoint
public class UltimateTechEmiPlugin implements EmiPlugin {
    private static final ResourceLocation ORES_ID = new ResourceLocation(Ultimate_tech.MOD_ID, "emi/ores");
    private static final ResourceLocation INGOTS_ID = new ResourceLocation(Ultimate_tech.MOD_ID, "emi/ingots");
    private static final ResourceLocation TOOLS_ID = new ResourceLocation(Ultimate_tech.MOD_ID, "emi/tools");
    private static final ResourceLocation FLUIDS_ID = new ResourceLocation(Ultimate_tech.MOD_ID, "emi/fluids");

    private static final EmiRecipeCategory ORES_CATEGORY =
            new EmiRecipeCategory(ORES_ID, EmiStack.of(Items.DEEPSLATE));

    private static final EmiRecipeCategory INGOTS_CATEGORY =
            new EmiRecipeCategory(INGOTS_ID, EmiStack.of(Items.IRON_INGOT));

    private static final EmiRecipeCategory TOOLS_CATEGORY =
            new EmiRecipeCategory(TOOLS_ID, EmiStack.of(Items.DIAMOND_PICKAXE));

    private static final EmiRecipeCategory FLUIDS_CATEGORY =
            new EmiRecipeCategory(FLUIDS_ID, EmiStack.of(Items.WATER_BUCKET));

    @Override
    public void register(EmiRegistry registry) {registry.addCategory(ORES_CATEGORY);
        registry.addCategory(INGOTS_CATEGORY);
        registry.addCategory(TOOLS_CATEGORY);
        registry.addCategory(FLUIDS_CATEGORY);

        // ORES
        List<EmiStack> oreStacks = new ArrayList<>();
        ModBlocksOre.ORES.values().forEach(ro -> oreStacks.add(EmiStack.of(ro.get().asItem())));
        ModBlocksDeepslateOre.ORES.values().forEach(ro -> oreStacks.add(EmiStack.of(ro.get().asItem())));
        ModBlocksNetherOre.ORES.values().forEach(ro -> oreStacks.add(EmiStack.of(ro.get().asItem())));
        ModBlocksEndOre.ORES.values().forEach(ro -> oreStacks.add(EmiStack.of(ro.get().asItem())));
        registry.addRecipe(new ItemGridEmiRecipe(
                ORES_CATEGORY,
                new ResourceLocation(Ultimate_tech.MOD_ID, "emi/showcase/ores"),
                oreStacks,
                11
        ));

        // INGOTS
        List<EmiStack> ingotStacks = new ArrayList<>();
        ModItemsIngot.INGOTS.values().forEach(ro -> ingotStacks.add(EmiStack.of(ro.get())));
        registry.addRecipe(new ItemGridEmiRecipe(
                INGOTS_CATEGORY,
                new ResourceLocation(Ultimate_tech.MOD_ID, "emi/showcase/ingots"),
                ingotStacks,
                11
        ));

        // TOOLS
        List<EmiStack> toolStacks = new ArrayList<>();
        ModItemsToolSword.SWORDS.values().forEach(ro -> toolStacks.add(EmiStack.of(ro.get())));
        ModItemsToolPickaxe.PICKAXES.values().forEach(ro -> toolStacks.add(EmiStack.of(ro.get())));
        ModItemsToolAxe.AXES.values().forEach(ro -> toolStacks.add(EmiStack.of(ro.get())));
        ModItemsToolShovel.SHOVELS.values().forEach(ro -> toolStacks.add(EmiStack.of(ro.get())));
        ModItemsToolHoe.HOES.values().forEach(ro -> toolStacks.add(EmiStack.of(ro.get())));
        registry.addRecipe(new ItemGridEmiRecipe(
                TOOLS_CATEGORY,
                new ResourceLocation(Ultimate_tech.MOD_ID, "emi/showcase/tools"),
                toolStacks,
                11
        ));

        // FLUIDS (через bucket items)
        List<EmiStack> fluidStacks = new ArrayList<>();
        ModFluids.FLUID.values().forEach(set -> fluidStacks.add(EmiStack.of(set.bucket.get())));
        registry.addRecipe(new ItemGridEmiRecipe(
                FLUIDS_CATEGORY,
                new ResourceLocation(Ultimate_tech.MOD_ID, "emi/showcase/fluids"),
                fluidStacks,
                8
        ));
    }
}
