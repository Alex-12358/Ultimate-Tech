package org.mod.ultimate_tech.item.custom_item;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.block.ModBlockUtils;
import org.mod.ultimate_tech.item.tool.ModItemToolTiers;

import java.util.function.Supplier;

public class ModItemsUtils {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Ultimate_tech.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

//    public static final

//    public static RegistryObject<Item> simpleSword(String name) {
//
//        return ModBlockUtils(
//                ITEMS,
//                name,
//                () -> new SwordItem(ModItemToolTiers.RUBY, 4, 2, new Item.Properties())
//        );
//    }

//    public static RegistryObject<Item> simplePickaxe(String name) {
//
//        return ModBlockUtils(
//                ITEMS,
//                name,
//                () -> new PickaxeItem(ModItemToolTiers.RUBY, 1, 1, new Item.Properties())
//        );
//    }

//    public static RegistryObject<Item> simpleAxe(String name) {
//
//        return ModBlockUtils(
//                ITEMS,
//                name,
//                () -> new AxeItem(ModItemToolTiers.RUBY, 7, 1, new Item.Properties())
//        );
//    }

//    public static RegistryObject<Item> simpleShovel(String name) {
//
//        return ModBlockUtils(
//                ITEMS,
//                name,
//                () -> new ShovelItem(ModItemToolTiers.RUBY, 0, 0, new Item.Properties())
//        );
//    }

//    public static RegistryObject<Item> simpleHoe(String name) {
//
//        return ModBlockUtils(
//                ITEMS,
//                name,
//                () -> new HoeItem(ModItemToolTiers.RUBY, 0, 0, new Item.Properties())
//        );
//    }

    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> supplier) {
        return ITEMS.register(name, supplier);
    }
}
