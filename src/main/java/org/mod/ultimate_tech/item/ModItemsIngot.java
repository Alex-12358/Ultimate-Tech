package org.mod.ultimate_tech.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModItemsIngot {
    public static final Map<ModMaterial, RegistryObject<Item>> INGOTS = new HashMap<>();

    public static void register() {

        for (ModMaterial material : ModMaterial.values()) {

            // создаём слиток только если он существует
            if (!material.hasIngot()) continue;

            String name = material.getName() + "_ingot";

            INGOTS.put(
                    material,
                    ModItemsUtils.ITEMS.register(name,
                            () -> new Item(new Item.Properties()))
            );

        }

    }
}
