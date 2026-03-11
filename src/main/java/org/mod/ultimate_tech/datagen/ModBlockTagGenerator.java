package org.mod.ultimate_tech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.block.ModBlocksBlock;
import org.mod.ultimate_tech.block.ModBlocksDeepslateOre;
import org.mod.ultimate_tech.block.ModBlocksOre;
import org.mod.ultimate_tech.block.ModBlocksRaw;
import org.mod.ultimate_tech.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ultimate_tech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag()

        // CORE BLOCKS
        this.tag(ModTags.Blocks.CORE_STRUCTURAL_BLOCK)
                .add(ModBlocksOre.CORE_STRUCTURAL_BLOCK.get());
//        this.tag(ModTags.Blocks.MACHINE_STRUCTURAL_HOUSING)
//                .add(ModBlocks.MACHINE_STRUCTURAL_HOUSING.get());

        // ORES
        ModBlocksOre.ORES.values().forEach(block ->
                tag(ModTags.Blocks.ORES).add(block.get())
        );

        // DEEPSLATE ORES
        ModBlocksDeepslateOre.ORES.values().forEach(block ->
                tag(ModTags.Blocks.DEEPSLATE_ORES).add(block.get())
        );

        // RAW BLOCKS
        ModBlocksRaw.RAW_BLOCKS.values().forEach(block ->
                tag(ModTags.Blocks.RAW_BLOCKS).add(block.get())
        );

        // STORAGE BLOCKS
        ModBlocksBlock.BLOCK.values().forEach(block ->
                tag(ModTags.Blocks.STORAGE_BLOCKS).add(block.get())
        );
    }
}
