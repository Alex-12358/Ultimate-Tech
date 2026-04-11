package org.mod.ultimate_tech.client.render;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.PostChain;
import org.mod.ultimate_tech.Ultimate_tech;
import org.slf4j.Logger;

public class ModBlurRenderer {

    private static final Logger LOGGER = LogUtils.getLogger();

    private PostChain blur;

    public void init() {
        Minecraft mc = Minecraft.getInstance();
        LOGGER.info("Initializing blur effect...");

        ResourceLocation blurLocation = new ResourceLocation(Ultimate_tech.MOD_ID, "shaders/post/blur.json");
        LOGGER.info("Loading blur shader from: {}", blurLocation);

        try {
            blur = new PostChain(
                    mc.getTextureManager(),
                    mc.getResourceManager(),
                    mc.getMainRenderTarget(),
                    blurLocation
            );
            blur.resize(mc.getWindow().getWidth(), mc.getWindow().getHeight());
            LOGGER.info("Blur effect initialized successfully.");
        } catch (Exception e) {
            LOGGER.error("Failed to initialize blur effect: {}", e.toString());
            LOGGER.error("Full stacktrace: ", e);
            blur = null;
        }
    }

    public void render(float partialTick) {
        if (blur != null) {
            blur.process(partialTick);
        }
    }

    public void resize(int width, int height) {
        if (blur != null) {
            blur.resize(width, height);
        }
    }

    public void close() {
        if (blur != null) {
            blur.close();
            blur = null;
        }
    }
}
