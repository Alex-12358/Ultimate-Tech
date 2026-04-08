package org.mod.ultimate_tech.common.material;

public enum ModFluid {
    REDSTONE(true),
    CRUDE_OIL(true);

    private final boolean hasFluids;

    ModFluid(boolean hasFluids) {
        this.hasFluids = hasFluids;
    }

    public boolean hasFluids(){
        return hasFluids;
    }

    public String getFluidName(){
        return name().toLowerCase();
    };
}
