package org.mod.ultimate_tech.core.datagen.providers.loot;

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
import org.mod.ultimate_tech.common.material.ModMaterial;
import org.mod.ultimate_tech.core.registry.ModBlockUtils;
import org.mod.ultimate_tech.core.registry.block.generator.*;
import org.mod.ultimate_tech.core.registry.item.material.ModItemsRaw;

import java.util.Map;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    // Сделать конструктор public
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // =========================
        // MACHINE / SIMPLE BLOCKS
        // =========================

//        dropSelf(ModBlocks.CORE_STRUCTURAL_BLOCK.get());
//        dropSelf(ModBlocks.MACHINE_STRUCTURAL_HOUSING.get());

        // =========================
        // STORAGE BLOCKS
        // =========================

        ModBlocksBlock.BLOCK.forEach((material, block) -> {
            dropSelf(block.get());
        });

        // =========================
        // RAW BLOCKS
        // =========================

        ModBlocksRaw.RAW_BLOCKS.forEach((material, block) -> {
            dropSelf(block.get());
        });

        // =========================
        // ORES
        // =========================

        generateOreDrops(ModBlocksOre.ORES);
        generateOreDrops(ModBlocksDeepslateOre.ORES);
        generateOreDrops(ModBlocksNetherOre.ORES);
        generateOreDrops(ModBlocksEndOre.ORES);
    }

    private void generateOreDrops(Map<ModMaterial, RegistryObject<Block>> ores) {
        ores.forEach((material, block) -> {
            if (ModItemsRaw.RAW_ITEMS.containsKey(material)) {
                this.add(block.get(), b ->
                        createFortuneOreDrops(
                                block.get(),
                                ModItemsRaw.RAW_ITEMS.get(material).get()
                        ));
            } else {
                dropSelf(block.get());
            }
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
