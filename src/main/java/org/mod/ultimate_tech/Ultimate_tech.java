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
import org.mod.ultimate_tech.client.ui.*;
import org.mod.ultimate_tech.common.init.Registry;
import org.mod.ultimate_tech.common.network.NetworkHandler;
import org.mod.ultimate_tech.core.registry.ModFluidUtils;
import org.mod.ultimate_tech.core.registry.fluid.ModFluidsRegistry;
import org.mod.ultimate_tech.core.registry.fluid.FluidTypesRegistry;
import org.mod.ultimate_tech.core.registry.ModBlockUtils;
import org.mod.ultimate_tech.core.registry.ModItemsUtils;
import org.mod.ultimate_tech.core.registry.RegistryInitializer;
import org.mod.ultimate_tech.integration.botarium.ModBlockEntities;
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

        // Инициализируем все компоненты через централизованный инициализатор
        RegistryInitializer.initializeAll();

        // Регистрируем все компоненты в событийной шине
        ModFluidUtils.register(modEventBus);
        FluidTypesRegistry.register(modEventBus);
        ModFluidsRegistry.register(modEventBus);
        ModItemsUtils.register(modEventBus);
        ModBlockUtils.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        // Регистрируем вкладки творческого режима
        ModCreativeTabFluid.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModCreativeTabBlocks.register(modEventBus);
        ModCreativeTabTools.register(modEventBus);
        ModCreativeTabItems.register(modEventBus);

        modEventBus.addListener(Ultimate_tech::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        Registry.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, org.mod.ultimate_tech.common.init.ModConfig.SPEC);

    }

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event) {
        NetworkHandler.init();
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
