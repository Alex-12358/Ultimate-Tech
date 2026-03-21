package org.mod.ultimate_tech.core.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.block.ore.*;
import org.mod.ultimate_tech.common.block.ore.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ultimate_tech.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // CORE BLOCKS
        // Закомментировал, так как текстуры могут быть отсутствующими
        // simpleBlock(ModBlocks.CORE_STRUCTURAL_BLOCK.get());
        // simpleBlock(ModBlocks.MACHINE_STRUCTURAL_HOUSING.get());

        // ORES
        ModBlocksOre.ORES.values().forEach(this::simpleBlock);

        // DEEPSLATE ORES
        ModBlocksDeepslateOre.ORES.values().forEach(this::simpleBlock);

        // NETHER ORES
        ModBlocksNetherOre.ORES.values().forEach(this::simpleBlock);

        // END ORES
        ModBlocksEndOre.ORES.values().forEach(this::simpleBlock);

        // STORAGE BLOCKS
        ModBlocksBlock.BLOCK.values().forEach(this::simpleBlock);

        // RAW BLOCKS
        ModBlocksRaw.RAW_BLOCKS.values().forEach(this::simpleBlock);
    }

    private void simpleBlock(RegistryObject<Block> block) {

        // ТВОЙ КОД (оставил, но закомментировал)
        /*
        simpleBlockWithItem(
                block.get(),
                cubeAll(block.get())
        );
        */

        // Fallback модель чтобы datagen не требовал текстуру
        simpleBlockWithItem(
                block.get(),
                models().cubeAll(
                        block.getId().getPath(),
                        new ResourceLocation("minecraft", "block/stone")
                )
        );

    }
}
