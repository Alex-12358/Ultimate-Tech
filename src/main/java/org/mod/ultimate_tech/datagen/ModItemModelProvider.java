package org.mod.ultimate_tech.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.item.*;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ultimate_tech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // rods
        ModItemsRod.RODS.values().forEach(item -> simpleItem(item, "rod"));

        // ingots
        ModItemsIngot.INGOTS.values().forEach(item -> simpleItem(item, "ingot"));

        // plates
        ModItemsPlate.PLATES.values().forEach(item -> simpleItem(item, "plate"));

        // dusts
        ModItemsDust.DUSTS.values().forEach(item -> simpleItem(item, "dust"));

        // nuggets
        ModItemsNugget.NUGGETS.values().forEach(item -> simpleItem(item, "nugget"));

        // raw materials
        ModItemsRaw.RAW_ITEMS.values().forEach(item -> simpleItem(item, "raw"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String folder) {

        return withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0",
                        new ResourceLocation(
                                Ultimate_tech.MOD_ID,
                                "item/" + folder + "/" + item.getId().getPath()
                        ));
    }
}
