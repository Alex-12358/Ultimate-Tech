package org.mod.ultimate_tech.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, Ultimate_tech.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    public static final RegistryObject<Item> ALUMINUM_ROD = registerItem("aluminum_rod");
    public static final RegistryObject<Item> BRASS_ROD = registerItem("brass_rod");
    public static final RegistryObject<Item> BRONZE_ROD = registerItem("bronze_rod");
    public static final RegistryObject<Item> CONSTANTAN_ROD = registerItem("constantan_rod");
    public static final RegistryObject<Item> COPPER_ROD = registerItem("copper_rod");
    public static final RegistryObject<Item> DIAMOND_ROD = registerItem("diamond_rod");
    public static final RegistryObject<Item> ELECTRUM_ROD = registerItem("electrum_rod");
    public static final RegistryObject<Item> ENDERIUM_ROD = registerItem("enderium_rod");
    public static final RegistryObject<Item> GOLD_ROD = registerItem("gold_rod");
    public static final RegistryObject<Item> INVAR_ROD = registerItem("invar_rod");
    public static final RegistryObject<Item> IRIDIUM_ROD = registerItem("iridium_rod");
    public static final RegistryObject<Item> IRON_ROD = registerItem("iron_rod");
    public static final RegistryObject<Item> LEAD_ROD = registerItem("lead_rod");
    public static final RegistryObject<Item> LUMIUM_ROD = registerItem("lumium_rod");
    public static final RegistryObject<Item> NICKEL_ROD = registerItem("nickel_rod");
    public static final RegistryObject<Item> OSMIUM_ROD = registerItem("osmium_rod");
    public static final RegistryObject<Item> PLATINUM_ROD = registerItem("platinum_rod");
    public static final RegistryObject<Item> SIGNALUM_ROD = registerItem("signalum_rod");
    public static final RegistryObject<Item> SILVER_ROD = registerItem("silver_rod");
    public static final RegistryObject<Item> STEEL_ROD = registerItem("steel_rod");
    public static final RegistryObject<Item> TIN_ROD = registerItem("tin_rod");
    public static final RegistryObject<Item> URANIUM_ROD = registerItem("uranium_rod");
    public static final RegistryObject<Item> ZINC_ROD = registerItem("zinc_rod");

}
