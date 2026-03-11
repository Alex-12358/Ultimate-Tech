package org.mod.ultimate_tech.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.material.ModMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModItemsRod {

//    public static final DeferredRegister<Item> ITEMS
//            = DeferredRegister.create(ForgeRegistries.ITEMS, Ultimate_tech.MOD_ID);
//
//    public static void register(IEventBus eventBus) {
//        ITEMS.register(eventBus);
//    }
//
//    private static RegistryObject<Item> registerItem(String name) {
//        return ITEMS.register(name, () -> new Item(new Item.Properties()));
//    }

    // список материалов для rods
//    public static final String[] ROD_MATERIALS = {
//            "aluminum",
//            "brass",
//            "bronze",
//            "constantan",
//            "copper",
//            "diamond",
//            "electrum",
//            "enderium",
//            "gold",
//            "invar",
//            "iridium",
//            "iron",
//            "lead",
//            "lumium",
//            "nickel",
//            "osmium",
//            "platinum",
//            "signalum",
//            "silver",
//            "steel",
//            "tin",
//            "uranium",
//            "zinc"
//    };


    public static final Map<ModMaterial, RegistryObject<Item>> RODS = new HashMap<>();

    public static void register() {

        for (ModMaterial material : ModMaterial.values()) {

            String name = material.getName() + "_rod";

            RODS.put(
                    material,
                    ModItemsUtils.ITEMS.register(
                            name,
                            () -> new Item(new Item.Properties())
                    )
            );

        }

    }

}
