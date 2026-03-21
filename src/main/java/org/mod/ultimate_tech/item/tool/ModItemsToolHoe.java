package org.mod.ultimate_tech.item.tool;

import net.minecraft.world.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.item.custom_item.ModItemsUtils;
import org.mod.ultimate_tech.material.ModGames;

import java.util.HashMap;
import java.util.Map;

public class ModItemsToolHoe {
    public static final Map<ModGames, RegistryObject<Item>> HOES = new HashMap<>();

    public static void generate() {
        for (ModGames material : ModGames.values()) {
            if (!material.hasHoe()) continue;

            Tier tier = ModItemToolTiers.getTier(material);

            HOES.put(material, ModItemsUtils.registerItem(
                    material.getName() + "_hoe",
                    () -> new HoeItem(
                            tier,
                            material.getHoeDamage(),
                            material.getHoeSpeed(),
                            new Item.Properties()
                    )
            ));
        }
    }
}
