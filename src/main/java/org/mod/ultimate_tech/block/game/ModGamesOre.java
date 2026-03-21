package org.mod.ultimate_tech.block.game;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModGames;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.block.ModBlockUtils.simpleBlock;
import static org.mod.ultimate_tech.block.ModBlockUtils.simpleOre;

public class ModGamesOre {
    // CORE BLOCKS
    // ------------------------

    public static final Map<ModGames, RegistryObject<Block>> ORES = new HashMap<>();

    public static void generate() {

        for (ModGames material : ModGames.values()) {
            if (!material.hasOre()) continue;
            String name = material.getName() + "_ore";
            ORES.put(
                    material,
                    simpleOre(name)
            );
        }

    }
}
