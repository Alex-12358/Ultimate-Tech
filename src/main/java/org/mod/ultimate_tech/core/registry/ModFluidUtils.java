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

public class ModFluidUtils {

    public static final DeferredRegister<net.minecraft.world.level.material.Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Ultimate_tech.MOD_ID);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

    public static class SimpleFluidSet {
        public final RegistryObject<FlowingFluid> source;
        public final RegistryObject<FlowingFluid> flowing;
        public final RegistryObject<LiquidBlock> block;
        public final RegistryObject<Item> bucket;

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

    public static SimpleFluidSet registerSimpleFluid(String name) {
        final RegistryObject<FlowingFluid>[] sourceRef = new RegistryObject[1];
        final RegistryObject<FlowingFluid>[] flowingRef = new RegistryObject[1];
        final RegistryObject<LiquidBlock>[] blockRef = new RegistryObject[1];
        final RegistryObject<Item>[] bucketRef = new RegistryObject[1];

        ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(
                ForgeMod.WATER_TYPE,
                () -> sourceRef[0].get(),
                () -> flowingRef[0].get()
        )
                .bucket(() -> (BucketItem) bucketRef[0].get())
                .block(() -> blockRef[0].get())
                .slopeFindDistance(2)
                .levelDecreasePerBlock(1);

        sourceRef[0] = FLUIDS.register(name,
                () -> new ForgeFlowingFluid.Source(properties));

        flowingRef[0] = FLUIDS.register("flowing_" + name,
                () -> new ForgeFlowingFluid.Flowing(properties));

        blockRef[0] = ModBlockUtils.BLOCKS.register(name + "_block",
                () -> new LiquidBlock(() -> sourceRef[0].get(),
                        net.minecraft.world.level.block.state.BlockBehaviour.Properties
                                .copy(net.minecraft.world.level.block.Blocks.WATER)
                                .noLootTable()));

        bucketRef[0] = ModItemsUtils.ITEMS.register(name + "_bucket",
                () -> new BucketItem(() -> sourceRef[0].get(),
                        new Item.Properties()
                                .craftRemainder(Items.BUCKET)
                                .stacksTo(1)));

        return new SimpleFluidSet(
                sourceRef[0],
                flowingRef[0],
                blockRef[0],
                bucketRef[0]
        );
    }
}
