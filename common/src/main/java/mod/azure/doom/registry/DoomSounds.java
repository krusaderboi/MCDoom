package mod.azure.doom.registry;

import mod.azure.doom.MCDoom;
import mod.azure.doom.registry.interfaces.CommonSoundRegistryInterface;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class DoomSounds {

    public static final Supplier<SoundEvent> MICROWAVE_BEAM = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.microwave",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.microwave")));

    public static final Supplier<SoundEvent> EMPTY = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.emptyclip",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.emptyclip")));
    public static final Supplier<SoundEvent> BEEP = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.grenadeabouttoexplode",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.grenadeabouttoexplode")));

    public static final Supplier<SoundEvent> BFG_FIRING = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.bfg_firing",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.bfg_firing")));
    public static final Supplier<SoundEvent> BFG_HIT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.bfg_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.bfg_hit")));

    public static final Supplier<SoundEvent> PLASMA_FIRING = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.plasmafire",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.plasmafire")));
    public static final Supplier<SoundEvent> PLASMA_HIT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.plasmahit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.plasmahit")));

    public static final Supplier<SoundEvent> HEAVY_CANNON = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.heavy_cannon",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.heavy_cannon")));

    public static final Supplier<SoundEvent> CHAINSAW_ATTACKING = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.chainsaw_attacking",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.chainsaw_attacking")));
    public static final Supplier<SoundEvent> CHAINSAW_IDLE = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.chainsaw_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.chainsaw_idle")));

    public static final Supplier<SoundEvent> ROCKET_FIRING = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.rocketfire",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.rocketfire")));
    public static final Supplier<SoundEvent> ROCKET_HIT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.rockethit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.rockethit")));

    public static final Supplier<SoundEvent> SHOOT1 = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.shoot1",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.shoot1")));

    public static final Supplier<SoundEvent> CHAINGUN_SHOOT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.chaingun_fire",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.chaingun_fire")));

    public static final Supplier<SoundEvent> PISTOL_HIT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pistol_fire",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pistol_fire")));

    public static final Supplier<SoundEvent> CLIPRELOAD = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.clipreload",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.clipreload")));

    public static final Supplier<SoundEvent> SHOTGUN_SHOOT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.shotgun_fire",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.shotgun_fire")));

    public static final Supplier<SoundEvent> SHOTGUNRELOAD = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.shotgunreload",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.shotgunreload")));

    public static final Supplier<SoundEvent> SUPER_SHOTGUN_SHOOT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.super_shotgun_fire",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.super_shotgun_fire")));

    public static final Supplier<SoundEvent> UNMAKYR_FIRE = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.unmakyr_fire",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.unmakyr_fire")));

    public static final Supplier<SoundEvent> LOADING_END = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.loading_end",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.loading_end")));

    public static final Supplier<SoundEvent> QUICK1_1 = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.quick1_1",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.quick1_1")));

    public static final Supplier<SoundEvent> CRUCIBLE_LEFT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "crucible_left",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("crucible_left")));
    public static final Supplier<SoundEvent> CRUCIBLE_RIGHT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "crucible_right",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("crucible_right")));
    public static final Supplier<SoundEvent> CRUCIBLE_STAB = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "crucible_stab",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("crucible_stab")));

    public static final Supplier<SoundEvent> CRUCIBLE_HAMMER = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "crucible_hammer",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("crucible_hammer")));
    public static final Supplier<SoundEvent> CRUCIBLE_AXE_RIGHT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "crucible_axe_right",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("crucible_axe_right")));
    public static final Supplier<SoundEvent> CRUCIBLE_AXE_LEFT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "crucible_axe_left",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("crucible_axe_left")));

    public static final Supplier<SoundEvent> E1M1 = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.e1m1",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.e1m1")));
    public static final Supplier<SoundEvent> NETHERAMBIENT_GEOFFPLAYSGUITAR = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, 
            "doom.netherambient_geoffplaysguitar",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.netherambient_geoffplaysguitar")));

    public static final Supplier<SoundEvent> IMP_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.imp_ambient",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.imp_ambient")));
    public static final Supplier<SoundEvent> IMP_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.imp_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.imp_death")));
    public static final Supplier<SoundEvent> IMP_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.imp_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.imp_hurt")));
    public static final Supplier<SoundEvent> IMP_STEP = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.imp_step",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.imp_step")));

    public static final Supplier<SoundEvent> ARCHVILE_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arch_vile_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arch_vile_death")));
    public static final Supplier<SoundEvent> ARCHVILE_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arch_vile_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arch_vile_hit")));
    public static final Supplier<SoundEvent> ARCHVILE_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arch_vile_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arch_vile_idle")));
    public static final Supplier<SoundEvent> ARCHVILE_PORTAL = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arch_vile_portal",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arch_vile_portal")));
    public static final Supplier<SoundEvent> ARCHVILE_SCREAM = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arch_vile_scream",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arch_vile_scream")));
    public static final Supplier<SoundEvent> ARCHVILE_STARE = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arch_vile_stare",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arch_vile_stare")));

    public static final Supplier<SoundEvent> BARON_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.baron_angry",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.baron_angry")));
    public static final Supplier<SoundEvent> BARON_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.baron_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.baron_death")));
    public static final Supplier<SoundEvent> BARON_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.baron_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.baron_hurt")));
    public static final Supplier<SoundEvent> BARON_STEP = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.baron_say",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.baron_say")));

    public static final Supplier<SoundEvent> PINKY_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pinky_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pinky_idle")));
    public static final Supplier<SoundEvent> PINKY_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pinky_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pinky_death")));
    public static final Supplier<SoundEvent> PINKY_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pinky_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pinky_hurt")));
    public static final Supplier<SoundEvent> PINKY_STEP = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pinky_step",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pinky_step")));
    public static final Supplier<SoundEvent> PINKY_YELL = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pinky_yell",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pinky_yell")));

    public static final Supplier<SoundEvent> LOST_SOUL_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.lost_soul_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.lost_soul_death")));
    public static final Supplier<SoundEvent> LOST_SOUL_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.lost_soul_say",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.lost_soul_say")));

    public static final Supplier<SoundEvent> CACODEMON_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.cacodemon_moan",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cacodemon_moan")));
    public static final Supplier<SoundEvent> CACODEMON_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.cacodemon_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cacodemon_death")));
    public static final Supplier<SoundEvent> CACODEMON_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.cacodemon_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cacodemon_hit")));
    public static final Supplier<SoundEvent> CACODEMON_AFFECTIONATE_SCREAM = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, 
            "doom.cacodemon_affectionate_scream",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cacodemon_affectionate_scream")));

    public static final Supplier<SoundEvent> SPIDERDEMON_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.spiderdemon_step",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.spiderdemon_step")));
    public static final Supplier<SoundEvent> SPIDERDEMON_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.spiderdemon_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cacodemon_death")));
    public static final Supplier<SoundEvent> SPIDERDEMON_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.spiderdemon_say",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.spiderdemon_say")));

    public static final Supplier<SoundEvent> ZOMBIEMAN_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.zombieman_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.zombieman_idle")));
    public static final Supplier<SoundEvent> ZOMBIEMAN_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.zombieman_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.zombieman_death")));
    public static final Supplier<SoundEvent> ZOMBIEMAN_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.zombieman_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.zombieman_hurt")));

    public static final Supplier<SoundEvent> CYBERDEMON_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.cyberdemon_throw",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cyberdemon_throw")));
    public static final Supplier<SoundEvent> CYBERDEMON_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.cyberdemon_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cyberdemon_death")));
    public static final Supplier<SoundEvent> CYBERDEMON_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.cyberdemon_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cyberdemon_hit")));
    public static final Supplier<SoundEvent> CYBERDEMON_STEP = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.cyberdemon_walk",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.cyberdemon_walk")));

    public static final Supplier<SoundEvent> MANCUBUS_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mancubus_say",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mancubus_say")));
    public static final Supplier<SoundEvent> MANCUBUS_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mancubus_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mancubus_death")));
    public static final Supplier<SoundEvent> MANCUBUS_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mancubus_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mancubus_hit")));
    public static final Supplier<SoundEvent> MANCUBUS_STEP = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mancubus_walk",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mancubus_walk")));

    public static final Supplier<SoundEvent> REVENANT_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.revenant_say",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.revenant_say")));
    public static final Supplier<SoundEvent> REVENANT_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.revenant_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.revenant_death")));
    public static final Supplier<SoundEvent> REVENANT_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.revenant_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.revenant_hurt")));
    public static final Supplier<SoundEvent> REVENANT_ATTACK = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.revenant_attack",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.revenant_attack")));
    public static final Supplier<SoundEvent> REVENANT_DOOT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.revenant_doot",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.revenant_doot")));

    public static final Supplier<SoundEvent> HELLKNIGHT_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.hellknight_say",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.hellknight_say")));
    public static final Supplier<SoundEvent> HELLKNIGHT_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.hellknight_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.hellknight_death")));
    public static final Supplier<SoundEvent> HELLKNIGHT_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.hellknight_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.hellknight_hurt")));

    public static final Supplier<SoundEvent> PAIN_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pain_say",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pain_say")));
    public static final Supplier<SoundEvent> PAIN_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pain_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pain_death")));
    public static final Supplier<SoundEvent> PAIN_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.pain_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.pain_hurt")));

    public static final Supplier<SoundEvent> ICON_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.icon_ambient",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.icon_ambient")));
    public static final Supplier<SoundEvent> ICON_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.icon_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.icon_death")));
    public static final Supplier<SoundEvent> ICON_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.icon_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.icon_hurt")));

    public static final Supplier<SoundEvent> ARACHNOTRON_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arachnotron_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arachnotron_idle")));
    public static final Supplier<SoundEvent> ARACHNOTRON_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arachnotron_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arachnotron_death")));
    public static final Supplier<SoundEvent> ARACHNOTRON_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.arachnotron_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.arachnotron_hurt")));

    public static final Supplier<SoundEvent> BALLISTA_FIRING = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.ballista_firing",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.ballista_firing")));

    public static final Supplier<SoundEvent> PSOLDIER_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.psoldier_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.psoldier_idle")));
    public static final Supplier<SoundEvent> PSOLDIER_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.psoldier_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.psoldier_death")));
    public static final Supplier<SoundEvent> PSOLDIER_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.psoldier_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.psoldier_hit")));

    public static final Supplier<SoundEvent> GARGOLYE_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.gargolye_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.gargolye_idle")));
    public static final Supplier<SoundEvent> GARGOLYE_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.gargolye_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.gargolye_death")));
    public static final Supplier<SoundEvent> GARGOLYE_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.gargolye_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.gargolye_hit")));

    public static final Supplier<SoundEvent> MECHA_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mecha_idle",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mecha_idle")));
    public static final Supplier<SoundEvent> MECHA_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mecha_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mecha_death")));
    public static final Supplier<SoundEvent> MECHA_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mecha_hit",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mecha_hit")));

    public static final Supplier<SoundEvent> WHIPLASH_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.whiplash_ambient",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.whiplash_ambient")));
    public static final Supplier<SoundEvent> WHIPLASH_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.whiplash_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.whiplash_death")));
    public static final Supplier<SoundEvent> WHIPLASH_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.whiplash_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.whiplash_hurt")));

    public static final Supplier<SoundEvent> DOOMHUNTER_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.doomhunter_ambient",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.doomhunter_ambient")));
    public static final Supplier<SoundEvent> DOOMHUNTER_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.doomhunter_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.doomhunter_death")));
    public static final Supplier<SoundEvent> DOOMHUNTER_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.doomhunter_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.doomhunter_hurt")));
    public static final Supplier<SoundEvent> DOOMHUNTER_PHASECHANGE = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, 
            "doom.doomhunter_phasechange",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.doomhunter_phasechange")));

    public static final Supplier<SoundEvent> MAKYR_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.maykr_ambient",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.maykr_ambient")));
    public static final Supplier<SoundEvent> MAKYR_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.maykr_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.maykr_death")));
    public static final Supplier<SoundEvent> MAKYR_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.maykr_hurt",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.maykr_hurt")));

    public static final Supplier<SoundEvent> MOTHER_AMBIENT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mother_ambient",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mother_ambient")));
    public static final Supplier<SoundEvent> MOTHER_DEATH = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mother_death",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mother_death")));
    public static final Supplier<SoundEvent> MOTHER_ATTACK = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mother_attack",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mother_attack")));
    public static final Supplier<SoundEvent> MOTHER_HURT = CommonSoundRegistryInterface.registerSound(MCDoom.MOD_ID, "doom.mother_pain",
            () -> SoundEvent.createVariableRangeEvent(MCDoom.modResource("doom.mother_pain")));

    public static void init() {
    }
}
