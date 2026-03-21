package org.mod.ultimate_tech.common.item.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.common.item.custom_item.ModItemsUtils;
import org.mod.ultimate_tech.common.material.ModGames;

import java.util.HashMap;
import java.util.Map;

public class ModItemsToolSword {
    public static final Map<ModGames, RegistryObject<Item>> SWORDS = new HashMap<>();

    public static void generate() {
        for (ModGames material : ModGames.values()) {
            if (!material.hasSword()) continue;

            Tier tier = ModItemToolTiers.getTier(material);

            SWORDS.put(material, ModItemsUtils.registerItem(
                    material.getName() + "_sword",
                    () -> new SwordItem(
                            tier,
                            material.getSwordDamage(),
                            material.getSwordSpeed(),
                            new Item.Properties()
                    )
            ));
        }
    }
}
