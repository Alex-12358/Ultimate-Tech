package org.mod.ultimate_tech.core.registry.block.generator;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.common.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.core.registry.ModBlockUtils.simpleOre;

public class ModBlocksOre {
    // ------------------------
    // ORE BLOCKS
    // ------------------------
    public static final Map<ModMaterial, RegistryObject<Block>> ORES = new HashMap<>();
    public static void generate() {
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasOre()) continue;
            String name = material.getName() + "_ore";
            ORES.put(
                    material,
                    simpleOre(name)
            );
        }
    }
}
