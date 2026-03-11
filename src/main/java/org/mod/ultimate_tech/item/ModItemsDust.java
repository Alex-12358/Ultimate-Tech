package org.mod.ultimate_tech.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModItemsDust {
    public static final Map<ModMaterial, RegistryObject<Item>> DUSTS = new HashMap<>();

    public static void register() {

        for (ModMaterial material : ModMaterial.values()) {

            String name = material.getName() + "_dust";

            DUSTS.put(
                    material,
                    ModItemsUtils.ITEMS.register(name,
                            () -> new Item(new Item.Properties()))
            );

        }

    }

}
