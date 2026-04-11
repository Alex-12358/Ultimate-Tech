package org.mod.ultimate_tech.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.client.render.ModBlurRenderer;

@Mod.EventBusSubscriber(modid = Ultimate_tech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientForgeEvents {

    @SubscribeEvent
    public static void onResize(ViewportEvent event) {
        ModBlurRenderer.resize(net.minecraft.client.Minecraft.getInstance());
    }
}

