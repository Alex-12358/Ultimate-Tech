package org.mod.ultimate_tech.core.datagen.providers.models;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.material.ModGames;
import org.mod.ultimate_tech.core.registry.item.tool.*;

/**
 * Генератор моделей инструментов с двумя слоями текстур:
 * - Layer 0: Handle (палка)
 * - Layer 1: Head/Blade (голова инструмента с цветом)
 */
public class ModItemModelToolsProvider extends ItemModelProvider {
    public ModItemModelToolsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ultimate_tech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Текстура палки используется для всех инструментов
        String handleTexture = Ultimate_tech.MOD_ID + ":item/tools/handle";

        // SWORDS
        for (ModGames material : ModGames.values()) {
            if (!material.hasSword() || !ModItemsToolSword.SWORDS.containsKey(material)) continue;

            String swordHeadTexture = Ultimate_tech.MOD_ID + ":item/tools/swords/" + material.getName();
            createTwoLayerModel(
                    material.getName() + "_sword",
                    handleTexture,
                    swordHeadTexture
            );
        }

        // PICKAXES
        for (ModGames material : ModGames.values()) {
            if (!material.hasPickaxe() || !ModItemsToolPickaxe.PICKAXES.containsKey(material)) continue;

            String pickaxeHeadTexture = Ultimate_tech.MOD_ID + ":item/tools/pickaxes/" + material.getName();
            createTwoLayerModel(
                    material.getName() + "_pickaxe",
                    handleTexture,
                    pickaxeHeadTexture
            );
        }

        // AXES
        for (ModGames material : ModGames.values()) {
            if (!material.hasAxe() || !ModItemsToolAxe.AXES.containsKey(material)) continue;

            String axeHeadTexture = Ultimate_tech.MOD_ID + ":item/tools/axes/" + material.getName();
            createTwoLayerModel(
                    material.getName() + "_axe",
                    handleTexture,
                    axeHeadTexture
            );
        }

        // SHOVELS
        for (ModGames material : ModGames.values()) {
            if (!material.hasShovel() || !ModItemsToolShovel.SHOVELS.containsKey(material)) continue;

            String shovelHeadTexture = Ultimate_tech.MOD_ID + ":item/tools/shovels/" + material.getName();
            createTwoLayerModel(
                    material.getName() + "_shovel",
                    handleTexture,
                    shovelHeadTexture
            );
        }

        // HOES
        for (ModGames material : ModGames.values()) {
            if (!material.hasHoe() || !ModItemsToolHoe.HOES.containsKey(material)) continue;

            String hoeHeadTexture = Ultimate_tech.MOD_ID + ":item/tools/hoes/" + material.getName();
            createTwoLayerModel(
                    material.getName() + "_hoe",
                    handleTexture,
                    hoeHeadTexture
            );
        }
    }

    /**
     * Создаёт модель с двумя слоями текстур
     * @param name Имя инструмента (например "ruby_sword")
     * @param layer0 Текстура слоя 0 (палка)
     * @param layer1 Текстура слоя 1 (голова инструмента)
     */
    private void createTwoLayerModel(String name, String layer0, String layer1) {
        withExistingParent(name, "item/handheld")
                .texture("layer0", layer0)
                .texture("layer1", layer1);
    }
}

