package org.mod.ultimate_tech.core.registry.item.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

/**
 * Custom Sword Item with multi-layered texture support
 * Layer 0: Handle (палка) - неизменяемая текстура
 * Layer 1: Blade (лезвие) - изменяемый цвет
 */
public class ColoredSwordItem extends SwordItem {
    private final int colorHex;

    public ColoredSwordItem(Tier tier, int damage, float attackSpeed, int colorHex) {
        super(tier, damage, attackSpeed, new Item.Properties());
        this.colorHex = colorHex;
    }


    public int getColorHex() {
        return colorHex;
    }
}

