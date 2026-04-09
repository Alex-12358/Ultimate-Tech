package org.mod.ultimate_tech.core.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.mod.ultimate_tech.Ultimate_tech;

public class ModTags {
    public static class Blocks {
//        public static final TagKey<Block> CORE_STRUCTURAL_BLOCK = tag("core_structural_block");

        public static final TagKey<Block> ORES = tag("ores");
        public static final TagKey<Block> DEEPSLATE_ORES = tag("deepslate_ores");
        public static final TagKey<Block> NETHER_ORES = tag("nether_ores");
        public static final TagKey<Block> END_ORES = tag("end_ores");
        public static final TagKey<Block> RAW_BLOCKS = tag("raw_blocks");
        public static final TagKey<Block> STORAGE_BLOCKS = tag("storage_blocks");

        public static final TagKey<Block> NEED_TOOL = tag("need_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Ultimate_tech.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> ORES = tag("ores");
        public static final TagKey<Item> INGOTS = tag("ingots");
        public static final TagKey<Item> MATERIALS = tag("materials");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Ultimate_tech.MOD_ID, name));
        }
    }
}
