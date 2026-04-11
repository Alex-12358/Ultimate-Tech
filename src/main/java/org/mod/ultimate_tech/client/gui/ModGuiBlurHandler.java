package org.mod.ultimate_tech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.mod.ultimate_tech.client.render.ModBlurRenderer;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModGuiBlurHandler {

    @SubscribeEvent
    public static void onRenderScreen(ScreenEvent.Render.Post event) {
        Minecraft mc = Minecraft.getInstance();
        ModBlurRenderer.render(mc.getFrameTime());

        // Рисуем полупрозрачный оверлей
        GuiGraphics gui = event.getGuiGraphics();

        gui.fill(
                0, 0,
                mc.getWindow().getGuiScaledWidth(),
                mc.getWindow().getGuiScaledHeight(),
                0x8879F694
        );
    }
}
