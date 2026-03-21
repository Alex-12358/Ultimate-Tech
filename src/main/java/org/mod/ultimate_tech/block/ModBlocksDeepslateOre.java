package org.mod.ultimate_tech.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.block.ModBlockUtils.simpleDeepslateOre;

public class ModBlocksDeepslateOre {

    public static final Map<ModMaterial, RegistryObject<Block>> ORES = new HashMap<>();

    public static void generate() {
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasDeepOre()) continue;
            String name = "deepslate_" + material.getName() + "_ore";
            ORES.put(
                    material,
                    simpleDeepslateOre(name)
            );
        }

    }

}
