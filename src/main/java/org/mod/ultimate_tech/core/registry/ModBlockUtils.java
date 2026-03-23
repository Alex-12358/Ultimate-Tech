package org.mod.ultimate_tech.core.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;

import java.util.function.Supplier;

public class ModBlockUtils {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Ultimate_tech.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static <T extends Block> RegistryObject<T> registerBlock(
            DeferredRegister<Block> register,
            String name,
            Supplier<T> block
    ) {

        RegistryObject<T> registered = register.register(name, block);

        ModItemsUtils.ITEMS.register(name,
                () -> new BlockItem(registered.get(), new Item.Properties()));

        return registered;
    }
    // если нету крафтов
    public static RegistryObject<Block> simpleBlock(String name) {

        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK))
        );

    }
    // Обычная руда
    public static RegistryObject<Block> simpleOre(String name) {

        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                        .sound(SoundType.STONE))
        );

    }
    // Глубинная руда
    public static RegistryObject<Block> simpleDeepslateOre(String name) {

        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                        .sound(SoundType.DEEPSLATE))
        );

    }
    // Незер руда
    public static RegistryObject<Block> simpleNetherOre(String name) {

        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                        .sound(SoundType.NETHERRACK))
        );

    }
    // Энд руда
    public static RegistryObject<Block> simpleEndOre(String name) {

        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                        .sound(SoundType.STONE))
        );

    }
    // если нету крафтов
    public static RegistryObject<Block> simpleBlockOff(String name) {

        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable())
        );

    }
}
