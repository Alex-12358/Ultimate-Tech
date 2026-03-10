package org.mod.ultimate_tech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModBlocksOre {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Ultimate_tech.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static RegistryObject<Block> simpleBlock(String name) {

        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK))
        );

    }

    // CORE BLOCKS
    // ------------------------

    public static final RegistryObject<Block> CORE_STRUCTURAL_BLOCK = simpleBlock("core_structural_block");
    public static final RegistryObject<Block> MACHINE_STRUCTURAL_HOUSING = simpleBlock("machine_structural_housing");


    public static final Map<ModMaterial, RegistryObject<Block>> ORES = new HashMap<>();

    public static void generate() {

        for (ModMaterial material : ModMaterial.values()) {

            if (material.hasOre()) continue;

            String name = material.getName() + "_ore";

            ORES.put(
                    material,
                    simpleBlock(name)
            );
        }

    }
}
