package org.mod.ultimate_tech;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.mod.ultimate_tech.common.block.ElevatorBlock;
import org.mod.ultimate_tech.common.init.ModConfig;
import org.mod.ultimate_tech.common.network.NetworkHandler;
import org.mod.ultimate_tech.common.network.TeleportHandler;
import org.mod.ultimate_tech.common.network.TeleportRequest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Ultimate_tech.MOD_ID)
public class Config {
    private static boolean lastSneaking;
    private static boolean lastJumping;

    @SubscribeEvent
    public static void onInput(InputEvent event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null || player.isSpectator() || !player.isAlive() || player.input == null) {
            return;
        }

        boolean sneaking = player.input.shiftKeyDown;
        if (lastSneaking != sneaking) {
            lastSneaking = sneaking;
            if (sneaking)
                tryTeleport(player, Direction.DOWN);
        }

        boolean jumping = player.input.jumping;
        if (lastJumping != jumping) {
            lastJumping = jumping;
            if (jumping)
                tryTeleport(player, Direction.UP);
        }
    }

    @SubscribeEvent
    public static void onLivingUpdate(TickEvent.PlayerTickEvent event) {
//        if (event.phase != TickEvent.Phase.END || !event.player.level().isClientSide)
//            return;
//
//        LocalPlayer player = (LocalPlayer) event.player;
//
//        boolean jumping = (player.getDeltaMovement().y > 0 || player.input.jumping) // for 2 block gaps where the player hits the ceiling
//                && !player.onGround();
//        if (lastJumping != jumping) {
//            lastJumping = jumping;
//            if (jumping) {
//                tryTeleport(player, Direction.UP);
//            }
//        }
//
//        boolean crouching = player.isCrouching();
//        if (lastSneaking != crouching) {
//            lastSneaking = crouching;
//            if (crouching) {
//                tryTeleport(player, Direction.DOWN);
//            }
//        }
    }

    private static void tryTeleport(LocalPlayer player, Direction facing) {
        BlockGetter world = player.getCommandSenderWorld();

        BlockPos fromPos = getOriginElevator(player);
        if (fromPos == null) return;

        BlockPos.MutableBlockPos toPos = fromPos.mutable();

        ElevatorBlock fromElevator;
        fromElevator = (ElevatorBlock) world.getBlockState(fromPos).getBlock();

        while (true) {
            toPos.setY(toPos.getY() + facing.getStepY());
            if (world.isOutsideBuildHeight(toPos) || Math.abs(toPos.getY() - fromPos.getY()) > ModConfig.GENERAL.range.get())
                break;

            ElevatorBlock toElevator = TeleportHandler.getElevator(world.getBlockState(toPos));
            if (toElevator != null && TeleportHandler.isValidPos(world, toPos)) {
                if (!ModConfig.GENERAL.sameColor.get() || fromElevator.getColor() == toElevator.getColor()) {
                    NetworkHandler.INSTANCE.sendToServer(new TeleportRequest(fromPos, toPos));
                    break;
                }
            }
        }
    }

    /**
     * Checks if a player(lower part) is in or has an elevator up to 2 blocks below
     *
     * @param player the player trying to teleport
     * @return the position of the first valid elevator or null if it doesn't exist
     */
    private static BlockPos getOriginElevator(LocalPlayer player) {
        Level world = player.level();
        BlockPos pos = player.blockPosition();

        // Check the player's feet and the 2 blocks under it
        for (int i = 0; i < 3; i++) {
            if (TeleportHandler.getElevator(world.getBlockState(pos)) != null)
                return pos;
            pos = pos.below();
        }

        // Elevator doesn't exist or it's invalid
        return null;
    }





    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER.comment("Whether to log the dirt block on common setup").define("logDirtBlock", true);
    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER.comment("A magic number").defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER.comment("What you want the introduction message to be for the magic number").define("magicNumberIntroduction", "The magic number is... ");
    // a list of strings that are treated as resource locations for items
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER.comment("A list of items to log on common setup.").defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);
    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static boolean logDirtBlock;
    public static int magicNumber;
    public static String magicNumberIntroduction;
    public static Set<Item> items;
    private static boolean validateItemName(final Object obj) {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        logDirtBlock = LOG_DIRT_BLOCK.get();
        magicNumber = MAGIC_NUMBER.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream().map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName))).collect(Collectors.toSet());
    }
}
