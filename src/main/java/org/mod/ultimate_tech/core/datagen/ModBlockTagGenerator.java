package org.mod.ultimate_tech.core.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.block.ore.*;
import org.mod.ultimate_tech.common.block.ore.*;
import org.mod.ultimate_tech.core.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ultimate_tech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        // =========================
        // CORE BLOCKS
        // =========================

//        this.tag(ModTags.Blocks.CORE_STRUCTURAL_BLOCK)
//                .add(ModBlocks.CORE_STRUCTURAL_BLOCK.get());
//
//        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(ModBlocks.CORE_STRUCTURAL_BLOCK.get());
//
//        this.tag(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks.CORE_STRUCTURAL_BLOCK.get());

        // =========================
        // OVERWORLD ORES
        // =========================

        this.tag(ModTags.Blocks.ORES)
                .addTag(Tags.Blocks.ORES);

        ModBlocksOre.ORES.values().forEach(block -> {
            this.tag(ModTags.Blocks.ORES).add(block.get());

            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
            this.tag(BlockTags.NEEDS_IRON_TOOL).add(block.get());
        });

        // =========================
        // DEEPSLATE ORES
        // =========================

        this.tag(ModTags.Blocks.DEEPSLATE_ORES)
                .addTag(Tags.Blocks.ORES);

        ModBlocksDeepslateOre.ORES.values().forEach(block -> {
            this.tag(ModTags.Blocks.DEEPSLATE_ORES).add(block.get());

            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
            this.tag(BlockTags.NEEDS_IRON_TOOL).add(block.get());
        });


        // =========================
        // NETHER ORES
        // =========================

        this.tag(ModTags.Blocks.NETHER_ORES)
                .addTag(Tags.Blocks.ORES);

        ModBlocksNetherOre.ORES.values().forEach(block -> {
            this.tag(ModTags.Blocks.NETHER_ORES).add(block.get());

            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
            this.tag(BlockTags.NEEDS_IRON_TOOL).add(block.get());
        });


        // =========================
        // END ORES
        // =========================

        this.tag(ModTags.Blocks.END_ORES)
                .addTag(Tags.Blocks.ORES);

        ModBlocksEndOre.ORES.values().forEach(block -> {
            this.tag(ModTags.Blocks.END_ORES).add(block.get());

            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
            this.tag(BlockTags.NEEDS_IRON_TOOL).add(block.get());
        });

        // =========================
        // RAW BLOCKS
        // =========================

        ModBlocksRaw.RAW_BLOCKS.values().forEach(block -> {
            this.tag(ModTags.Blocks.RAW_BLOCKS).add(block.get());

            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
            this.tag(BlockTags.NEEDS_IRON_TOOL).add(block.get());
        });

        // =========================
        // STORAGE BLOCKS
        // =========================

        this.tag(ModTags.Blocks.STORAGE_BLOCKS)
                .addTag(Tags.Blocks.STORAGE_BLOCKS);

        ModBlocksBlock.BLOCK.values().forEach(block -> {
            this.tag(ModTags.Blocks.STORAGE_BLOCKS).add(block.get());

            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
            this.tag(BlockTags.NEEDS_IRON_TOOL).add(block.get());
        });
    }
}
