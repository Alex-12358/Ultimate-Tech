package org.mod.ultimate_tech.block.ore;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.block.ore.ModBlockUtils.simpleBlock;

public class ModBlocksRaw {

    public static final Map<ModMaterial, RegistryObject<Block>> RAW_BLOCKS = new HashMap<>();
    public static void generate() {
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasBlockRaw()) continue;
            String name = "raw_" + material.getName() + "_block";
            RAW_BLOCKS.put(
                    material,
                    simpleBlock(name)
            );
        }
    }
}
