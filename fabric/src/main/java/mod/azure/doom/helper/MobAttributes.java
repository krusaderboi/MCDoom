package mod.azure.doom.helper;

import mod.azure.doom.entities.tierambient.CueBallEntity;
import mod.azure.doom.entities.tierambient.GoreNestEntity;
import mod.azure.doom.entities.tierambient.TentacleEntity;
import mod.azure.doom.entities.tierambient.TurretEntity;
import mod.azure.doom.entities.tierboss.*;
import mod.azure.doom.entities.tierfodder.*;
import mod.azure.doom.entities.tierheavy.*;
import mod.azure.doom.entities.tiersuperheavy.*;
import mod.azure.doom.registry.DoomMobs;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public record MobAttributes() {

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(DoomMobs.GLADIATOR.get(), GladiatorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.ARCHVILE.get(), ArchvileEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.BARON.get(), BaronEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.CACODEMON.get(), CacodemonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.CHAINGUNNER.get(), ChaingunnerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.CYBERDEMON.get(), CyberdemonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.HELLKNIGHT.get(), HellknightEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.HELLKNIGHT2016.get(), Hellknight2016Entity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.ICONOFSIN.get(), IconofsinEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.IMP.get(), ImpEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.IMP_STONE.get(), ImpStoneEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.ARACHNOTRON.get(), ArachnotronEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.LOST_SOUL.get(), LostSoulEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.LOST_SOUL_ETERNAL.get(), LostSoulEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.MANCUBUS.get(), MancubusEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.MARAUDER.get(), MarauderEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.PAIN.get(), PainEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.PINKY.get(), PinkyEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.SPECTRE.get(), SpectreEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.POSSESSEDSCIENTIST.get(), PossessedScientistEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.POSSESSEDSOLDIER.get(), PossessedSoldierEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.MECHAZOMBIE.get(), MechaZombieEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.REVENANT.get(), RevenantEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.SHOTGUNGUY.get(), ShotgunguyEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.SPIDERMASTERMIND.get(), SpiderMastermindEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.UNWILLING.get(), UnwillingEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.ZOMBIEMAN.get(), ZombiemanEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.GORE_NEST.get(), GoreNestEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.GARGOYLE.get(), GargoyleEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.CUEBALL.get(), CueBallEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.PROWLER.get(), ProwlerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.DREADKNIGHT.get(), Hellknight2016Entity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.POSSESSEDWORKER.get(), PossessedScientistEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.DOOMHUNTER.get(), DoomHunterEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.WHIPLASH.get(), WhiplashEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.BARON2016.get(), BaronEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.ARMORBARON.get(), ArmoredBaronEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.ARACHNOTRONETERNAL.get(), ArachnotronEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.MAYKRDRONE.get(), MaykrDroneEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.SPIDERMASTERMIND2016.get(), SpiderMastermindEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.BLOODMAYKR.get(), BloodMaykrEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.ARCHMAKER.get(), ArchMakyrEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.FIREBARON.get(), FireBaronEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.TENTACLE.get(), TentacleEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.MOTHERDEMON.get(), MotherDemonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.TURRET.get(), TurretEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.SUMMONER.get(), SummonerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.REVENANT2016.get(), Revenant2016Entity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DoomMobs.CARCASS.get(), CarcassEntity.createMobAttributes());
    }
}