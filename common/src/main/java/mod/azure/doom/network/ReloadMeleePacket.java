package mod.azure.doom.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import mod.azure.doom.items.weapons.BaseSwordItem;
import mod.azure.doom.items.weapons.DoomBaseItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;

public class ReloadMeleePacket {

    public ReloadMeleePacket() {
    }

    public static ReloadMeleePacket decode(FriendlyByteBuf buf) {
        return new ReloadMeleePacket();
    }

    public static void handle(PacketContext<ReloadMeleePacket> ctx) {
        if (Side.SERVER.equals(ctx.side()) && ctx.sender().getMainHandItem().getItem() instanceof BaseSwordItem)
            BaseSwordItem.reload(ctx.sender(), InteractionHand.MAIN_HAND);
    }

    public void encode(FriendlyByteBuf buf) {

    }
}
