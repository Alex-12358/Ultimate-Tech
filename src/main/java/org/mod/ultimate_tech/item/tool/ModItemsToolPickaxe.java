package org.mod.ultimate_tech.item.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.item.custom_item.ModItemsUtils;
import org.mod.ultimate_tech.material.ModGames;

import java.util.HashMap;
import java.util.Map;

public class ModItemsToolPickaxe {
    public static final Map<ModGames, RegistryObject<Item>> PICKAXES = new HashMap<>();

    public static void generate() {
        for (ModGames material : ModGames.values()) {
            if (!material.hasPickaxe()) continue;

            Tier tier = ModItemToolTiers.getTier(material);

            PICKAXES.put(material, ModItemsUtils.registerItem(
                    material.getName() + "_pickaxe",
                    () -> new PickaxeItem(
                            tier,
                            material.getPickaxeDamage(),
                            material.getPickaxeSpeed(),
                            new Item.Properties()
                    )
            ));
        }
    }
}
