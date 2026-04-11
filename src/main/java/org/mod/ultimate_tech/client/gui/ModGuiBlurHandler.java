package org.mod.ultimate_tech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.client.render.ModBlurRenderer;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Ultimate_tech.MOD_ID, value = Dist.CLIENT)
public class ModGuiBlurHandler {

    private static ModBlurRenderer blurRenderer;
    private static boolean blurActive = false;

    @SubscribeEvent
    public static void onScreenOpen(ScreenEvent.Opening event) {
        if (event.getScreen() != null) {
            enableBlur();
        }
    }

    @SubscribeEvent
    public static void onScreenClose(ScreenEvent.Closing event) {
        disableBlur();
    }

    @SubscribeEvent
    public static void onScreenRender(ScreenEvent.Render.Pre event) {
        if (blurActive && blurRenderer != null && blurRenderer.isInitialized()) {
            blurRenderer.render(event.getPartialTick());
        }
    }

    public static void enableBlur() {
        Minecraft mc = Minecraft.getInstance();
        if (blurRenderer == null) {
            blurRenderer = new ModBlurRenderer();
        }
        if (!blurRenderer.isInitialized()) {
            blurRenderer.init(mc.getWindow().getWidth(), mc.getWindow().getHeight());
        }
        blurActive = true;
    }

    public static void disableBlur() {
        if (blurRenderer != null) {
            blurRenderer.close();
            blurRenderer = null;
        }
        blurActive = false;
    }

    public static boolean isBlurActive() {
        return blurActive;
    }
}
