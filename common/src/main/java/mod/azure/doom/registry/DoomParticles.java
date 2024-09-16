package mod.azure.doom.registry;

import mod.azure.doom.MCDoom;
import mod.azure.doom.particles.DoomParticleType;
import mod.azure.doom.registry.interfaces.CommonParticleRegistryInterface;

import java.util.function.Supplier;

public class DoomParticles {
    public static final Supplier<DoomParticleType> PLASMA = CommonParticleRegistryInterface.registerParticle(
            MCDoom.MOD_ID, "plasma", () -> new DoomParticleType(true));
    public static final Supplier<DoomParticleType> PISTOL = CommonParticleRegistryInterface.registerParticle(
            MCDoom.MOD_ID, "pistol", () -> new DoomParticleType(true));
    public static final Supplier<DoomParticleType> UNMAYKR = CommonParticleRegistryInterface.registerParticle(
            MCDoom.MOD_ID, "unmaykr", () -> new DoomParticleType(true));

    public static void init() {
    }
}
