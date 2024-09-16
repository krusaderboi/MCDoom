package mod.azure.doom.network;

import commonnetwork.api.Network;
import mod.azure.azurelib.common.internal.common.network.AbstractPacket;
import mod.azure.azurelib.common.platform.Services;
import mod.azure.doom.MCDoom;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record PacketHandler() {

    public static final ResourceLocation lockSlot = MCDoom.modResource("select_craft");
    public static final ResourceLocation reloadMelee = MCDoom.modResource("reload_melee");
    public static final ResourceLocation reloadGun = MCDoom.modResource("reload");
    public static final ResourceLocation shootGun = MCDoom.modResource("shoot");
    public static final ResourceLocation hookShot = MCDoom.modResource("hook");

    public static void registerMessages() {
        Network.registerPacket(reloadMelee, ReloadMeleePacket.class, ReloadMeleePacket::encode, ReloadMeleePacket::decode, ReloadMeleePacket::handle)
                .registerPacket(lockSlot, CraftingPacket.class, CraftingPacket::encode, CraftingPacket::decode, CraftingPacket::handle)
                .registerPacket(reloadGun, ReloadPacket.class, ReloadPacket::encode, ReloadPacket::decode, ReloadPacket::handle)
                .registerPacket(shootGun, FiringPacket.class, FiringPacket::encode, FiringPacket::decode, FiringPacket::handle)
                .registerPacket(hookShot, HookPacket.class, HookPacket::encode, HookPacket::decode, HookPacket::handle);
    }

    private static <B extends FriendlyByteBuf, P extends AbstractPacket> void registerPacket(CustomPacketPayload.Type<P> payloadType, StreamCodec<B, P> codec) {
        Services.NETWORK.registerPacketInternal(payloadType, codec, true);
    }
}
