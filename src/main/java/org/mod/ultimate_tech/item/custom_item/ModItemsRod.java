package org.mod.ultimate_tech.item.custom_item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.item.custom_item.ModItemsUtils.ITEMS;

public class ModItemsRod {
    public static final Map<ModMaterial, RegistryObject<Item>> RODS = new HashMap<>();
    public static void generate() {
        for (ModMaterial material : ModMaterial.values()) {
            if (!material.hasRod()) continue;
            String name = material.getName() + "_rod";
            RODS.put(
                    material,
                    ITEMS.register(name,
                            () -> new Item(new Item.Properties())
                    )
            );
        }
    }
}
