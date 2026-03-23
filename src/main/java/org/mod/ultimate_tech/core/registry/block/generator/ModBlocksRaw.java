package org.mod.ultimate_tech.core.registry.block.generator;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.common.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.core.registry.ModBlockUtils.simpleBlock;

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
