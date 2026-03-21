package org.mod.ultimate_tech.integration.botarium;

import earth.terrarium.botarium.common.energy.EnergyApi;

public class BotariumCompat {

    public static void init() {
        EnergyApi.registerEnergyBlockEntity(
                () -> ModBlockEntities.BATTERY.get(),
                (level, pos, state, blockEntity, direction) -> {
                    if (blockEntity instanceof BatteryBlockEntity battery) {
                        return battery;
                    }
                    return null;
                }
        );

        EnergyApi.finalizeBlockRegistration();
    }
}
