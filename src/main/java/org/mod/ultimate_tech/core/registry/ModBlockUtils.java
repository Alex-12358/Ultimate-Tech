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
    // Создание простого блока без таблицы лута
    public static RegistryObject<Block> simpleBlock(String name) {
        return simpleBlock(name, Blocks.IRON_BLOCK);
    }

    // Создание простого блока с указанием базового блока
    public static RegistryObject<Block> simpleBlock(String name, Block baseBlock) {
        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(baseBlock))
        );
    }

    // Создание блока без таблицы лута
    public static RegistryObject<Block> simpleBlockNoLoot(String name) {
        return simpleBlockNoLoot(name, Blocks.IRON_BLOCK);
    }

    // Создание блока без таблицы лута с указанием базового блока
    public static RegistryObject<Block> simpleBlockNoLoot(String name, Block baseBlock) {
        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(baseBlock).noLootTable())
        );
    }

    // Создание руды обычного типа
    public static RegistryObject<Block> simpleOre(String name) {
        return createOre(name, Blocks.STONE, SoundType.STONE);
    }

    // Создание руды в Deepslate
    public static RegistryObject<Block> simpleDeepslateOre(String name) {
        return createOre(name, Blocks.DEEPSLATE, SoundType.DEEPSLATE);
    }

    // Создание руды в Nether
    public static RegistryObject<Block> simpleNetherOre(String name) {
        return createOre(name, Blocks.NETHERRACK, SoundType.NETHERRACK);
    }

    // Создание руды в End
    public static RegistryObject<Block> simpleEndOre(String name) {
        return createOre(name, Blocks.END_STONE, SoundType.STONE);
    }

    // Внутренний метод для создания руды с параметрами
    private static RegistryObject<Block> createOre(String name, Block baseBlock, SoundType soundType) {
        return ModBlockUtils.registerBlock(
                BLOCKS,
                name,
                () -> new Block(BlockBehaviour.Properties.copy(baseBlock).sound(soundType))
        );
    }

    // Устаревший метод - используйте simpleBlockNoLoot вместо этого
    @Deprecated
    public static RegistryObject<Block> simpleBlockOff(String name) {
        return simpleBlockNoLoot(name);
    }
}
