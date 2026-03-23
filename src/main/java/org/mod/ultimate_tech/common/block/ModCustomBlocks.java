package org.mod.ultimate_tech.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import static org.mod.ultimate_tech.core.registry.ModBlockUtils.BLOCKS;
import static org.mod.ultimate_tech.core.registry.ModBlockUtils.registerBlock;

public class ModCustomBlocks {
//    public static final RegistryObject<Block> CORE_STRUCTURAL_BLOCK = simpleBlock("core_structural_block");
//    public static final RegistryObject<Block> MACHINE_STRUCTURAL_HOUSING = simpleBlock("machine_structural_housing");
    public static final RegistryObject<Block> BATTERY = registerBlock(BLOCKS, "battery", BatteryBlock::new);

    public static void init() {
    }
}
