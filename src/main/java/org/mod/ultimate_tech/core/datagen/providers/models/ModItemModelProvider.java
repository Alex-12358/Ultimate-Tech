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

        // GEM INGOTS - Регистрируем текстуры для драгоценностей
        registerGemIngots();

        // TOOLS - Инструменты для материалов (материалов, которые есть в ModMaterial)
        // Каждый тип инструмента имеет свою регистрацию
        registerSwords();
        registerPickaxes();
        registerAxes();
        registerShovels();
        registerHoes();

        // ELEVATORS - Генерируем модели для всех цветов лифтов
        for (DyeColor color : DyeColor.values()) {
            Item elevatorItem = Registry.ELEVATOR_ITEMS.get(color).get();
            withExistingParent("elevator_" + color.getName(), mcLoc("block/cube_all"))
                    .texture("all", new ResourceLocation(Ultimate_tech.MOD_ID, "block/elevator_" + color.getName()));
        }

        // TODO: TOOLS для драгоценностей (ModGames)
        // Пока текстуры не готовы, используем ванильные текстуры инструментов
        // Нужно создать текстуры в папке src/main/resources/assets/ultimate_tech/textures/item/tools/
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String folder) {

        return withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0",
                        new ResourceLocation(
                                Ultimate_tech.MOD_ID,
                                "item/" + folder + "/" + item.getId().getPath()
                        ));
    }

    // Метод для создания моделей инструментов с собственными текстурами
    private ItemModelBuilder toolItem(RegistryObject<Item> item, String toolType) {
        // Получаем имя предмета (например: "ruby_sword")
        String itemName = item.getId().getPath();

        // Создаём модель с двумя слоями:
        // layer0 - головка инструмента (окрашивается в цвет материала)
        // layer1 - рукоять/палка (не окрашивается)
        return withExistingParent(itemName, mcLoc("item/handheld"))
                .texture("layer0", new ResourceLocation(Ultimate_tech.MOD_ID, "item/tool/" + toolType))
                .texture("layer1", new ResourceLocation(Ultimate_tech.MOD_ID, "item/tool/" + toolType + "_handle"));
    }

    /**
     * Регистрирует модели мечей
     */
    private void registerSwords() {
        ModItemsToolSword.SWORDS.values().forEach(item -> toolItem(item, "sword"));
    }

    /**
     * Регистрирует модели кирок
     */
    private void registerPickaxes() {
        ModItemsToolPickaxe.PICKAXES.values().forEach(item -> toolItem(item, "pickaxe"));
    }

    /**
     * Регистрирует модели топоров
     */
    private void registerAxes() {
        ModItemsToolAxe.AXES.values().forEach(item -> toolItem(item, "axe"));
    }

    /**
     * Регистрирует модели лопат
     */
    private void registerShovels() {
        ModItemsToolShovel.SHOVELS.values().forEach(item -> toolItem(item, "shovel"));
    }

    /**
     * Регистрирует модели мотыг
     */
    private void registerHoes() {
        ModItemsToolHoe.HOES.values().forEach(item -> toolItem(item, "hoe"));
    }

    /**
     * Регистрирует текстуры для драгоценностей (ModGamesItem ingots)
     */
    private void registerGemIngots() {
        ModGamesItem.INGOTS.forEach((material, item) -> {
            String gemName = material.getName();
            withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                    .texture("layer0", new ResourceLocation(Ultimate_tech.MOD_ID, "item/ignot/" + gemName + "_ingot"));
        });
    }
}
