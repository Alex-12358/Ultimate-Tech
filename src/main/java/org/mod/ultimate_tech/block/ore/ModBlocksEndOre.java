package org.mod.ultimate_tech.block.ore;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.block.ore.ModBlockUtils.simpleEndOre;

public class ModBlocksEndOre {

    public static final Map<ModMaterial, RegistryObject<Block>> ORES = new HashMap<>();

    public static void generate() {
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasEndOre()) continue;
            String name = "end_stone_" + material.getName() + "_ore";
            ORES.put(
                    material,
                    simpleEndOre(name)
            );
        }

    }

}
