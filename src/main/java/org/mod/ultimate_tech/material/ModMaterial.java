package org.mod.ultimate_tech.material;

public enum ModMaterial {

    // VANILLA
    IRON(true, true, true, true, true, false, false, true, true),
    GOLD(true, true, true, true, true, true, false, true, true),
    COPPER(true, true, true, true, true, false, false, true, true),
    DIAMOND(true, true, true, true, true, false, false, true, true),
    EMERALD(true, true, true, true, true, false, false, true, true),
    REDSTONE(true, true, true, true, true, false, false, true, true),
    LAPIS(true, true, true, true, true, false, false, true, true),
    COAL(true, true, true, true, true, false, false, true, true),

    // MOD MATERIALS
    ALUMINUM(true, true, true, true, true, true, true, true, true),
    AMERICIUM(true, true, true, true, true, true, true, true, true),
    ARSENIC(true, true, true, true, true, true, true, true, true),
    BARIUM(true, true, true, true, true, true, true, true, true),
    BISMUTH(true, true, true, true, true, true, true, true, true),
    CADMIUM(true, true, true, true, true, true, true, true, true),
    CHROMIUM(true, true, true, true, true, true, true, true, true),
    COBALT(true, true, true, true, true, true, true, true, true),
    CRYSTAL(false, false, false, false, false, false, false, false, false),
    CURIUM(true, true, true, true, true, true, true, true, true),
    GADOLINIUM(true, true, true, true, true, true, true, true, true),
    GALLIUM(true, true, true, true, true, true, true, true, true),
    GERMANIUM(true, true, true, true, true, true, true, true, true),
    HAFNIUM(true, true, true, true, true, true, true, true, true),
    IRIDIUM(true, true, true, true, true, true, true, true, true),
    LEAD(true, true, true, true, true, true, true, true, true),
    MAGNESIUM(true, true, true, true, true, true, true, true, true),
    MANGANESE(true, true, true, true, true, true, true, true, true),
    MIKHAIL(true, true, true, true, true, true, true, true, true),
    MOLYBDENUM(true, true, true, true, true, true, true, true, true),
    NEODYMIUM(true, true, true, true, true, true, true, true, true),
    NEPTUNIUM(true, true, true, true, true, true, true, true, true),
    NICKEL(true, true, true, true, true, true, true, true, true),
    NIOBIUM(true, true, true, true, true, true, true, true, true),
    OSMIUM(true, true, true, true, true, true, true, true, true),
    PALLADIUM(true, true, true, true, true, true, true, true, true),
    PLATINUM(true, true, true, true, true, true, true, true, true),
    POLONIUM(true, true, true, true, true, true, true, true, true),
    QUARTZ(false, false, false, false, false, false, false, false, false),
    RUBY(false, false, false, false, false, false, false, false, false),
    SAPPHIRE(false, false, false, false, false, false, false, false, false),
    SILVER(true, true, true, true, true, true, true, true, true),
    SPINEL(false, false, false, false, false, false, false, false, false),
    STRONTIUM(true, true, true, true, true, true, true, true, true),
    SULFUR(false, false, false, false, false, false, false, false, false),
    TANTALUM(true, true, true, true, true, true, true, true, true),
    THALLIUM(true, true, true, true, true, true, true, true, true),
    THORIUM(true, true, true, true, true, true, true, true, true),
    TIN(true, true, true, true, true, true, true, true, true),
    TITANIUM(true, true, true, true, true, true, true, true, true),
    TOPAZ(false, false, false, false, false, false, false, false, false),
    URANIUM(true, true, true, true, true, true, true, true, true),
    VANADIUM(true, true, true, true, true, true, true, true, true),
    WOLFRAM(true, true, true, true, true, true, true, true, true),
    YTTRIUM(true, true, true, true, true, true, true, true, true),
    ZINC(true, true, true, true, true, true, true, true, true),
    ZIRCONIUM(true, true, true, true, true, true, true, true, true);

    private final boolean hasIngot;
    private final boolean hasNugget;
    private final boolean hasItemRaw;
    private final boolean hasBlock;
    private final boolean hasDeepOre;
    private final boolean hasOre;
    private final boolean hasBlockRaw;
    private final boolean hasEndOre;
    private final boolean hasNetherOre;

    ModMaterial(boolean hasIngot, boolean hasNugget, boolean hasItemRaw, boolean hasBlock, boolean hasDeepOre, boolean hasNetherOre, boolean hasEndOre, boolean hasOre, boolean hasBlockRaw) {
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