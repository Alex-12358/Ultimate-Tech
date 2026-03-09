package org.mod.ultimate_tech.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultimate_tech.MOD_ID);


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> FIRST_TAB = CREATIVE_MODE_TABS.register("first_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.ALUMINUM_ROD.get()))
            .title(Component.translatable("creativetab.first_tab"))
            .withSearchBar()
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.ALUMINUM_ROD.get());
                pOutput.accept(ModItems.BRASS_ROD.get());
                pOutput.accept(ModItems.BRONZE_ROD.get());
                pOutput.accept(ModItems.CONSTANTAN_ROD.get());
                pOutput.accept(ModItems.COPPER_ROD.get());
                pOutput.accept(ModItems.DIAMOND_ROD.get());
                pOutput.accept(ModItems.ELECTRUM_ROD.get());
                pOutput.accept(ModItems.ENDERIUM_ROD.get());
                pOutput.accept(ModItems.GOLD_ROD.get());
                pOutput.accept(ModItems.INVAR_ROD.get());
                pOutput.accept(ModItems.IRIDIUM_ROD.get());
                pOutput.accept(ModItems.IRON_ROD.get());
                pOutput.accept(ModItems.LEAD_ROD.get());
                pOutput.accept(ModItems.LUMIUM_ROD.get());
                pOutput.accept(ModItems.NICKEL_ROD.get());
                pOutput.accept(ModItems.OSMIUM_ROD.get());
                pOutput.accept(ModItems.PLATINUM_ROD.get());
                pOutput.accept(ModItems.SIGNALUM_ROD.get());
                pOutput.accept(ModItems.SILVER_ROD.get());
                pOutput.accept(ModItems.STEEL_ROD.get());
                pOutput.accept(ModItems.TIN_ROD.get());
                pOutput.accept(ModItems.URANIUM_ROD.get());
                pOutput.accept(ModItems.ZINC_ROD.get());
                pOutput.accept(ModBlocks.CORE_STRUCTURAL_BLOCK.get());
                pOutput.accept(ModBlocks.MACHINE_STRUCTURAL_HOUSING.get());
            })
            .build());
}
