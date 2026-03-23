package org.mod.ultimate_tech.core.registry.item.material;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.core.registry.ModItemsUtils;
import org.mod.ultimate_tech.common.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModItemsPlate {
    public static final Map<ModMaterial, RegistryObject<Item>> PLATES = new HashMap<>();

    public static void generate() {

        for (ModMaterial material : ModMaterial.values()) {

            if (!material.hasPlate()) continue;

            String name = material.getName() + "_plate";

            PLATES.put(
                    material,
                    ModItemsUtils.ITEMS.register(name,
                            () -> new Item(new Item.Properties()))
            );

        }

    }
}
