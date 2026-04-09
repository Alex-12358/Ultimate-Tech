package org.mod.ultimate_tech.core.registry.fluid;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.material.ModFluid;
import org.mod.ultimate_tech.core.registry.ModBlockUtils;
import org.mod.ultimate_tech.core.registry.ModItemsUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Регистрация жидкостей - автоматически читает enum ModFluid.
 * Для каждого enum значения с hasFluids() == true создаёт жидкость.
 */
public class ModFluidsRegistry {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Ultimate_tech.MOD_ID);

    /**
     * Map для хранения всех компонентов жидкостей.
     * Ключ: ModFluid enum значение
     * Значение: FluidSet (source, flowing, block, bucket)
     */
    public static final Map<ModFluid, FluidSet> FLUID_SETS = new HashMap<>();

    /**
     * Контейнер для всех компонентов жидкости.
     */
    public static class FluidSet {
        public final RegistryObject<FlowingFluid> source;
        public final RegistryObject<FlowingFluid> flowing;
        public final RegistryObject<LiquidBlock> block;
        public final RegistryObject<Item> bucket;

        public FluidSet(
                RegistryObject<FlowingFluid> source,
                RegistryObject<FlowingFluid> flowing,
                RegistryObject<LiquidBlock> block,
                RegistryObject<Item> bucket
        ) {
            this.source = source;
            this.flowing = flowing;
            this.block = block;
            this.bucket = bucket;
        }
    }

    /**
     * Инициализирует все жидкости из enum ModFluid.
     * Вызывается один раз при загрузке класса.
     */
    static {
        for (ModFluid fluid : ModFluid.values()) {
            if (!fluid.hasFluids()) {
                continue; // Пропускаем если это не жидкость
            }

            String fluidName = fluid.getFluidName();

            // Создаём источник жидкости
            RegistryObject<FlowingFluid> source = FLUIDS.register(
                    fluidName + "_source",
                    () -> new ForgeFlowingFluid.Source(makeProperties(fluidName))
            );

            // Создаём текущую жидкость
            RegistryObject<FlowingFluid> flowing = FLUIDS.register(
                    fluidName + "_flowing",
                    () -> new ForgeFlowingFluid.Flowing(makeProperties(fluidName))
            );

            // Создаём блок жидкости
            RegistryObject<LiquidBlock> block = ModBlockUtils.BLOCKS.register(
                    fluidName + "_block",
                    () -> new LiquidBlock(() -> source.get(),
                            net.minecraft.world.level.block.state.BlockBehaviour.Properties
                                    .copy(Blocks.WATER)
                                    .noLootTable())
            );

            // Создаём ведро для жидкости
            RegistryObject<Item> bucket = ModItemsUtils.ITEMS.register(
                    fluidName + "_bucket",
                    () -> new BucketItem(() -> source.get(),
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1))
            );

            // Сохраняем набор в map
            FLUID_SETS.put(fluid, new FluidSet(source, flowing, block, bucket));
        }
    }

    /**
     * Создаёт свойства для жидкости.
     * Параметризовано для работы со всеми жидкостями.
     */
    private static ForgeFlowingFluid.Properties makeProperties(String fluidName) {
        // Получаем FluidSet из карты
        ModFluid fluidType = null;
        for (ModFluid f : ModFluid.values()) {
            if (f.getFluidName().equals(fluidName)) {
                fluidType = f;
                break;
            }
        }

        if (fluidType == null || !FLUID_SETS.containsKey(fluidType)) {
            throw new IllegalArgumentException("Fluid not found: " + fluidName);
        }

        FluidSet set = FLUID_SETS.get(fluidType);

        // Создаём свойства С ведром
        // Ведро должно быть зарегистрировано в ModItemsUtils
        return new ForgeFlowingFluid.Properties(
                net.minecraftforge.common.ForgeMod.WATER_TYPE,
                set.source,
                set.flowing
        ).bucket(() -> set.bucket.get())
         .block(() -> set.block.get())
         .slopeFindDistance(2)
         .levelDecreasePerBlock(1);
    }

    /**
     * Регистрирует все жидкости в событийной шине.
     */
    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

    /**
     * Получает FluidSet для конкретной жидкости.
     *
     * @param fluid enum значение из ModFluid
     * @return FluidSet с компонентами жидкости
     */
    public static FluidSet getFluidSet(ModFluid fluid) {
        return FLUID_SETS.get(fluid);
    }
}




