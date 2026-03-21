package org.mod.ultimate_tech.item.custom_item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.item.custom_item.ModItemsUtils.ITEMS;

public class ModItemsRaw {
    public static final Map<ModMaterial, RegistryObject<Item>> RAW_ITEMS = new HashMap<>();
    public static void generate() {
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasItemRaw()) continue;
            String name = "raw_" + material.getName();
            RAW_ITEMS.put(
                    material,
                    ITEMS.register(name,
                            () -> new Item(new Item.Properties()))
            );
        }
    }
}

