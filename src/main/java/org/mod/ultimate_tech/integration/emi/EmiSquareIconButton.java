package org.mod.ultimate_tech.integration.emi;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.function.BooleanSupplier;

/**
 * Square button that renders either custom texture icon or item icon.
 */
public class EmiSquareIconButton extends Button {
    private final ResourceLocation textureIcon;
    private final ItemStack configuredItemIcon;
    private final ItemStack fallbackItemIcon;
    private final BooleanSupplier selectedSupplier;

    public EmiSquareIconButton(
            int x,
            int y,
            int size,
            Component tooltip,
            ResourceLocation textureIcon,
            ItemStack configuredItemIcon,
            ItemStack fallbackItemIcon,
            BooleanSupplier selectedSupplier,
            OnPress onPress
    ) {
        super(x, y, size, size, Component.empty(), onPress, DEFAULT_NARRATION);
        this.textureIcon = textureIcon;
        this.configuredItemIcon = configuredItemIcon == null ? ItemStack.EMPTY : configuredItemIcon;
        this.fallbackItemIcon = fallbackItemIcon == null ? ItemStack.EMPTY : fallbackItemIcon;
        this.selectedSupplier = selectedSupplier == null ? () -> false : selectedSupplier;
        this.setTooltip(Tooltip.create(tooltip));
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);

        int iconX = getX() + (this.width - 16) / 2;
        int iconY = getY() + (this.height - 16) / 2;

        if (textureIcon != null) {
            guiGraphics.blit(textureIcon, iconX, iconY, 0, 0, 16, 16, 16, 16);
        } else {
            ItemStack icon = configuredItemIcon.isEmpty() ? fallbackItemIcon : configuredItemIcon;
            if (!icon.isEmpty()) {
                guiGraphics.renderItem(icon, iconX, iconY);
            }
        }

        if (selectedSupplier.getAsBoolean()) {
            int x0 = getX();
            int y0 = getY();
            int x1 = x0 + this.width;
            int y1 = y0 + this.height;
            int color = 0xCC63C74D;
            guiGraphics.fill(x0, y0, x1, y0 + 1, color);
            guiGraphics.fill(x0, y1 - 1, x1, y1, color);
            guiGraphics.fill(x0, y0, x0 + 1, y1, color);
            guiGraphics.fill(x1 - 1, y0, x1, y1, color);
        }
    }
}

