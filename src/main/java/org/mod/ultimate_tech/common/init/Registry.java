package org.mod.ultimate_tech.common.init;

import io.netty.channel.ChannelFuture;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Config;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.block.ElevatorBlock;
import org.mod.ultimate_tech.common.tile.ElevatorContainer;
import org.mod.ultimate_tech.common.tile.ElevatorTileEntity;

import java.util.Arrays;
import java.util.EnumMap;

public class Registry {

    public static final EnumMap<DyeColor, RegistryObject<ElevatorBlock>> ELEVATOR_BLOCKS = new EnumMap<>(DyeColor.class);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ultimate_tech.MOD_ID);

    static {
        Arrays.stream(DyeColor.values()).forEach(color ->
                ELEVATOR_BLOCKS.put(color, BLOCKS.register("elevator_" + color.getName(), () -> new ElevatorBlock(color)))
        );
    }

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Ultimate_tech.MOD_ID);
    public static final RegistryObject<BlockEntityType<ElevatorTileEntity>> ELEVATOR_TILE_ENTITY = BLOCK_ENTITIES.register(
            "elevator_tile", () ->
                    BlockEntityType.Builder.of(
                            ElevatorTileEntity::new,
                            ELEVATOR_BLOCKS
                                    .values()
                                    .stream()
                                    .map(RegistryObject::get)
                                    .toArray(Block[]::new)
                    ).build(null)
    );

    public static final EnumMap<DyeColor, RegistryObject<BlockItem>> ELEVATOR_ITEMS = new EnumMap<>(DyeColor.class);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ultimate_tech.MOD_ID);

    static {
        ELEVATOR_BLOCKS.forEach((color, o) ->
                ELEVATOR_ITEMS.put(color, ITEMS.register("elevator_" + color.getName(), () -> new BlockItem(o.get(), new Item.Properties())))
        );
    }

    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Ultimate_tech.MOD_ID);
    public static final RegistryObject<MenuType<ElevatorContainer>> ELEVATOR_CONTAINER = CONTAINERS.register(
            "elevator_container", () ->
                    IForgeMenuType.create((windowId, inv, data) ->
                            new ElevatorContainer(windowId, data.readBlockPos(), inv.player)
                    )
    );

    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Ultimate_tech.MOD_ID);
    public static final RegistryObject<SoundEvent> TELEPORT_SOUND = SOUNDS.register(
            "teleport", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Ultimate_tech.MOD_ID, "teleport"))
    );
    public static final RegistryObject<SoundEvent> CAMOUFLAGE_SOUND = SOUNDS.register(
            "camouflage", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Ultimate_tech.MOD_ID, "camouflage"))
    );

    private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultimate_tech.MOD_ID);

    private static final RegistryObject<CreativeModeTab> ELEVATORS_TAB = CREATIVE_TABS.register("elevators_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> ELEVATOR_ITEMS.get(DyeColor.WHITE).get().getDefaultInstance())
                    .displayItems((params, output) -> ELEVATOR_ITEMS.values().forEach(item -> output.accept(item.get())))
                    .title(Component.translatable("creativetab.ultimate_tech.elevator"))
                    .build()
    );

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        CONTAINERS.register(modEventBus);
        SOUNDS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
    }

    // TODO: Config GUI
    /* @SubscribeEvent
    public static void configChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Ultimate_tech.MOD_ID)) {
            ChannelFuture ConfigManager;
            ConfigManager.sync(Ultimate_tech.MOD_ID, Config.Type.INSTANCE);
        }
    } */
}
