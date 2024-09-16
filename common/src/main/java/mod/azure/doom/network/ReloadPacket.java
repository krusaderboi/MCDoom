package mod.azure.doom.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import mod.azure.doom.items.weapons.DoomBaseItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;

public class ReloadPacket {

    public ReloadPacket() {
    }

    public static ReloadPacket decode(FriendlyByteBuf buf) {
        return new ReloadPacket();
    }

    public static void handle(PacketContext<ReloadPacket> ctx) {
        if (Side.SERVER.equals(ctx.side()) && ctx.sender().getMainHandItem().getItem() instanceof DoomBaseItem)
            DoomBaseItem.reload(ctx.sender(), InteractionHand.MAIN_HAND);
    }

    public void encode(FriendlyByteBuf buf) {

    }
}
