package org.mod.ultimate_tech.client.render;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.mod.ultimate_tech.Ultimate_tech;
import org.slf4j.Logger;

@OnlyIn(Dist.CLIENT)
public class ModBlurRenderer {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final ResourceLocation BLUR_POST_CHAIN = new ResourceLocation(Ultimate_tech.MOD_ID, "shaders/post/blur.json");

    private PostChain blurEffect;
    private boolean initialized = false;

    public void init(int width, int height) {
        Minecraft mc = Minecraft.getInstance();
        LOGGER.info("Initializing blur effect...");
        LOGGER.info("Loading blur shader from: {}", BLUR_POST_CHAIN);
        try {
            if (blurEffect != null) {
                blurEffect.close();
                blurEffect = null;
            }
            blurEffect = new PostChain(mc.getTextureManager(), mc.getResourceManager(), mc.getMainRenderTarget(), BLUR_POST_CHAIN);
            blurEffect.resize(width, height);
            initialized = true;
        } catch (Exception e) {
            LOGGER.error("Failed to initialize blur effect", e);
            initialized = false;
        }
    }

    public void render(float partialTick) {
        if (!initialized || blurEffect == null) return;

        blurEffect.process(partialTick);
        Minecraft.getInstance().getMainRenderTarget().bindWrite(false);
    }

    public void resize(int width, int height) {
        if (blurEffect != null) {
            blurEffect.resize(width, height);
        }
    }

    public void close() {
        if (blurEffect != null) {
            blurEffect.close();
            blurEffect = null;
        }
        initialized = false;
    }

    public boolean isInitialized() {
        return initialized;
    }
}
