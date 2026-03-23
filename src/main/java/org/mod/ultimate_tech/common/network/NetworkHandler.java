package org.mod.ultimate_tech.common.network;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.mod.ultimate_tech.Ultimate_tech;
import org.mod.ultimate_tech.common.network.client.RemoveCamoPacket;
import org.mod.ultimate_tech.common.network.client.SetArrowPacket;
import org.mod.ultimate_tech.common.network.client.SetDirectionalPacket;
import org.mod.ultimate_tech.common.network.client.SetFacingPacket;
import org.mod.ultimate_tech.common.tile.ElevatorContainer;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(Ultimate_tech.MOD_ID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    public static void init() {
        int i = 0;
        INSTANCE.registerMessage(i++, TeleportRequest.class, TeleportRequest::encode, TeleportRequest::decode, TeleportHandler::handle);
        INSTANCE.registerMessage(i++, SetDirectionalPacket.class, SetDirectionalPacket::encode, SetDirectionalPacket::decode, SetDirectionalPacket::handle);
        INSTANCE.registerMessage(i++, SetArrowPacket.class, SetArrowPacket::encode, SetArrowPacket::decode, SetArrowPacket::handle);
        INSTANCE.registerMessage(i++, RemoveCamoPacket.class, RemoveCamoPacket::encode, RemoveCamoPacket::decode, RemoveCamoPacket::handle);
        INSTANCE.registerMessage(i++, SetFacingPacket.class, SetFacingPacket::encode, SetFacingPacket::decode, SetFacingPacket::handle);
    }

    public static boolean isBadClientPacket(ServerPlayer player, BlockPos pos) {
        if (player == null || player.isDeadOrDying() || player.isRemoved())
            return true;

        Level world = player.level();
        if (!world.isLoaded(pos))
            return true;

        if (!(player.containerMenu instanceof ElevatorContainer container))
            return true;

        return !container.getPos().equals(pos);
    }
}
