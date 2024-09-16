package mod.azure.doom.helper;

import mod.azure.doom.MCDoom;
import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.registry.DoomTags;
import mod.azure.doom.registry.DoomMobs;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public record MobSpawn() {

    public static void addSpawnEntries() {
        // The End
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.ARCHMAYKR_BIOMES), MobCategory.MONSTER,
                DoomMobs.ARCHMAKER.get(), MCDoom.config.archmaykr_spawn_weight, MCDoom.config.archmaykr_min_group,
                MCDoom.config.archmaykr_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.MAYKREDRONE_BIOMES), MobCategory.MONSTER,
                DoomMobs.MAYKRDRONE.get(), MCDoom.config.maykrdrone_spawn_weight,
                MCDoom.config.maykrdrone_min_group, MCDoom.config.maykrdrone_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.BLOODMAYKR_BIOMES), MobCategory.MONSTER,
                DoomMobs.BLOODMAYKR.get(), MCDoom.config.bloodmaykr_spawn_weight,
                MCDoom.config.bloodmaykr_min_group, MCDoom.config.bloodmaykr_max_group);
        // The Nether
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.GLADIATOR_BIOMES), MobCategory.MONSTER,
                DoomMobs.GLADIATOR.get(), MCDoom.config.gladiator_spawn_weight, MCDoom.config.gladiator_min_group,
                MCDoom.config.gladiator_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.MOTHERDEMON_BIOMES), MobCategory.MONSTER,
                DoomMobs.MOTHERDEMON.get(), MCDoom.config.motherdemon_spawn_weight,
                MCDoom.config.motherdemon_min_group, MCDoom.config.motherdemon_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.IMP_BIOMES), MobCategory.MONSTER,
                DoomMobs.IMP.get(), MCDoom.config.imp_spawn_weight, MCDoom.config.imp_min_group,
                MCDoom.config.imp_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.IMPSTONE_BIOMES), MobCategory.MONSTER,
                DoomMobs.IMP_STONE.get(), MCDoom.config.impstone_spawn_weight, MCDoom.config.impstone_min_group,
                MCDoom.config.impstone_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.PINKY_BIOMES), MobCategory.MONSTER,
                DoomMobs.PINKY.get(), MCDoom.config.pinky_spawn_weight, MCDoom.config.pinky_min_group,
                MCDoom.config.pinky_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.SPECTRE_BIOMES), MobCategory.MONSTER,
                DoomMobs.SPECTRE.get(), MCDoom.config.spectre_spawn_weight, MCDoom.config.spectre_min_group,
                MCDoom.config.spectre_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.LOST_SOUL_BIOMES), MobCategory.MONSTER,
                DoomMobs.LOST_SOUL.get(), MCDoom.config.lost_soul_spawn_weight, MCDoom.config.lost_soul_min_group,
                MCDoom.config.lost_soul_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.LOST_SOUL_BIOMES), MobCategory.MONSTER,
                DoomMobs.LOST_SOUL_ETERNAL.get(), MCDoom.config.lost_soul_spawn_weight,
                MCDoom.config.lost_soul_min_group, MCDoom.config.lost_soul_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.CACODEMON_BIOMES), MobCategory.MONSTER,
                DoomMobs.CACODEMON.get(), MCDoom.config.cacodemon_spawn_weight, MCDoom.config.cacodemon_min_group,
                MCDoom.config.cacodemon_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.ARCHVILE_BIOMES), MobCategory.MONSTER,
                DoomMobs.ARCHVILE.get(), MCDoom.config.archvile_spawn_weight, MCDoom.config.archvile_min_group,
                MCDoom.config.archvile_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.BARON_BIOMES), MobCategory.MONSTER,
                DoomMobs.BARON.get(), MCDoom.config.baron_spawn_weight, MCDoom.config.baron_min_group,
                MCDoom.config.baron_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.MANCUBUS_BIOMES), MobCategory.MONSTER,
                DoomMobs.MANCUBUS.get(), MCDoom.config.mancubus_spawn_weight, MCDoom.config.mancubus_min_group,
                MCDoom.config.mancubus_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.REVENANT_BIOMES), MobCategory.MONSTER,
                DoomMobs.REVENANT.get(), MCDoom.config.revenant_spawn_weight, MCDoom.config.revenant_min_group,
                MCDoom.config.revenant_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.REVENANT_BIOMES), MobCategory.MONSTER,
                DoomMobs.REVENANT2016.get(), MCDoom.config.revenant_spawn_weight, MCDoom.config.revenant_min_group,
                MCDoom.config.revenant_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.SPIDER_MASTERMIND_BIOMES), MobCategory.MONSTER,
                DoomMobs.SPIDERMASTERMIND.get(), MCDoom.config.spider_mastermind_spawn_weight,
                MCDoom.config.spider_mastermind_min_group, MCDoom.config.spider_mastermind_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.ZOMBIEMAN_BIOMES), MobCategory.MONSTER,
                DoomMobs.ZOMBIEMAN.get(), MCDoom.config.zombieman_spawn_weight, MCDoom.config.zombieman_min_group,
                MCDoom.config.zombieman_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.ARCHNOTRON_BIOMES), MobCategory.MONSTER,
                DoomMobs.ARACHNOTRON.get(), MCDoom.config.arachnotron_spawn_weight,
                MCDoom.config.arachnotron_min_group, MCDoom.config.arachnotron_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.ARCHNOTRON_BIOMES), MobCategory.MONSTER,
                DoomMobs.ARACHNOTRONETERNAL.get(), MCDoom.config.arachnotron_spawn_weight,
                MCDoom.config.arachnotron_min_group, MCDoom.config.arachnotron_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.GARGOYLE_BIOMES), MobCategory.MONSTER,
                DoomMobs.GARGOYLE.get(), MCDoom.config.gargoyle_spawn_weight, MCDoom.config.gargoyle_min_group,
                MCDoom.config.gargoyle_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.CHAINGUNNER_BIOMES), MobCategory.MONSTER,
                DoomMobs.CHAINGUNNER.get(), MCDoom.config.chaingunner_spawn_weight,
                MCDoom.config.chaingunner_min_group, MCDoom.config.chaingunner_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.SHOTGUNGUY_BIOMES), MobCategory.MONSTER,
                DoomMobs.SHOTGUNGUY.get(), MCDoom.config.shotgunguy_spawn_weight,
                MCDoom.config.shotgunguy_min_group, MCDoom.config.shotgunguy_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.MARAUDER_BIOMES), MobCategory.MONSTER,
                DoomMobs.MARAUDER.get(), MCDoom.config.marauder_spawn_weight, MCDoom.config.marauder_min_group,
                MCDoom.config.marauder_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.PAIN_BIOMES), MobCategory.MONSTER,
                DoomMobs.PAIN.get(), MCDoom.config.pain_spawn_weight, MCDoom.config.pain_min_group,
                MCDoom.config.pain_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.HELLKNIGHT_BIOMES), MobCategory.MONSTER,
                DoomMobs.HELLKNIGHT.get(), MCDoom.config.hellknight_spawn_weight,
                MCDoom.config.hellknight_min_group, MCDoom.config.hellknight_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.HELLKNIGHT2016_BIOMES), MobCategory.MONSTER,
                DoomMobs.HELLKNIGHT2016.get(), MCDoom.config.hellknight2016_spawn_weight,
                MCDoom.config.hellknight2016_min_group, MCDoom.config.hellknight2016_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.HELLKNIGHT2016_BIOMES), MobCategory.MONSTER,
                DoomMobs.DREADKNIGHT.get(), MCDoom.config.hellknight2016_spawn_weight,
                MCDoom.config.hellknight2016_min_group, MCDoom.config.hellknight2016_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.CYBERDEMON_BIOMES), MobCategory.MONSTER,
                DoomMobs.CYBERDEMON.get(), MCDoom.config.cyberdemon_spawn_weight,
                MCDoom.config.cyberdemon_min_group, MCDoom.config.cyberdemon_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.UNWILLING_BIOMES), MobCategory.MONSTER,
                DoomMobs.UNWILLING.get(), MCDoom.config.unwilling_spawn_weight, MCDoom.config.unwilling_min_group,
                MCDoom.config.unwilling_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.POSSESSED_SCIENTIST_BIOMES), MobCategory.MONSTER,
                DoomMobs.POSSESSEDSCIENTIST.get(), MCDoom.config.possessed_scientist_spawn_weight,
                MCDoom.config.possessed_scientist_min_group, MCDoom.config.possessed_scientist_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.POSSESSED_SOLDIER_BIOMES), MobCategory.MONSTER,
                DoomMobs.POSSESSEDSOLDIER.get(), MCDoom.config.possessed_soldier_spawn_weight,
                MCDoom.config.possessed_soldier_min_group, MCDoom.config.possessed_soldier_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.MECHAZOMBIE_BIOMES), MobCategory.MONSTER,
                DoomMobs.MECHAZOMBIE.get(), MCDoom.config.mechazombie_spawn_weight,
                MCDoom.config.mechazombie_min_group, MCDoom.config.mechazombie_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.CUEBALL_BIOMES), MobCategory.MONSTER,
                DoomMobs.CUEBALL.get(), MCDoom.config.cueball_spawn_weight, MCDoom.config.cueball_min_group,
                MCDoom.config.cueball_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.PROWLER_BIOMES), MobCategory.MONSTER,
                DoomMobs.PROWLER.get(), MCDoom.config.prowler_spawn_weight, MCDoom.config.prowler_min_group,
                MCDoom.config.prowler_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.GORENEST_BIOMES), MobCategory.MONSTER,
                DoomMobs.GORE_NEST.get(), MCDoom.config.gorenest_spawn_weight, MCDoom.config.gorenest_min_group,
                MCDoom.config.gorenest_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.POSSESSED_WORKER_BIOMES), MobCategory.MONSTER,
                DoomMobs.POSSESSEDWORKER.get(), MCDoom.config.possessed_worker_spawn_weight,
                MCDoom.config.possessed_worker_min_group, MCDoom.config.possessed_worker_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.SPIDER_MASTERMIND_BIOMES), MobCategory.MONSTER,
                DoomMobs.SPIDERMASTERMIND2016.get(), MCDoom.config.spider_mastermind_spawn_weight,
                MCDoom.config.spider_mastermind_min_group, MCDoom.config.spider_mastermind_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.DOOMHUNTER_BIOMES), MobCategory.MONSTER,
                DoomMobs.DOOMHUNTER.get(), MCDoom.config.doomhunter_spawn_weight,
                MCDoom.config.doomhunter_min_group, MCDoom.config.doomhunter_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.TENTACLE_BIOMES), MobCategory.MONSTER,
                DoomMobs.TENTACLE.get(), MCDoom.config.tentacle_spawn_weight, MCDoom.config.tentacle_min_group,
                MCDoom.config.tentacle_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.SUMMONER_BIOMES), MobCategory.MONSTER,
                DoomMobs.SUMMONER.get(), MCDoom.config.summoner_spawn_weight, MCDoom.config.summoner_min_group,
                MCDoom.config.summoner_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.WHIPLASH_BIOMES), MobCategory.MONSTER,
                DoomMobs.WHIPLASH.get(), MCDoom.config.whiplash_spawn_weight, MCDoom.config.whiplash_min_group,
                MCDoom.config.whiplash_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.BARON_BIOMES), MobCategory.MONSTER,
                DoomMobs.BARON2016.get(), MCDoom.config.baron_spawn_weight, MCDoom.config.baron_min_group,
                MCDoom.config.baron_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.BARON_BIOMES), MobCategory.MONSTER,
                DoomMobs.FIREBARON.get(), MCDoom.config.baron_spawn_weight, MCDoom.config.baron_min_group,
                MCDoom.config.baron_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.ARMOREDBARON_BIOMES), MobCategory.MONSTER,
                DoomMobs.ARMORBARON.get(), MCDoom.config.armoredbaron_spawn_weight,
                MCDoom.config.armoredbaron_min_group, MCDoom.config.armoredbaron_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.TURRET_BIOMES), MobCategory.MONSTER,
                DoomMobs.TURRET.get(), MCDoom.config.turret_spawn_weight, MCDoom.config.turret_min_group,
                MCDoom.config.turret_max_group);
        BiomeModifications.addSpawn(BiomeSelectors.tag(DoomTags.CARCASS_BIOMES), MobCategory.MONSTER,
                DoomMobs.CARCASS.get(), MCDoom.config.carcass_spawn_weight, MCDoom.config.carcass_min_group,
                MCDoom.config.carcass_max_group);
        SpawnPlacements.register(DoomMobs.CARCASS.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.GLADIATOR.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.ARCHVILE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.ZOMBIEMAN.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.SPIDERMASTERMIND.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.ARACHNOTRON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.MANCUBUS.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.BARON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.REVENANT.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.IMP.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.PINKY.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.SPECTRE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.CACODEMON.get(), SpawnPlacementTypes.IN_LAVA,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.LOST_SOUL.get(), SpawnPlacementTypes.IN_LAVA,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.LOST_SOUL_ETERNAL.get(), SpawnPlacementTypes.IN_LAVA,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.CHAINGUNNER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.MARAUDER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.SHOTGUNGUY.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.PAIN.get(), SpawnPlacementTypes.IN_LAVA,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.HELLKNIGHT.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.HELLKNIGHT2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.CYBERDEMON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.UNWILLING.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.POSSESSEDSCIENTIST.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.POSSESSEDSOLDIER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.ICONOFSIN.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.MECHAZOMBIE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.GORE_NEST.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.GARGOYLE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.CUEBALL.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.PROWLER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.DREADKNIGHT.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.IMP_STONE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.POSSESSEDWORKER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.DOOMHUNTER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.WHIPLASH.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.FIREBARON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.BARON2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.ARMORBARON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.ARACHNOTRONETERNAL.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.MAYKRDRONE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.SPIDERMASTERMIND2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.BLOODMAYKR.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.ARCHMAKER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.TENTACLE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.MOTHERDEMON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.TURRET.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.SUMMONER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
        SpawnPlacements.register(DoomMobs.REVENANT2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark);
    }
}