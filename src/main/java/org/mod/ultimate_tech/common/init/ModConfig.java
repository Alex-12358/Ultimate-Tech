package org.mod.ultimate_tech.common.init;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.logging.log4j.LogManager;
import org.mod.ultimate_tech.Ultimate_tech;

import static net.minecraftforge.fml.Logging.FORGEMOD;

@Mod.EventBusSubscriber(modid = Ultimate_tech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfig {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final CommonGeneral GENERAL = new CommonGeneral(BUILDER);
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static final ForgeConfigSpec.DoubleValue BLUR_RADIUS;

    static {
        BUILDER.push("Blur Settings");

        BLUR_RADIUS = BUILDER
                .comment("Blur strength (1.0 - 20.0)")
                .defineInRange("blurRadius", 5.0, 1.0, 20.0);

        BUILDER.pop();
    }

    public static class CommonGeneral {
        public final ForgeConfigSpec.BooleanValue sameColor;
        public final ForgeConfigSpec.BooleanValue precisionTarget;
        public final ForgeConfigSpec.BooleanValue mobSpawn;
        public final ForgeConfigSpec.BooleanValue resetPitchNormal;
        public final ForgeConfigSpec.BooleanValue resetPitchDirectional;
        public final ForgeConfigSpec.IntValue range;
        public final ForgeConfigSpec.BooleanValue useXP;
        public final ForgeConfigSpec.IntValue XPPointsAmount;

        CommonGeneral(ForgeConfigSpec.Builder builder) {
            builder.push("General");

            sameColor = builder
                    .comment("Should elevators have the same color in order to teleport ?")
                    .define("sameColor", false);

            range = builder
                    .comment("Elevator range")
                    .defineInRange("range", 384, 3, 4064);

            precisionTarget = builder
                    .comment("Realign players to the center of elevator ?")
                    .define("precisionTarget", true);

            mobSpawn = builder
                    .worldRestart()
                    .comment("Can mobs spawn on elevators ?")
                    .define("mobSpawn", false);

            resetPitchNormal = builder
                    .comment("Reset pitch to 0 when teleporting to normal elevators ?")
                    .define("resetPitchNormal", false);

            resetPitchDirectional = builder
                    .comment("Reset pitch to 0 when teleporting to directional elevators ?")
                    .define("resetPitchDirectional", true);

            useXP = builder
                    .comment("Should teleporting require XP ?")
                    .define("useXP", false);

            XPPointsAmount = builder
                    .comment("Amount of XP points to use when useXP is enabled", "Note this is NOT experience levels")
                    .defineInRange("XPPointsAmount", 1, 1, Integer.MAX_VALUE);

            builder.pop();
        }
    }

    // Same debug messages as forge config

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) {
        LogManager.getLogger().debug(FORGEMOD, "Loaded elevator config file {}", configEvent.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
        LogManager.getLogger().debug(FORGEMOD, "Elevator config just got changed on the file system!");
    }
}
