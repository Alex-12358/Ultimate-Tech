package org.mod.ultimate_tech.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Ultimate_tech.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, registeredBlock);
        return registeredBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static RegistryObject<Block> simpleBlock(String name) {
        return registerBlock(name, ()
                -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    }

    public static final RegistryObject<Block> CORE_STRUCTURAL_BLOCK = simpleBlock("core_structural_block");
    public static final RegistryObject<Block> MACHINE_STRUCTURAL_HOUSING = simpleBlock("machine_structural_housing");

    //ORES
    public static final RegistryObject<Block> ALUMINIUM_ORE = simpleBlock("aluminium_ore");
    public static final RegistryObject<Block> AMERICIUM_ORE = simpleBlock("americium_ore");
    public static final RegistryObject<Block> ARSENIC_ORE = simpleBlock("arsenic_ore");
    public static final RegistryObject<Block> ASTEROID_BARIUM_ORE = simpleBlock("asteroid_barium_ore");
    public static final RegistryObject<Block> ASTEROID_CADMIUM_ORE = simpleBlock("asteroid_cadmium_ore");
    public static final RegistryObject<Block> BARIUM_ORE = simpleBlock("barium_ore");
    public static final RegistryObject<Block> BASALT_BORON_ORE = simpleBlock("basalt_boron_ore");
    public static final RegistryObject<Block> BASALT_SULFUR_ORE = simpleBlock("basalt_sulfur_ore");
    public static final RegistryObject<Block> BISMUTH_ORE = simpleBlock("bismuth_ore");
    public static final RegistryObject<Block> CADMIUM_ORE = simpleBlock("cadmium_ore");
    public static final RegistryObject<Block> CALLISTO_LAPIS_ORE = simpleBlock("callisto_lapis_ore");
    public static final RegistryObject<Block> CALLISTO_LITHIUM_ORE = simpleBlock("callisto_lithium_ore");
    public static final RegistryObject<Block> CALLISTO_REDSTONE_ORE = simpleBlock("callisto_redstone_ore");
    public static final RegistryObject<Block> CERES_COPPER_ORE = simpleBlock("ceres_copper_ore");
    public static final RegistryObject<Block> CERES_IRON_ORE = simpleBlock("ceres_iron_ore");
    public static final RegistryObject<Block> CHROMIUM_ORE = simpleBlock("chromium_ore");
    public static final RegistryObject<Block> COBALT_ORE = simpleBlock("cobalt_ore");
    public static final RegistryObject<Block> COPPER_ORE = simpleBlock("copper_ore");
    public static final RegistryObject<Block> CRYSTAL_ORE = simpleBlock("crystal_ore");
    public static final RegistryObject<Block> CURIUM_ORE = simpleBlock("curium_ore");

    public static final RegistryObject<Block> DEIMOS_ORICHALCUM_ORE = simpleBlock("deimos_orichalcum_ore");
    public static final RegistryObject<Block> DIONE_LEAD_ORE = simpleBlock("dione_lead_ore");
    public static final RegistryObject<Block> DIONE_PLATINUM_ORE = simpleBlock("dione_platinum_ore");
    public static final RegistryObject<Block> ENCELADUS_MAGNESIUM_ORE = simpleBlock("enceladus_magnesium_ore");
    public static final RegistryObject<Block> EUROPA_MIKHAIL_ORE = simpleBlock("europa_mikhail_ore");
    public static final RegistryObject<Block> GADOLINIUM_ORE = simpleBlock("gadolinium_ore");
    public static final RegistryObject<Block> GALLIUM_ORE = simpleBlock("gallium_ore");
    public static final RegistryObject<Block> GANYMEDE_ALUMINIUM_ORE = simpleBlock("ganymede_aluminium_ore");
    public static final RegistryObject<Block> GANYMEDE_TUNGSTEN_ORE = simpleBlock("ganymede_tungsten_ore");
    public static final RegistryObject<Block> GERMANIUM_ORE = simpleBlock("germanium_ore");
    public static final RegistryObject<Block> HAFNIUM_ORE = simpleBlock("hafnium_ore");
    public static final RegistryObject<Block> IO_EMERALD_ORE = simpleBlock("io_emerald_ore");
    public static final RegistryObject<Block> IRIDIUM_ORE = simpleBlock("iridium_ore");
    public static final RegistryObject<Block> LEAD_ORE = simpleBlock("lead_ore");
    public static final RegistryObject<Block> MAGNESIUM_ORE = simpleBlock("magnesium_ore");
    public static final RegistryObject<Block> MANGANESE_ORE = simpleBlock("manganese_ore");
    public static final RegistryObject<Block> MARS_ADAMANTIUM_ORE = simpleBlock("mars_adamantium_ore");
    public static final RegistryObject<Block> MARS_COBALT_ORE = simpleBlock("mars_cobalt_ore");
    public static final RegistryObject<Block> MERCURY_CHROMIUM_ORE = simpleBlock("mercury_chromium_ore");
    public static final RegistryObject<Block> MERCURY_MITHRIL_ORE = simpleBlock("mercury_mithril_ore");

    public static final RegistryObject<Block> MIKHAIL_ORE = simpleBlock("mikhail_ore");
    public static final RegistryObject<Block> MOLYBDENUM_ORE = simpleBlock("molybdenum_ore");
    public static final RegistryObject<Block> MOON_METEORIC_IRON_ORE = simpleBlock("moon_meteoric_iron_ore");
    public static final RegistryObject<Block> MOON_TIN_ORE = simpleBlock("moon_tin_ore");
    public static final RegistryObject<Block> NEODYMIUM_ORE = simpleBlock("neodymium_ore");
    public static final RegistryObject<Block> NEPTUNIUM_ORE = simpleBlock("neptunium_ore");
    public static final RegistryObject<Block> NICKEL_ORE = simpleBlock("nickel_ore");
    public static final RegistryObject<Block> NIOBIUM_ORE = simpleBlock("niobium_ore");
    public static final RegistryObject<Block> OSMIUM_ORE = simpleBlock("osmium_ore");
    public static final RegistryObject<Block> PALLADIUM_ORE = simpleBlock("palladium_ore");
    public static final RegistryObject<Block> PHOBOS_ZIRCONIUM_ORE = simpleBlock("phobos_zirconium_ore");
    public static final RegistryObject<Block> PLATIUM_ORE = simpleBlock("platium_ore");
    public static final RegistryObject<Block> POLONIUM_ORE = simpleBlock("polonium_ore");
    public static final RegistryObject<Block> QUARTZ_ORE = simpleBlock("quartz_ore");
    public static final RegistryObject<Block> RHEA_OSMIUM_ORE = simpleBlock("rhea_osmium_ore");
    public static final RegistryObject<Block> RHEA_VANADY_ORE = simpleBlock("rhea_vanady_ore");
    public static final RegistryObject<Block> RUBY_ORE = simpleBlock("ruby_ore");
    public static final RegistryObject<Block> SAPPHIRE_ORE = simpleBlock("sapphire_ore");
    public static final RegistryObject<Block> SILVER_ORE = simpleBlock("silver_ore");
    public static final RegistryObject<Block> SPINEL_ORE = simpleBlock("spinel_ore");

    public static final RegistryObject<Block> STRONTIUM_ORE = simpleBlock("strontium_ore");
    public static final RegistryObject<Block> SULFUR_ORE = simpleBlock("sulfur_ore");
    public static final RegistryObject<Block> TANTALUM_ORE = simpleBlock("tantalum_ore");
    public static final RegistryObject<Block> TETHYS_MOLYBDENUM_ORE = simpleBlock("tethys_molybdenum_ore");
    public static final RegistryObject<Block> THALLIUM_ORE = simpleBlock("thallium_ore");
    public static final RegistryObject<Block> THORIUM_ORE = simpleBlock("thorium_ore");
    public static final RegistryObject<Block> TIN_ORE = simpleBlock("tin_ore");
    public static final RegistryObject<Block> TITAN_NICKEL_ORE = simpleBlock("titan_nickel_ore");
    public static final RegistryObject<Block> TITAN_TITANIUM_ORE = simpleBlock("titan_titanium_ore");
    public static final RegistryObject<Block> TITANIA_POLONIUM_ORE = simpleBlock("titania_polonium_ore");
    public static final RegistryObject<Block> TITANIUM_ORE = simpleBlock("titanium_ore");
    public static final RegistryObject<Block> TOPAZ_ORE = simpleBlock("topaz_ore");
    public static final RegistryObject<Block> UMBRIEL_SPINEL_ORE = simpleBlock("umbriel_spinel_ore");
    public static final RegistryObject<Block> URANIUM_ORE = simpleBlock("uranium_ore");
    public static final RegistryObject<Block> VANADY_ORE = simpleBlock("vanady_ore");
    public static final RegistryObject<Block> VENUS_DIAMOND_ORE = simpleBlock("venus_diamond_ore");
    public static final RegistryObject<Block> WOLFRAM_ORE = simpleBlock("wolfram_ore");
    public static final RegistryObject<Block> YTTRIUM_ORE = simpleBlock("yttrium_ore");
    public static final RegistryObject<Block> ZINC_ORE = simpleBlock("zinc_ore");
    public static final RegistryObject<Block> ZIRCONIUM_ORE = simpleBlock("zirconium_ore");
}
