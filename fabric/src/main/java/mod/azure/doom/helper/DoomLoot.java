package mod.azure.doom.helper;

import net.minecraft.resources.ResourceLocation;

public record DoomLoot() {

    public static final ResourceLocation BASTION_BRIDGE = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_bridge");
    public static final ResourceLocation BASTION_HOGLIN_STABLE = ResourceLocation.fromNamespaceAndPath("minecraft",
            "chests/bastion_hoglin_stable");
    public static final ResourceLocation BASTION_OTHER = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_other");
    public static final ResourceLocation BASTION_TREASURE = ResourceLocation.fromNamespaceAndPath("minecraft",
            "chests/bastion_treasure");
    public static final ResourceLocation NETHER_BRIDGE = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/nether_bridge");
    public static final ResourceLocation RUINED_PORTAL = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/ruined_portal");
    public static final ResourceLocation SPAWN_BONUS_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft",
            "chests/spawn_bonus_chest");

}