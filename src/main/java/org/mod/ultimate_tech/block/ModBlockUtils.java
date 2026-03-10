package org.mod.ultimate_tech.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.item.ModItems;

import java.util.function.Supplier;

public class ModBlockUtils {
    public static <T extends Block> RegistryObject<T> registerBlock(
            DeferredRegister<Block> register,
            String name,
            Supplier<T> block
    ) {

        RegistryObject<T> registered = register.register(name, block);

        ModItems.ITEMS.register(name,
                () -> new BlockItem(registered.get(), new Item.Properties()));

        return registered;
    }
}
