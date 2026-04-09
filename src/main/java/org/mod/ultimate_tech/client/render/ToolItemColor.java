package org.mod.ultimate_tech.client.render;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.mod.ultimate_tech.common.material.ModGames;
import org.mod.ultimate_tech.core.registry.item.tool.*;

public class ToolItemColor implements ItemColor {

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        // Проверяем наличие второго слоя (tintIndex == 1 для layer1)
        if (tintIndex != 1) {
            return -1; // -1 означает без тинта для первого слоя
        }

        Item item = stack.getItem();

        // Проверяем для каждого типа инструмента
        for (ModGames material : ModGames.values()) {
            // Проверка мечей
            if (ModItemsToolSword.SWORDS.containsKey(material) &&
                ModItemsToolSword.SWORDS.get(material).get() == item) {
                return material.getColorHex();
            }

            // Проверка кирок
            if (ModItemsToolPickaxe.PICKAXES.containsKey(material) &&
                ModItemsToolPickaxe.PICKAXES.get(material).get() == item) {
                return material.getColorHex();
            }

            // Проверка топоров
            if (ModItemsToolAxe.AXES.containsKey(material) &&
                ModItemsToolAxe.AXES.get(material).get() == item) {
                return material.getColorHex();
            }

            // Проверка лопат
            if (ModItemsToolShovel.SHOVELS.containsKey(material) &&
                ModItemsToolShovel.SHOVELS.get(material).get() == item) {
                return material.getColorHex();
            }

            // Проверка мотык
            if (ModItemsToolHoe.HOES.containsKey(material) &&
                ModItemsToolHoe.HOES.get(material).get() == item) {
                return material.getColorHex();
            }
        }

        return -1; // Не найден цвет по умолчанию
    }
}

