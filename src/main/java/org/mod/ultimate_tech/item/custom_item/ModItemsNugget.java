package org.mod.ultimate_tech.item.custom_item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModItemsNugget {
    public static final Map<ModMaterial, RegistryObject<Item>> NUGGETS = new HashMap<>();

    public static void generate() {

        for (ModMaterial material : ModMaterial.values()) {

            if (!material.hasNugget()) continue;

            String name = material.getName() + "_nugget";

            NUGGETS.put(
                    material,
                    ModItemsUtils.ITEMS.register(name,
                            () -> new Item(new Item.Properties()))
            );

        }

    }
}
