package org.mod.ultimate_tech.block.game;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModGames;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.block.ModBlockUtils.simpleBlock;

public class ModGamesBlock {

    public static final Map<ModGames, RegistryObject<Block>> BLOCK = new HashMap<>();
    public static void generate() {

        for (ModGames material : ModGames.values()) {
            if (!material.hasBlock()) continue;
            String name = material.getName() + "_block";
            BLOCK.put(
                    material,
                    simpleBlock(name)
            );
        }

    }
}
