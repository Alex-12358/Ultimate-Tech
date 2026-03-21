package org.mod.ultimate_tech.block.game;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModGames;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.block.ModBlockUtils.simpleBlock;
import static org.mod.ultimate_tech.block.ModBlockUtils.simpleDeepslateOre;

public class ModGamesDeepslateOre {

    public static final Map<ModGames, RegistryObject<Block>> ORES = new HashMap<>();

    public static void generate() {
        for (ModGames material : ModGames.values()) {
            if (!material.hasDeepOre()) continue;
            String name = "deepslate_" + material.getName() + "_ore";
            ORES.put(
                    material,
                    simpleDeepslateOre(name)
            );
        }

    }

}
