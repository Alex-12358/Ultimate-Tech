package org.mod.ultimate_tech.common.item.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.common.item.custom_item.ModItemsUtils;
import org.mod.ultimate_tech.common.material.ModGames;

import java.util.HashMap;
import java.util.Map;

public class ModItemsToolShovel {
    public static final Map<ModGames, RegistryObject<Item>> SHOVELS = new HashMap<>();

    public static void generate() {
        for (ModGames material : ModGames.values()) {
            if (!material.hasShovel()) continue;

            Tier tier = ModItemToolTiers.getTier(material);

            SHOVELS.put(material, ModItemsUtils.registerItem(
                    material.getName() + "_shovel",
                    () -> new ShovelItem(
                            tier,
                            material.getShovelDamage(),
                            material.getShovelSpeed(),
                            new Item.Properties()
                    )
            ));
        }
    }
}
