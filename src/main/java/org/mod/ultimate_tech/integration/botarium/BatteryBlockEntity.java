package org.mod.ultimate_tech.integration.botarium;

import earth.terrarium.botarium.common.energy.base.EnergyContainer;
import earth.terrarium.botarium.common.energy.base.EnergySnapshot;
import earth.terrarium.botarium.util.Updatable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BatteryBlockEntity extends BlockEntity implements EnergyContainer, Updatable<BlockEntity> {

    private long energy = 1100;

    private static final long CAPACITY = 10_000;
    private static final long MAX_INSERT = 200;
    private static final long MAX_EXTRACT = 200;


    public BatteryBlockEntity(BlockPos pPos, BlockState pState) {
        super(ModBlockEntities.BATTERY.get(), pPos, pState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BatteryBlockEntity battery) {
        if (level.isClientSide) return;

        for (Direction direction : Direction.values()) {
            if (battery.getStoredEnergy() <= 0) {
                return;
            }

            BlockPos targetPos = pos.relative(direction);
            EnergyContainer target = EnergyContainer.of(level, targetPos, direction.getOpposite());

            if (target == null) {
                continue;
            }

            long maxSend = Math.min(100, battery.getStoredEnergy());
            if (maxSend <= 0) {
                continue;
            }

            long accepted = target.insertEnergy(maxSend, true);
            if (accepted <= 0) {
                continue;
            }

            long extracted = battery.extractEnergy(accepted, false);
            if (extracted <= 0) {
                continue;
            }

            long inserted = target.insertEnergy(extracted, false);

            if (inserted < extracted) {
                battery.insertEnergy(extracted - inserted, false);
            }

            if (inserted > 0) {
                System.out.println("Sent " + inserted + " energy from " + pos + " to " + targetPos + " side " + direction);
            }
        }
    }

    @Override
    public long insertEnergy(long maxAmount, boolean simulate) {
        if (!allowsInsertion() || maxAmount <= 0) return 0;

        long inserted = Math.min(maxAmount, Math.min(MAX_INSERT, CAPACITY - energy));

        if (!simulate && inserted > 0) {
            energy += inserted;
            setChanged();
        }

        return inserted;
    }

    @Override
    public long extractEnergy(long maxAmount, boolean simulate) {
        if (!allowsExtraction() || maxAmount <= 0) return 0;

        long extracted = Math.min(maxAmount, Math.min(MAX_EXTRACT, energy));

        if (!simulate && extracted > 0) {
            energy -= extracted;
            setChanged();
        }

        return extracted;
    }

    @Override
    public void setEnergy(long energy) {
        this.energy = Math.max(0, Math.min(CAPACITY, energy));
        setChanged();
    }

    @Override
    public long getStoredEnergy() {
        return energy;
    }

    @Override
    public long getMaxCapacity() {
        return CAPACITY;
    }

    @Override
    public long maxInsert() {
        return MAX_INSERT;
    }

    @Override
    public long maxExtract() {
        return MAX_EXTRACT;
    }

    @Override
    public boolean allowsInsertion() {
        return true;
    }

    @Override
    public boolean allowsExtraction() {
        return true;
    }

    @Override
    public EnergySnapshot createSnapshot() {
        final long stored = this.energy;
        return container -> container.setEnergy(stored);
    }

    @Override
    public void clearContent() {
        this.energy = 0;
        setChanged();
    }

    @Override
    public CompoundTag serialize(CompoundTag tag) {
        tag.putLong("Energy", this.energy);
        return tag;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putLong("Energy", this.energy);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.energy = tag.getLong("Energy");
    }

    @Override
    public void deserialize(CompoundTag tag) {
        this.energy = tag.getLong("Energy");
    }

    @Override
    public EnergyContainer getContainer(Direction direction) {
        return this;
    }

    @Override
    public void update(BlockEntity object) {
        object.setChanged();
    }

//    @Override
//    public EnergyContainer getContainer(Direction direction) {
//        return this;
//    }
}
