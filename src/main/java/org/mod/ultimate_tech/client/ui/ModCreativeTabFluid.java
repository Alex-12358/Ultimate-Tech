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
import org.mod.ultimate_tech.core.registry.fluid.ModFluids;
import org.mod.ultimate_tech.core.registry.item.tool.*;

public class ModCreativeTabFluid {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultimate_tech.MOD_ID);


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
    // =========================
    // CUSTOM
    // =========================

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB =
            CREATIVE_MODE_TABS.register("fluid_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.NETHER_STAR))
                    .title(Component.translatable("creativetab.ultimate_tech.fluid"))
                    .displayItems((params, output) -> {

                        ModFluids.FLUID.values().forEach(fluid -> output.accept(fluid.bucket.get()));
                    }).build());
}
