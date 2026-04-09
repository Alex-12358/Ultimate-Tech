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
import org.mod.ultimate_tech.core.registry.fluid.ModFluidsRegistry;

public class ModCreativeTabFluid {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultimate_tech.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    // ========================= FLUID TAB =========================
    public static final RegistryObject<CreativeModeTab> FLUID_TAB =
            CREATIVE_MODE_TABS.register("fluid_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.NETHER_STAR))
                    .title(Component.translatable("creativetab.ultimate_tech.fluid"))
                    .displayItems((params, output) -> {
                        // Добавляем все ведра жидкостей из ModFluidsRegistry
                        ModFluidsRegistry.FLUID_SETS.values().forEach(fluidSet -> 
                            output.accept(fluidSet.bucket.get())
                        );
                    }).build());
}


