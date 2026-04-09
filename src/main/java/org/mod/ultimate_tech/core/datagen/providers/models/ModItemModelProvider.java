package org.mod.ultimate_tech.core.datagen.providers.models;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.init.Registry;
import org.mod.ultimate_tech.core.registry.item.material.*;
import org.mod.ultimate_tech.core.registry.item.tool.*;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ultimate_tech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // rods
        ModItemsRod.RODS.values().forEach(item -> simpleItem(item, "rod"));

        // ingots
        ModItemsIngot.INGOTS.values().forEach(item -> simpleItem(item, "ignot"));

        // plates
        ModItemsPlate.PLATES.values().forEach(item -> simpleItem(item, "plate"));

        // dusts
        ModItemsDust.DUSTS.values().forEach(item -> simpleItem(item, "dust"));

        // nuggets
        ModItemsNugget.NUGGETS.values().forEach(item -> simpleItem(item, "nugget"));

        // raw materials
        ModItemsRaw.RAW_ITEMS.values().forEach(item -> simpleItem(item, "raw"));

        // TOOLS - Простые модели с одноцветными текстурами (используем однопиксельный квадрат)
        ModItemsToolSword.SWORDS.values().forEach(item -> toolItem(item, "sword"));
        ModItemsToolPickaxe.PICKAXES.values().forEach(item -> toolItem(item, "pickaxe"));
        ModItemsToolAxe.AXES.values().forEach(item -> toolItem(item, "axe"));
        ModItemsToolShovel.SHOVELS.values().forEach(item -> toolItem(item, "shovel"));
        ModItemsToolHoe.HOES.values().forEach(item -> toolItem(item, "hoe"));

        // ELEVATORS - Генерируем модели для всех цветов лифтов
        for (DyeColor color : DyeColor.values()) {
            Item elevatorItem = Registry.ELEVATOR_ITEMS.get(color).get();
            withExistingParent("elevator_" + color.getName(), mcLoc("block/cube_all"))
                    .texture("all", new ResourceLocation(Ultimate_tech.MOD_ID, "block/elevator_" + color.getName()));
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String folder) {

        return withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0",
                        new ResourceLocation(
                                Ultimate_tech.MOD_ID,
                                "item/" + folder + "/" + item.getId().getPath()
                        ));
    }

    // Метод для создания моделей инструментов с цветом материала (используется текстура блока)
    private ItemModelBuilder toolItem(RegistryObject<Item> item, String toolType) {
        // Извлекаем имя материала из имени инструмента (например: "amethyst_sword" -> "amethyst")
        String itemName = item.getId().getPath();
        String materialName = itemName.replace("_" + toolType, "");

        // Используем ванильные текстуры инструментов как layer0 (основа)
        String vanillaTexture = switch(toolType) {
            case "sword" -> "item/diamond_sword";
            case "pickaxe" -> "item/diamond_pickaxe";
            case "axe" -> "item/diamond_axe";
            case "shovel" -> "item/diamond_shovel";
            case "hoe" -> "item/diamond_hoe";
            default -> "item/diamond_sword";
        };

        // Создаём модель с двумя слоями:
        // layer0 - ванильная текстура инструмента (серая)
        // layer1 - белая текстура для тинта (будет окрашена в цвет материала)
        return withExistingParent(itemName, mcLoc("item/handheld"))
                .texture("layer0", mcLoc(vanillaTexture))
                .texture("layer1", new ResourceLocation(Ultimate_tech.MOD_ID, "item/" + toolType + "/overlay"));
    }
}
