package org.mod.ultimate_tech.client.ui;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.core.registry.block.generator.*;

public class ModCreativeTabBlocks {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultimate_tech.MOD_ID);


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
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
