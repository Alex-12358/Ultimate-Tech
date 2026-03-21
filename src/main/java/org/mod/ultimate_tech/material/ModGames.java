package org.mod.ultimate_tech.material;

public enum ModGames {
    // Рубин
    RUBY(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            7.0f, 1.0f,
            0.0f, 0.0f,
            0, 0.0f
    ),

    // Сапфир
    SAPPHIRE(
            true, true,
            true, true,
            true, true,
            true, true, true,
            5, 1.8f,
            2, 1.0f,
            6.0f, 0.8f,
            1.0f, 0.0f,
            0, 0.0f
    ),

    // Топаз
    TOPAZ(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 2.1f,
            1, 1.0f,
            6.5f, 0.9f,
            0.5f, 0.0f,
            0, 0.0f
    ),

    // Аметист
    AMETHYST(
            true, true,
            true, true,
            true, true,
            true, true, true,
            3, 2.4f,
            1, 1.2f,
            5.5f, 1.1f,
            0.0f, 0.1f,
            0, 0.0f
    ),

    // Гранат
    GARNET(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            7.0f, 1.0f,
            0.0f, 0.0f,
            0, 0.0f
    ),

    // Опал
    OPAL(
            true, true,
            true, true,
            true, true,
            true, true, true,
            3, 2.3f,
            1, 1.1f,
            5.8f, 1.0f,
            0.2f, 0.0f,
            0, 0.0f
    ),

    // Нефрит
    JADE(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 1.9f,
            2, 0.9f,
            7.2f, 0.8f,
            0.5f, -0.1f,
            0, 0.0f
    ),

    // Малахит
    MALACHITE(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            6.8f, 0.9f,
            0.3f, 0.0f,
            0, 0.0f
    ),

    // Аквамарин
    AQUAMARINE(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 2.2f,
            1, 1.1f,
            6.0f, 1.0f,
            0.2f, 0.1f,
            0, 0.0f
    ),

    // Шпинель
    SPINEL(
            true, true,
            true, true,
            true, true,
            true, true, true,
            5, 1.9f,
            2, 1.0f,
            7.5f, 0.8f,
            0.5f, 0.0f,
            0, 0.0f
    ),

    // Циркон
    ZIRCON(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            6.7f, 0.9f,
            0.3f, 0.0f,
            0, 0.0f
    ),

    // Морганит
    MORGANITE(
            true, true,
            true, true,
            true, true,
            true, true, true,
            4, 2.1f,
            1, 1.0f,
            6.3f, 1.0f,
            0.2f, 0.0f,
            0, 0.0f
    );

    // Наличие предметов/блоков
    private final boolean hasSword;
    private final boolean hasPickaxe;
    private final boolean hasAxe;
    private final boolean hasShovel;
    private final boolean hasHoe;
    private final boolean hasOre;
    private final boolean hasDeepOre;
    private final boolean hasBlock;
    private final boolean hasGames;

    // Статы инструментов
    private final int swordDamage;
    private final float swordSpeed;

    private final int pickaxeDamage;
    private final float pickaxeSpeed;

    private final float axeDamage;
    private final float axeSpeed;

    private final float shovelDamage;
    private final float shovelSpeed;

    private final int hoeDamage;
    private final float hoeSpeed;

    ModGames(
            boolean hasSword,
            boolean hasPickaxe,
            boolean hasAxe,
            boolean hasShovel,
            boolean hasHoe,
            boolean hasBlock,
            boolean hasDeepOre,
            boolean hasOre,
            boolean hasGames,
            int swordDamage,
            float swordSpeed,
            int pickaxeDamage,
            float pickaxeSpeed,
            float axeDamage,
            float axeSpeed,
            float shovelDamage,
            float shovelSpeed,
            int hoeDamage,
            float hoeSpeed
    ) {
        this.hasSword = hasSword;
        this.hasPickaxe = hasPickaxe;
        this.hasAxe = hasAxe;
        this.hasShovel = hasShovel;
        this.hasHoe = hasHoe;
        this.hasBlock = hasBlock;
        this.hasDeepOre = hasDeepOre;
        this.hasOre = hasOre;
        this.hasGames = hasGames;

        this.swordDamage = swordDamage;
        this.swordSpeed = swordSpeed;
        this.pickaxeDamage = pickaxeDamage;
        this.pickaxeSpeed = pickaxeSpeed;
        this.axeDamage = axeDamage;
        this.axeSpeed = axeSpeed;
        this.shovelDamage = shovelDamage;
        this.shovelSpeed = shovelSpeed;
        this.hoeDamage = hoeDamage;
        this.hoeSpeed = hoeSpeed;
    }

    public boolean hasSword() {
        return hasSword;
    }

    public boolean hasPickaxe() {
        return hasPickaxe;
    }

    public boolean hasAxe() {
        return hasAxe;
    }

    public boolean hasShovel() {
        return hasShovel;
    }

    public boolean hasHoe() {
        return hasHoe;
    }

    public boolean hasOre() {
        return hasOre;
    }

    public boolean hasDeepOre() {
        return hasDeepOre;
    }

    public boolean hasBlock() {
        return hasBlock;
    }

    public boolean hasGames() {
        return hasGames;
    }

    public int getSwordDamage() {
        return swordDamage;
    }

    public float getSwordSpeed() {
        return swordSpeed;
    }

    public int getPickaxeDamage() {
        return pickaxeDamage;
    }

    public float getPickaxeSpeed() {
        return pickaxeSpeed;
    }

    public float getAxeDamage() {
        return axeDamage;
    }

    public float getAxeSpeed() {
        return axeSpeed;
    }

    public float getShovelDamage() {
        return shovelDamage;
    }

    public float getShovelSpeed() {
        return shovelSpeed;
    }

    public int getHoeDamage() {
        return hoeDamage;
    }

    public float getHoeSpeed() {
        return hoeSpeed;
    }

    public String getName() {
        return name().toLowerCase();
    }
}