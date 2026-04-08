package org.mod.ultimate_tech.core.registry.fluid;

import org.mod.ultimate_tech.common.material.ModFluid;
import org.mod.ultimate_tech.core.registry.ModFluidUtils;

import java.util.HashMap;
import java.util.Map;

import static org.mod.ultimate_tech.core.registry.ModFluidUtils.registerSimpleFluid;

public class ModFluids {
    public static final Map<ModFluid, ModFluidUtils.SimpleFluidSet> FLUID = new HashMap<>();
    public static void init(){
        for (ModFluid fluid: ModFluid.values()) {
            if (!fluid.hasFluids()) continue;
            String name = "liquid_" + fluid.getFluidName();
            FLUID.put(
                    fluid,
                    registerSimpleFluid(name)
            );
        }
    }
}
