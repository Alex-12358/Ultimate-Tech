package org.mod.ultimate_tech.core.registry.fluid;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.material.ModFluid;

/**
 * Регистрация типов жидкостей.
 * Каждый тип определяет текстуры и свойства жидкости.
 */
public class FluidTypesRegistry {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Ultimate_tech.MOD_ID);

    // ============ REDSTONE FLUID TYPE ============
    public static final RegistryObject<FluidType> REDSTONE_FLUID_TYPE =
            FLUID_TYPES.register("redstone_fluid", () -> new BaseFluidType(
                    new ResourceLocation(Ultimate_tech.MOD_ID, "block/redstone_fluid_still"),
                    new ResourceLocation(Ultimate_tech.MOD_ID, "block/redstone_fluid_flowing"),
                    new ResourceLocation(Ultimate_tech.MOD_ID, "block/redstone_fluid_overlay"),
                    0xFFFF0000  // Красный цвет
            ));

    // ============ CRUDE_OIL FLUID TYPE ============
    public static final RegistryObject<FluidType> CRUDE_OIL_FLUID_TYPE =
            FLUID_TYPES.register("crude_oil_fluid", () -> new BaseFluidType(
                    new ResourceLocation(Ultimate_tech.MOD_ID, "block/crude_oil_fluid_still"),
                    new ResourceLocation(Ultimate_tech.MOD_ID, "block/crude_oil_fluid_flowing"),
                    new ResourceLocation(Ultimate_tech.MOD_ID, "block/crude_oil_fluid_overlay"),
                    0xFF1a1a1a  // Почти чёрный цвет
            ));

    /**
     * Регистрирует все типы жидкостей в событийной шине.
     */
    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

    /**
     * Получает тип жидкости для конкретного enum значения.
     *
     * @param fluid enum значение из ModFluid
     * @return FluidType для этой жидкости
     */
    public static FluidType getFluidType(ModFluid fluid) {
        if (fluid == ModFluid.REDSTONE) {
            return REDSTONE_FLUID_TYPE.get();
        } else if (fluid == ModFluid.CRUDE_OIL) {
            return CRUDE_OIL_FLUID_TYPE.get();
        }
        throw new IllegalArgumentException("Unknown fluid: " + fluid);
    }
}


