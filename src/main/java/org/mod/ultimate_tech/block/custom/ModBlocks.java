package org.mod.ultimate_tech.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import static org.mod.ultimate_tech.block.ore.ModBlockUtils.*;

public class ModBlocks {
//    public static final RegistryObject<Block> CORE_STRUCTURAL_BLOCK = simpleBlock("core_structural_block");
//    public static final RegistryObject<Block> MACHINE_STRUCTURAL_HOUSING = simpleBlock("machine_structural_housing");
    public static final RegistryObject<Block> BATTERY = registerBlock(BLOCKS, "battery", BatteryBlock::new);

    public static void init() {
    }
}
