package org.mod.ultimate_tech.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.block.*;
import org.mod.ultimate_tech.block.custom.*;
import org.mod.ultimate_tech.item.*;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    // Сделать конструктор public
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // =========================
        // SIMPLE BLOCKS
        // =========================

        this.dropSelf(ModBlocks.CORE_STRUCTURAL_BLOCK.get());
        this.dropSelf(ModBlocks.MACHINE_STRUCTURAL_HOUSING.get());

        // =========================
        // OVERWORLD ORES
        // =========================

        ModBlocksOre.ORES.forEach((material, block) -> {
            if (!ModItemsRaw.RAW_ITEMS.containsKey(material)) return;

            this.add(block.get(), b ->
                    createFortuneOreDrops(
                            block.get(),
                            ModItemsRaw.RAW_ITEMS.get(material).get()
                    ));
        });

        // =========================
        // DEEPSLATE ORES
        // =========================

        ModBlocksDeepslateOre.ORES.forEach((material, block) -> {
            if (!ModItemsRaw.RAW_ITEMS.containsKey(material)) return;

            this.add(block.get(), b ->
                    createFortuneOreDrops(
                            block.get(),
                            ModItemsRaw.RAW_ITEMS.get(material).get()
                    ));
        });

        // =========================
        // NETHER ORES
        // =========================

        ModBlocksNetherOre.ORES.forEach((material, block) -> {
            if (!ModItemsRaw.RAW_ITEMS.containsKey(material)) return;

            this.add(block.get(), b ->
                    createFortuneOreDrops(
                            block.get(),
                            ModItemsRaw.RAW_ITEMS.get(material).get()
                    ));
        });

        // =========================
        // END ORES
        // =========================

        ModBlocksEndOre.ORES.forEach((material, block) -> {
            if (!ModItemsRaw.RAW_ITEMS.containsKey(material)) return;

            this.add(block.get(), b ->
                    createFortuneOreDrops(
                            block.get(),
                            ModItemsRaw.RAW_ITEMS.get(material).get()
                    ));
        });
    }

    protected LootTable.Builder createFortuneOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlockUtils.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
