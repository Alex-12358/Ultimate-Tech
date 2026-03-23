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
import org.mod.ultimate_tech.core.registry.block.custom.ModCustomBlocks;
import org.mod.ultimate_tech.core.registry.item.tool.*;

public class ModCreativeTabTools {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultimate_tech.MOD_ID);


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
    // =========================
    // CUSTOM
    // =========================

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB =
            CREATIVE_MODE_TABS.register("custom_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.NETHER_STAR))
                    .title(Component.translatable("creativetab.ultimate_tech.all"))
                    .displayItems((params, output) -> {

                        output.accept(ModCustomBlocks.BATTERY.get());

                        ModItemsToolSword.SWORDS.values().forEach(item -> output.accept(item.get()));
                        ModItemsToolPickaxe.PICKAXES.values().forEach(item -> output.accept(item.get()));
                        ModItemsToolAxe.AXES.values().forEach(item -> output.accept(item.get()));
                        ModItemsToolShovel.SHOVELS.values().forEach(item -> output.accept(item.get()));
                        ModItemsToolHoe.HOES.values().forEach(item -> output.accept(item.get()));
                    }).build());
}
