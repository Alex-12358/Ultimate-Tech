package org.mod.ultimate_tech.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.block.ModBlocksOre.simpleBlock;

public class ModBlocksEndOre {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Ultimate_tech.MOD_ID);

    public static final Map<ModMaterial, RegistryObject<Block>> ORES = new HashMap<>();

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static void generate() {

        for (ModMaterial material : ModMaterial.values()) {

            if (!material.hasEndOre()) continue;

            String name = "end_stone_" + material.getName() + "_ore";

            ORES.put(
                    material,
                    simpleBlock(name)
            );
        }

    }

}
