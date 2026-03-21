package org.mod.ultimate_tech.common.material;

public enum ModMaterial {

    // VANILLA
    IRON(false, false, false,
        false, false, true,
        true, false, false,
        true, true, true),
    GOLD(false, false, false, 
        false, false, false,
        true, false, false, 
        true, true, true),
    COPPER(false, true, false, 
        false, false, true,
        true, false, false, 
        true, true, true),
    DIAMOND(false, false, false, 
        false, false, true,
        true, false, true,
        false, false, false),
    EMERALD(false, false, false, 
        false, false, true, 
        true, false, true, 
        true, false, false),
    REDSTONE(false, false, false, 
        false, false, true, 
        true, false, true, 
        false, false, false),
    LAPIS(false, false, false, 
        false, false, true, 
        true, false, true, 
        true, true, false),
    COAL(false, false, false, 
        false, false, true, 
        true, false, true, 
        true, false, false),
    // MOD MATERIALS
    ALUMINIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    AMERICIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    ARSENIC(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    BARIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    BISMUTH(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    CADMIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    CHROMIUM(true, true, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    COBALT(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    CRYSTAL(false, false, false, 
        false, false, false, 
        false, false, false, 
        false, false, false),
//    CURIUM(true, true, true, true, true, true, true, true, true),
    GADOLINIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    GALLIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    GERMANIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    HAFNIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    IRIDIUM(true, false, true, 
        false, false, false, 
        false, false, false, 
        true, true, true),
    LEAD(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    MAGNESIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    MANGANESE(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    MIKHAIL(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    MOLYBDENUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    NEODYMIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
//    NEPTUNIUM(true, true, true, true, true, true, true, true, true),
    NICKEL(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    NIOBIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    OSMIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    PALLADIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    PLATIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    POLONIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    QUARTZ(false, false, false, 
        false, false, false, 
        false, false, false, 
        false, false, false),
    SILVER(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    STRONTIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    SULFUR(false, false, false, 
        false, false, false, 
        false, false, false, 
        false, false, false),
    TANTALUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    THALLIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    THORIUM(true, false, false, 
        true, true, true, 
        true, true, true, 
        false, false, false),
    TIN(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    TITANIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    URANIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        false, false, false),
    VANADIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    WOLFRAM(true, false, false, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    YTTRIUM(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    ZINC(true, false, true, 
        true, true, true, 
        true, true, true, 
        true, true, true),
    ZIRCONIUM(true, false, 
        true, true, true, true, 
        true, true, true, 
        true, true, true),
        RUBY(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        SAPPHIRE(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        TOPAZ(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        AMETHYST(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        GARNET(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        OPAL(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        JADE(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        MALACHITE(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        AQUAMARINE(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        SPINEL(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        ZIRCON(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        ),
        MORGANITE(
                true, false, false,
        true, true, false, 
        false, true, false,
        false, false, false
        );

    private final boolean hasIngot;
    private final boolean hasDust;
    private final boolean hasPlate;
    private final boolean hasRod;
    private final boolean hasNugget;
    private final boolean hasItemRaw;
    private final boolean hasBlock;
    private final boolean hasDeepOre;
    private final boolean hasOre;
    private final boolean hasBlockRaw;
    private final boolean hasEndOre;
    private final boolean hasNetherOre;

    ModMaterial(boolean hasIngot,
                boolean hasNugget,
                boolean hasItemRaw,
                boolean hasBlock,
                boolean hasDeepOre,
                boolean hasNetherOre,
                boolean hasEndOre,
                boolean hasOre,
                boolean hasBlockRaw,
                boolean hasDust,
                boolean hasPlate,
                boolean hasRod) {
        this.hasDust = hasDust;
        this.hasPlate = hasPlate;
        this.hasRod = hasRod;
        this.hasIngot = hasIngot;
        this.hasNugget = hasNugget;
        this.hasItemRaw = hasItemRaw;
        this.hasBlock = hasBlock;
        this.hasDeepOre = hasDeepOre;
        this.hasOre = hasOre;
        this.hasBlockRaw = hasBlockRaw;
        this.hasEndOre = hasEndOre;
        this.hasNetherOre = hasNetherOre;
    }

    public boolean hasIngot() {
        return hasIngot;
    }

    public boolean hasNugget() {
        return hasNugget;
    }

    public boolean hasItemRaw() {
        return hasItemRaw;
    }

    public boolean hasDust() {
        return hasDust;
    }

    public boolean hasPlate() {
        return hasPlate;
    }

    public boolean hasRod() {
        return hasRod;
    }

    public boolean hasBlock() {
        return hasBlock;
    }

    public boolean hasDeepOre() {
        return hasDeepOre;
    }

    public boolean hasOre() {
        return hasOre;
    }

    public boolean hasBlockRaw() {
        return hasBlockRaw;
    }

    public boolean hasEndOre() {
        return hasEndOre;
    }

    public boolean hasNetherOre() {
        return hasNetherOre;
    }

    public String getName() {
        return name().toLowerCase();
    }
}