package org.mod.ultimate_tech;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.mod.ultimate_tech.block.*;
import org.mod.ultimate_tech.block.custom.ModBlocks;
import org.mod.ultimate_tech.item.*;
import org.mod.ultimate_tech.ui.ModCreativeModTabs;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ultimate_tech.MOD_ID)
public class Ultimate_tech {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ultimate_tech";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Ultimate_tech() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //item
        ModItemsRod.register();
        ModItemsIngot.register();
        ModItemsPlate.register();
        ModItemsDust.register();
        ModItemsNugget.register();
        ModItemsRaw.register();
        ModItemsUtils.register(modEventBus);
        //block
        ModBlocksOre.generate();
        ModBlocksDeepslateOre.generate();
        ModBlocksBlock.generate();
        ModBlocksRaw.generate();
        ModBlocksNetherOre.generate();
        ModBlocksEndOre.generate();
        ModBlockUtils.register(modEventBus);
        //creative
        ModCreativeModTabs.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
