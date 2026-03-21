package org.mod.ultimate_tech.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import org.mod.ultimate_tech.integration.botarium.BatteryBlockEntity;
import org.mod.ultimate_tech.integration.botarium.ModBlockEntities;

public class BatteryBlock extends BaseEntityBlock {
    protected BatteryBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable());
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BatteryBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> blockEntityType
    ) {
        return blockEntityType == ModBlockEntities.BATTERY.get()
                ? (lvl, pos, blockState, blockEntity) -> BatteryBlockEntity.tick(
                lvl,
                pos,
                blockState,
                (BatteryBlockEntity) blockEntity
        )
                : null;
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BatteryBlockEntity battery) {
            if (player.isShiftKeyDown()) {
                battery.insertEnergy(1000, false);
                player.sendSystemMessage(Component.literal(
                        "Added 1000 energy. Now: " + battery.getStoredEnergy() + " / " + battery.getMaxCapacity()
                ));
            } else {
                player.sendSystemMessage(Component.literal(
                        "Energy: " + battery.getStoredEnergy() + " / " + battery.getMaxCapacity()
                ));
            }
        }

        return InteractionResult.CONSUME;
    }
}
