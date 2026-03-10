package org.mod.ultimate_tech.ui;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.block.*;
import org.mod.ultimate_tech.item.*;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultimate_tech.MOD_ID);


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    // =========================
    // ALL ITEMS TAB
    // =========================

    public static final RegistryObject<CreativeModeTab> ALL_TAB =
            CREATIVE_MODE_TABS.register("all_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.NETHER_STAR))
                    .title(Component.translatable("creativetab.ultimate_tech.all"))
                    .withSearchBar()
                    .displayItems((params, output) -> {

                        ModItemsRod.RODS.values().forEach(item -> output.accept(item.get()));
                        ModItemsIngot.INGOTS.values().forEach(item -> output.accept(item.get()));
                        ModItemsPlate.PLATES.values().forEach(item -> output.accept(item.get()));
                        ModItemsDust.DUSTS.values().forEach(item -> output.accept(item.get()));
                        ModItemsNugget.NUGGETS.values().forEach(item -> output.accept(item.get()));
                        ModItemsRaw.RAW_ITEMS.values().forEach(item -> output.accept(item.get()));


                        ModBlocksOre.ORES.values().forEach(block -> output.accept(block.get()));
                        ModBlocksDeepslateOre.ORES.values().forEach(block -> output.accept(block.get()));
                        ModBlocksRaw.RAW_BLOCKS.values().forEach(block -> output.accept(block.get()));
                        ModBlocksBlock.BLOCK.values().forEach(block -> output.accept(block.get()));
                        ModBlocksNetherOre.ORES.values().forEach(block -> output.accept(block.get()));
                        ModBlocksEndOre.ORES.values().forEach(block -> output.accept(block.get()));

                    }).build());


    // =========================
    // RODS
    // =========================

    public static final RegistryObject<CreativeModeTab> RODS_TAB =
            CREATIVE_MODE_TABS.register("rods_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.BLAZE_ROD))
                    .title(Component.translatable("creativetab.ultimate_tech.rods"))
                    .displayItems((params, output) ->
                            ModItemsRod.RODS.values().forEach(item -> output.accept(item.get()))
                    ).build());


    // =========================
    // INGOTS
    // =========================

    public static final RegistryObject<CreativeModeTab> INGOTS_TAB =
            CREATIVE_MODE_TABS.register("ingots_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.IRON_INGOT))
                    .title(Component.translatable("creativetab.ultimate_tech.ingots"))
                    .displayItems((params, output) ->
                            ModItemsIngot.INGOTS.values().forEach(item -> output.accept(item.get()))
                    ).build());


    // =========================
    // PLATES
    // =========================

    public static final RegistryObject<CreativeModeTab> PLATES_TAB =
            CREATIVE_MODE_TABS.register("plates_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.IRON_TRAPDOOR))
                    .title(Component.translatable("creativetab.ultimate_tech.plates"))
                    .displayItems((params, output) ->
                            ModItemsPlate.PLATES.values().forEach(item -> output.accept(item.get()))
                    ).build());


    // =========================
    // DUSTS
    // =========================

    public static final RegistryObject<CreativeModeTab> DUST_TAB =
            CREATIVE_MODE_TABS.register("dust_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.GUNPOWDER))
                    .title(Component.translatable("creativetab.ultimate_tech.dusts"))
                    .displayItems((params, output) ->
                            ModItemsDust.DUSTS.values().forEach(item -> output.accept(item.get()))
                    ).build());


    // =========================
    // NUGGETS
    // =========================

    public static final RegistryObject<CreativeModeTab> NUGGET_TAB =
            CREATIVE_MODE_TABS.register("nugget_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.GOLD_NUGGET))
                    .title(Component.translatable("creativetab.ultimate_tech.nuggets"))
                    .displayItems((params, output) ->
                            ModItemsNugget.NUGGETS.values().forEach(item -> output.accept(item.get()))
                    ).build());


    // =========================
    // ORES
    // =========================

    public static final RegistryObject<CreativeModeTab> ORE_TAB =
            CREATIVE_MODE_TABS.register("ore_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIAMOND_ORE))
                    .title(Component.translatable("creativetab.ultimate_tech.ores"))
                    .displayItems((params, output) -> {

                        ModBlocksOre.ORES.values().forEach(block -> output.accept(block.get()));
                        ModBlocksDeepslateOre.ORES.values().forEach(block -> output.accept(block.get()));

                    }).build());


    // =========================
    // STORAGE BLOCKS
    // =========================

    public static final RegistryObject<CreativeModeTab> BLOCK_TAB =
            CREATIVE_MODE_TABS.register("block_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.IRON_BLOCK))
                    .title(Component.translatable("creativetab.ultimate_tech.blocks"))
                    .displayItems((params, output) ->
                            ModBlocksBlock.BLOCK.values().forEach(block -> output.accept(block.get()))
                    ).build());


    // =========================
    // RAW BLOCKS
    // =========================

    public static final RegistryObject<CreativeModeTab> RAW_BLOCK_TAB =
            CREATIVE_MODE_TABS.register("raw_block_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.RAW_IRON_BLOCK))
                    .title(Component.translatable("creativetab.ultimate_tech.raw_blocks"))
                    .displayItems((params, output) ->
                            ModBlocksRaw.RAW_BLOCKS.values().forEach(block -> output.accept(block.get()))
                    ).build());


    // =========================
    // RAW ITEMS
    // =========================

    public static final RegistryObject<CreativeModeTab> RAW_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("raw_items_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.RAW_IRON))
                    .title(Component.translatable("creativetab.ultimate_tech.raw_items"))
                    .displayItems((params, output) ->
                            ModItemsRaw.RAW_ITEMS.values().forEach(item -> output.accept(item.get()))
                    ).build());


    // =========================
    // NETHER ORES
    // =========================

    public static final RegistryObject<CreativeModeTab> NETHER_ORE_TAB =
            CREATIVE_MODE_TABS.register("nether_ore_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.NETHER_QUARTZ_ORE))
                    .title(Component.translatable("creativetab.ultimate_tech.nether_ores"))
                    .displayItems((params, output) ->
                            ModBlocksNetherOre.ORES.values().forEach(block -> output.accept(block.get()))
                    ).build());


    // =========================
    // END ORES
    // =========================

    public static final RegistryObject<CreativeModeTab> END_ORE_TAB =
            CREATIVE_MODE_TABS.register("end_ore_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.END_STONE))
                    .title(Component.translatable("creativetab.ultimate_tech.end_ores"))
                    .displayItems((params, output) ->
                            ModBlocksEndOre.ORES.values().forEach(block -> output.accept(block.get()))
                    ).build());


}
