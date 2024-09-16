package mod.azure.doom.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import mod.azure.doom.items.weapons.DoomBaseItem;
import net.minecraft.network.FriendlyByteBuf;

public class FiringPacket {
    public FiringPacket() {
    }

    public static FiringPacket decode(FriendlyByteBuf buf) {
        return new FiringPacket();
    }

    public static void handle(PacketContext<FiringPacket> ctx) {
        if (Side.SERVER.equals(ctx.side()) && ctx.sender().getMainHandItem().getItem() instanceof DoomBaseItem)
            DoomBaseItem.shoot(ctx.sender());
    }

    public void encode(FriendlyByteBuf buf) {

    }
}
