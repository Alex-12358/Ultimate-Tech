package org.mod.ultimate_tech.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;
import org.mod.ultimate_tech.Ultimate_tech;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModBlurRenderer {
    private static final Logger LOGGER = LoggerFactory.getLogger("ultimate_tech");
    private static PostChain blur;
    private static int lastWidth, lastHeight;
    private static boolean initAttempted = false;

    public static void init() {
        if (initAttempted) {
            return;
        }
        initAttempted = true;

        Minecraft mc = Minecraft.getInstance();

        try {
            LOGGER.info("Initializing blur effect...");

            if (mc.getTextureManager() == null) {
                LOGGER.error("Texture manager is null!");
                return;
            }

            if (mc.getResourceManager() == null) {
                LOGGER.error("Resource manager is null!");
                return;
            }

            if (mc.getMainRenderTarget() == null) {
                LOGGER.error("Main render target is null!");
                return;
            }

            ResourceLocation blurLocation = ResourceLocation.fromNamespaceAndPath(Ultimate_tech.MOD_ID, "shaders/post/blur.json");
            LOGGER.info("Loading blur shader from: {}", blurLocation);

            blur = new PostChain(
                    mc.getTextureManager(),
                    mc.getResourceManager(),
                    mc.getMainRenderTarget(),
                    blurLocation
            );

            resize(mc);
            LOGGER.info("Blur effect initialized successfully!");
        } catch (Exception e) {
            LOGGER.error("Failed to initialize blur effect: {}", e.getMessage());
            LOGGER.error("Full stacktrace: ", e);
            blur = null;
        }
    }

    public static void resize(Minecraft mc) {
        if (blur != null) {
            int w = mc.getWindow().getWidth();
            int h = mc.getWindow().getHeight();

            try {
                blur.resize(w, h);
                lastWidth = w;
                lastHeight = h;
            } catch (Exception e) {
                LOGGER.error("Error resizing blur: {}", e.getMessage());
            }
        }
    }

    public static void render(float partialTicks) {
        Minecraft mc = Minecraft.getInstance();

        if (blur == null) return;

        try {
            if (mc.getWindow().getWidth() != lastWidth ||
                    mc.getWindow().getHeight() != lastHeight) {
                resize(mc);
            }

            blur.process(partialTicks);
        } catch (Exception e) {
            LOGGER.error("Error rendering blur: {}", e.getMessage());
        }
    }
}

