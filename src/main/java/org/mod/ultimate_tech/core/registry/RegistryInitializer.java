package org.mod.ultimate_tech.core.registry;

import org.mod.ultimate_tech.core.registry.block.custom.ModCustomBlocks;
import org.mod.ultimate_tech.core.registry.block.generator.*;
import org.mod.ultimate_tech.core.registry.fluid.ModFluids;
import org.mod.ultimate_tech.core.registry.item.material.*;
import org.mod.ultimate_tech.core.registry.item.tool.*;

/**
 * Централизованный класс для инициализации всех предметов и блоков модификации.
 * Упрощает поддержку и управление порядком инициализации.
 */
public final class RegistryInitializer {

    private RegistryInitializer() {
    }

    /**
     * Инициализирует все жидкости, предметы и блоки модификации.
     */
    public static void initializeAll() {
        initializeFluids();
        initializeCustomBlocks();
        initializeItems();
        initializeTools();
        initializeBlocks();
    }

    /**
     * Инициализирует жидкости модификации.
     */
    private static void initializeFluids() {
        // Теперь жидкости инициализируются автоматически через ModFluidsRegistry
        // static поля при загрузке класса
    }

    /**
     * Инициализирует кастомные блоки (elevator, battery и т.д.).
     */
    private static void initializeCustomBlocks() {
        ModCustomBlocks.init();
    }

    /**
     * Инициализирует все материальные предметы (слитки, пыль, пластины, самородки, сырьё, стержни, игровые предметы).
     */
    private static void initializeItems() {
        ModItemsRod.generate();
        ModItemsIngot.generate();
        ModItemsPlate.generate();
        ModItemsDust.generate();
        ModItemsNugget.generate();
        ModItemsRaw.generate();
        ModGamesItem.generate();
    }

    /**
     * Инициализирует все инструменты и их уровни.
     */
    private static void initializeTools() {
        ModItemToolTiers.generate();
        ModItemsToolAxe.generate();
        ModItemsToolHoe.generate();
        ModItemsToolShovel.generate();
        ModItemsToolPickaxe.generate();
        ModItemsToolSword.generate();
    }

    /**
     * Инициализирует все блоки (руды, обычные блоки, сырые блоки).
     */
    private static void initializeBlocks() {
        ModBlocksOre.generate();
        ModBlocksDeepslateOre.generate();
        ModBlocksBlock.generate();
        ModBlocksRaw.generate();
        ModBlocksNetherOre.generate();
        ModBlocksEndOre.generate();
    }
}

