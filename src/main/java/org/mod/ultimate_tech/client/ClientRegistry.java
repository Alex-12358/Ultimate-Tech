package org.mod.ultimate_tech.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.block.ElevatorBlock;
import org.mod.ultimate_tech.client.gui.ElevatorScreen;
import org.mod.ultimate_tech.client.render.ColorCamoElevator;
import org.mod.ultimate_tech.client.render.ElevatorBakedModel;
import org.mod.ultimate_tech.client.render.ToolItemColor;
import org.mod.ultimate_tech.common.init.Registry;
import org.mod.ultimate_tech.core.registry.item.tool.*;
import org.mod.ultimate_tech.common.init.Registry;

@Mod.EventBusSubscriber(modid = Ultimate_tech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistry {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(Registry.ELEVATOR_CONTAINER.get(), ElevatorScreen::new);
        event.enqueueWork(() -> {
        });
    }

    @SubscribeEvent
    public static void onBlockColorHandlersRegistry(RegisterColorHandlersEvent.Block e) {
        e.register(
                new ColorCamoElevator(),
                Registry.ELEVATOR_BLOCKS.values().stream().map(RegistryObject::get).toArray(ElevatorBlock[]::new)
        );
    }

    @SubscribeEvent
    public static void onItemColorHandlersRegistry(RegisterColorHandlersEvent.Item e) {
        ToolItemColor toolColor = new ToolItemColor();
        // Регистрируем все инструменты
        e.register(toolColor, ModItemsToolSword.SWORDS.values().stream().map(RegistryObject::get).toArray(Item[]::new));
        e.register(toolColor, ModItemsToolPickaxe.PICKAXES.values().stream().map(RegistryObject::get).toArray(Item[]::new));
        e.register(toolColor, ModItemsToolAxe.AXES.values().stream().map(RegistryObject::get).toArray(Item[]::new));
        e.register(toolColor, ModItemsToolShovel.SHOVELS.values().stream().map(RegistryObject::get).toArray(Item[]::new));
        e.register(toolColor, ModItemsToolHoe.HOES.values().stream().map(RegistryObject::get).toArray(Item[]::new));
    }


    @SubscribeEvent
    public static void onModelRegistry(ModelEvent.RegisterAdditional e) {
        e.register(new ResourceLocation("ultimate_tech", "arrow"));
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.ModifyBakingResult e) {
        e.getModels().entrySet().stream()
                .filter(entry -> "ultimate_tech".equals(entry.getKey().getNamespace()) && entry.getKey().getPath().contains("elevator_"))
                .forEach(entry -> e.getModels().put(entry.getKey(), new ElevatorBakedModel(entry.getValue())));
    }




}
