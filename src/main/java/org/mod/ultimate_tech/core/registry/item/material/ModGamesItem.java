package org.mod.ultimate_tech.core.registry.item.material;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.core.registry.ModItemsUtils;
import org.mod.ultimate_tech.common.material.ModGames;

import java.util.HashMap;
import java.util.Map;

public class ModGamesItem {
    public static final Map<ModGames, RegistryObject<Item>> INGOTS = new HashMap<>();

    public static void generate() {

        for (ModGames material : ModGames.values()) {
            if (!material.hasGames()) continue;
            String name = material.getName();
            INGOTS.put(
                    material,
                    ModItemsUtils.ITEMS.register(name,
                            () -> new Item(new Item.Properties()))
            );

        }

    }
}
