package org.mod.ultimate_tech.common.material;

public enum ModGames {
    RUBY(
            true, true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            7.0f, 1.0f,
            0.0f, 0.0f,
            0, 0.0f,
            0
    ),
    SAPPHIRE(
            true, true, true,
            true, true, true,
            5, 1.8f,
            2, 1.0f,
            6.0f, 0.8f,
            1.0f, 0.0f,
            0, 0.0f,
            0
    ),
    TOPAZ(
            true, true, true,
            true, true, true,
            4, 2.1f,
            1, 1.0f,
            6.5f, 0.9f,
            0.5f, 0.0f,
            0, 0.0f,
            0
    ),
    AMETHYST(
            true, true, true,
            true, true, true,
            3, 2.4f,
            1, 1.2f,
            5.5f, 1.1f,
            0.0f, 0.1f,
            0, 0.0f,
            0
    ),
    GARNET(
            true, true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            7.0f, 1.0f,
            0.0f, 0.0f,
            0, 0.0f,
            0
    ),
    OPAL(
            true, true, true,
            true, true, true,
            3, 2.3f,
            1, 1.1f,
            5.8f, 1.0f,
            0.2f, 0.0f,
            0, 0.0f,
            0
    ),
    JADE(
            true, true, true,
            true, true, true,
            4, 1.9f,
            2, 0.9f,
            7.2f, 0.8f,
            0.5f, -0.1f,
            0, 0.0f,
            0
    ),
    MALACHITE(
            true, true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            6.8f, 0.9f,
            0.3f, 0.0f,
            0, 0.0f,
            0
    ),
    AQUAMARINE(
            true, true, true,
            true, true, true,
            4, 2.2f,
            1, 1.1f,
            6.0f, 1.0f,
            0.2f, 0.1f,
            0, 0.0f,
            0
    ),
    SPINEL(
            true, true, true,
            true, true, true,
            5, 1.9f,
            2, 1.0f,
            7.5f, 0.8f,
            0.5f, 0.0f,
            0, 0.0f,
            0
    ),
    ZIRCON(
            true, true, true,
            true, true, true,
            4, 2.0f,
            1, 1.0f,
            6.7f, 0.9f,
            0.3f, 0.0f,
            0, 0.0f,
            0
    ),
    MORGANITE(
            true, true, true,
            true, true, true,
            4, 2.1f,
            1, 1.0f,
            6.3f, 1.0f,
            0.2f, 0.0f,
            0, 0.0f,
            0xFF69B4
    );

    private final boolean hasGames;
    private final boolean hasSword;
    private final boolean hasPickaxe;
    private final boolean hasAxe;
    private final boolean hasShovel;
    private final boolean hasHoe;

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

    private final int colorHex;

    ModGames(
            boolean hasGames,
            boolean hasSword,
            boolean hasPickaxe,
            boolean hasAxe,
            boolean hasShovel,
            boolean hasHoe,
            int swordDamage,
            float swordSpeed,
            int pickaxeDamage,
            float pickaxeSpeed,
            float axeDamage,
            float axeSpeed,
            float shovelDamage,
            float shovelSpeed,
            int hoeDamage,
            float hoeSpeed,
            int colorHex
    ) {
        this.hasGames = hasGames;
        this.hasSword = hasSword;
        this.hasPickaxe = hasPickaxe;
        this.hasAxe = hasAxe;
        this.hasShovel = hasShovel;
        this.hasHoe = hasHoe;
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
        this.colorHex = colorHex;
    }

    public boolean hasGames() {
        return hasGames;
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

    public int getColorHex() {
        return colorHex;
    }
}