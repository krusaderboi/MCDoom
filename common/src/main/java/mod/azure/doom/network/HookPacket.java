package mod.azure.doom.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import mod.azure.doom.items.weapons.DoomBaseItem;
import net.minecraft.network.FriendlyByteBuf;

public class HookPacket {
    public HookPacket() {
    }

    public static HookPacket decode(FriendlyByteBuf buf) {
        return new HookPacket();
    }

    public static void handle(PacketContext<HookPacket> ctx) {
        if (Side.SERVER.equals(ctx.side()) && ctx.sender().getMainHandItem().getItem() instanceof DoomBaseItem)
            DoomBaseItem.shootHook(ctx.sender());
    }

    public void encode(FriendlyByteBuf buf) {

    }
}
