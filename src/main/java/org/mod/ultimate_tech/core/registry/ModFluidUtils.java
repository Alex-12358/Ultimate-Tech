package org.mod.ultimate_tech.core.registry;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mod.ultimate_tech.Ultimate_tech;

/**
 * Утилиты для регистрации жидкостей в Forge.
 * Предоставляет методы для создания полноценных жидкостей с блоками и ведрами.
 */
public class ModFluidUtils {

    /**
     * DeferredRegister для регистрации жидкостей в Forge реестр.
     */
    public static final DeferredRegister<net.minecraft.world.level.material.Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Ultimate_tech.MOD_ID);

    /**
     * Регистрирует DeferredRegister жидкостей в событийной шине.
     *
     * @param eventBus событийная шина мода
     */
    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

    /**
     * Контейнер для всех компонентов простой жидкости.
     * Содержит: исходную жидкость, текущую жидкость, блок и ведро.
     */
    public static class SimpleFluidSet {
        /** Исходная (статичная) жидкость */
        public final RegistryObject<FlowingFluid> source;
        /** Текущая (текущая) жидкость */
        public final RegistryObject<FlowingFluid> flowing;
        /** Блок жидкости */
        public final RegistryObject<LiquidBlock> block;
        /** Ведро жидкости */
        public final RegistryObject<Item> bucket;

        /**
         * Создаёт новый набор компонентов жидкости.
         *
         * @param source исходная жидкость
         * @param flowing текущая жидкость
         * @param block блок жидкости
         * @param bucket ведро жидкости
         */
        public SimpleFluidSet(
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
     * Регистрирует простую жидкость с исходной, текущей жидкостью, блоком и ведром.
     *
     * Автоматически регистрирует все необходимые компоненты:
     * - Source fluid (статичная жидкость)
     * - Flowing fluid (движущаяся жидкость)
     * - Liquid block (блок жидкости в мире)
     * - Bucket item (ведро с жидкостью)
     *
     * @param name имя жидкости (без префикса "liquid_")
     * @return контейнер со всеми компонентами жидкости
     *
     * Пример использования:
     * <pre>
     * {@code
     * SimpleFluidSet cobalt = registerSimpleFluid("cobalt");
     * // Создаст:
     * // - liquid_cobalt (исходная жидкость)
     * // - flowing_liquid_cobalt (текущая жидкость)
     * // - liquid_cobalt_block (блок жидкости)
     * // - liquid_cobalt_bucket (ведро)
     * }
     * </pre>
     */
    public static SimpleFluidSet registerSimpleFluid(String name) {
        // Ссылки для использования в свойствах жидкости (они будут заполнены позже)
        final RegistryObject<FlowingFluid>[] sourceRef = new RegistryObject[1];
        final RegistryObject<FlowingFluid>[] flowingRef = new RegistryObject[1];
        final RegistryObject<LiquidBlock>[] blockRef = new RegistryObject[1];
        final RegistryObject<Item>[] bucketRef = new RegistryObject[1];

        // Создаём свойства жидкости
        ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(
                ForgeMod.WATER_TYPE, // Используем водный тип жидкости как основу
                () -> sourceRef[0].get(),  // Исходная жидкость
                () -> flowingRef[0].get()  // Текущая жидкость
        )
                .bucket(() -> (BucketItem) bucketRef[0].get())  // Ведро для жидкости
                .block(() -> blockRef[0].get())  // Блок жидкости
                .slopeFindDistance(2)  // Как далеко жидкость ищет склоны (в блоках)
                .levelDecreasePerBlock(1);  // На сколько уменьшается уровень жидкости

        // Регистрируем исходную жидкость (статичная жидкость)
        sourceRef[0] = FLUIDS.register(name,
                () -> new ForgeFlowingFluid.Source(properties));

        // Регистрируем текущую жидкость (движущаяся жидкость)
        flowingRef[0] = FLUIDS.register("flowing_" + name,
                () -> new ForgeFlowingFluid.Flowing(properties));

        // Регистрируем блок жидкости
        blockRef[0] = ModBlockUtils.BLOCKS.register(name + "_block",
                () -> new LiquidBlock(() -> sourceRef[0].get(),
                        net.minecraft.world.level.block.state.BlockBehaviour.Properties
                                .copy(net.minecraft.world.level.block.Blocks.WATER)
                                .noLootTable()));  // Жидкие блоки не дают лут

        // Регистрируем ведро для жидкости
        bucketRef[0] = ModItemsUtils.ITEMS.register(name + "_bucket",
                () -> new BucketItem(() -> sourceRef[0].get(),
                        new Item.Properties()
                                .craftRemainder(Items.BUCKET)  // Рецепт оставляет обычное ведро
                                .stacksTo(1)));  // Ведра не складываются в стопки

        // Возвращаем контейнер со всеми компонентами
        return new SimpleFluidSet(
                sourceRef[0],
                flowingRef[0],
                blockRef[0],
                bucketRef[0]
        );
    }
}
