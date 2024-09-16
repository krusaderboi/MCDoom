package mod.azure.doom.registry;

import mod.azure.doom.MCDoom;
import mod.azure.doom.blocks.blockentities.BarrelEntity;
import mod.azure.doom.blocks.blockentities.GunBlockEntity;
import mod.azure.doom.blocks.blockentities.IconBlockEntity;
import mod.azure.doom.blocks.blockentities.TotemEntity;
import mod.azure.doom.entities.projectiles.*;
import mod.azure.doom.entities.projectiles.entity.*;
import mod.azure.doom.entities.tierambient.CueBallEntity;
import mod.azure.doom.entities.tierambient.GoreNestEntity;
import mod.azure.doom.entities.tierambient.TentacleEntity;
import mod.azure.doom.entities.tierambient.TurretEntity;
import mod.azure.doom.entities.tierboss.*;
import mod.azure.doom.entities.tierfodder.*;
import mod.azure.doom.entities.tierheavy.*;
import mod.azure.doom.entities.tiersuperheavy.*;
import mod.azure.doom.registry.interfaces.CommonBlockEntityRegistryInterface;
import mod.azure.doom.registry.interfaces.CommonEntityRegistryInterface;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class DoomMobs {
    public static final Supplier<EntityType<BarrelEntity>> BARREL = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "barrel",
            BarrelEntity::new, MobCategory.MISC, 0.98F, 0.98F);
    public static final Supplier<BlockEntityType<GunBlockEntity>> GUN_TABLE_ENTITY = CommonBlockEntityRegistryInterface.registerBlockEntity(
            MCDoom.MOD_ID,
            "guntable",
            () -> BlockEntityType.Builder.of(GunBlockEntity::new, DoomBlocks.GUN_TABLE.get()).build(null));
    /**
     * Projectiles
     */
    public static final Supplier<EntityType<MeatHookEntity>> MEATHOOOK_ENTITY = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "meathook", MeatHookEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<GrenadeEntity>> GRENADE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "doomed_grenade", GrenadeEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<BFGEntity>> BFG_CELL = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "bfg_cell", BFGEntity::new, MobCategory.MISC, 2.0F, 2.0F);
    public static final Supplier<EntityType<RocketEntity>> ROCKET = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "rocket", RocketEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<BulletEntity>> BULLETS = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "bullets", BulletEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<DoomFireEntity>> DOOMFIRE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "archvile_firing",
            DoomFireEntity::new, MobCategory.MISC, 0.5F, 0.8F);
    public static final Supplier<BlockEntityType<IconBlockEntity>> ICON_BLOCK = CommonBlockEntityRegistryInterface.registerBlockEntity(
            MCDoom.MOD_ID, "icon",
            () -> BlockEntityType.Builder.of(IconBlockEntity::new, DoomBlocks.ICON_WALL1.get()).build(null));
    public static final Supplier<EntityType<FireProjectile>> FIRE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "fire_projectile",
            FireProjectile::new, MobCategory.MISC, 0.5F, 0.8F);
    public static final Supplier<BlockEntityType<TotemEntity>> TOTEM_BLOCK = CommonBlockEntityRegistryInterface.registerBlockEntity(
            MCDoom.MOD_ID, "totem",
            () -> BlockEntityType.Builder.of(TotemEntity::new, DoomBlocks.TOTEM.get()).build(null));
    public static final Supplier<EntityType<DroneBoltEntity>> DRONEBOLT = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "dronebolt_mob",
            DroneBoltEntity::new, MobCategory.MISC, 0.5F, 0.8F);
    public static final Supplier<EntityType<BloodBoltEntity>> BLOODBOLT = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "bloodbolt_mob",
            BloodBoltEntity::new, MobCategory.MISC, 0.5F, 0.8F);
    public static final Supplier<EntityType<BarenBlastEntity>> BARENBLAST = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "barenblast",
            BarenBlastEntity::new, MobCategory.MISC, 1.0F, 1.0F);
    public static final Supplier<EntityType<GladiatorMaceEntity>> GLADIATORMACE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "gladiator_mace",
            GladiatorMaceEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<EnergyCellMobEntity>> ENGERYCELLMOB = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "energy_cell_mob",
            EnergyCellMobEntity::new, MobCategory.MISC, 0.5F, 0.8F);
    public static final Supplier<EntityType<RocketMobEntity>> ROCKETMOB = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "rocket_mob",
            RocketMobEntity::new, MobCategory.MISC, 0.5F, 0.8F);
    public static final Supplier<EntityType<ChaingunMobEntity>> CHAINGUN_MOB = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "chaingun_mob",
            ChaingunMobEntity::new, MobCategory.MISC, 0.5F, 0.8F);
    /**
     * Mobs
     */
    public static final Supplier<EntityType<LostSoulEntity>> LOST_SOUL = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "lost_soul",
            LostSoulEntity::new, MobCategory.MONSTER, 1.0F, 1.0F);
    public static final Supplier<EntityType<ImpEntity>> IMP = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "imp",
            ImpEntity::new, MobCategory.MONSTER, 0.6f, 1.95F);
    public static final Supplier<EntityType<PinkyEntity>> PINKY = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "pinky",
            PinkyEntity::new, MobCategory.MONSTER, 1.7f, 2.2F);
    public static final Supplier<EntityType<SpectreEntity>> SPECTRE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "spectre",
            SpectreEntity::new, MobCategory.MONSTER, 1.7f, 2.2F);
    public static final Supplier<EntityType<CacodemonEntity>> CACODEMON = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "cacodemon",
            CacodemonEntity::new, MobCategory.MONSTER, 2.0F, 2.0F);
    public static final Supplier<EntityType<ArchvileEntity>> ARCHVILE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "archvile",
            ArchvileEntity::new, MobCategory.MONSTER, 0.9F, 3.3F);
    public static final Supplier<EntityType<BaronEntity>> BARON = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "baron",
            BaronEntity::new, MobCategory.MONSTER, 1.3f, 3.9F);
    public static final Supplier<EntityType<MancubusEntity>> MANCUBUS = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "mancubus",
            MancubusEntity::new, MobCategory.MONSTER, 2.3F, 3.0F);
    public static final Supplier<EntityType<SpiderMastermindEntity>> SPIDERMASTERMIND = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "spidermastermind", SpiderMastermindEntity::new, MobCategory.MONSTER, 6.0F, 4.0F);
    public static final Supplier<EntityType<ArachnotronEntity>> ARACHNOTRON = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "arachnotron",
            ArachnotronEntity::new, MobCategory.MONSTER, 4.0F, 2.0F);
    public static final Supplier<EntityType<ZombiemanEntity>> ZOMBIEMAN = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "zombieman",
            ZombiemanEntity::new, MobCategory.MONSTER, 0.75f,
            2.1F);
    public static final Supplier<EntityType<RevenantEntity>> REVENANT = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "revenant",
            RevenantEntity::new, MobCategory.MONSTER, 1.9f,
            3.95F);
    public static final Supplier<EntityType<ImpStoneEntity>> IMP_STONE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "stone_imp",
            ImpStoneEntity::new, MobCategory.MONSTER, 0.6f,
            1.95F);
    public static final Supplier<EntityType<ChaingunnerEntity>> CHAINGUNNER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "chaingunner",
            ChaingunnerEntity::new, MobCategory.MONSTER, 0.75f,
            2.1F);
    public static final Supplier<EntityType<MarauderEntity>> MARAUDER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "marauder",
            MarauderEntity::new, MobCategory.MONSTER, 1.5f,
            2.6F);
    public static final Supplier<EntityType<ShotgunguyEntity>> SHOTGUNGUY = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "shotgunguy",
            ShotgunguyEntity::new, MobCategory.MONSTER, 0.75f,
            2.1F);
    public static final Supplier<EntityType<PainEntity>> PAIN = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "painelemental",
            PainEntity::new, MobCategory.MONSTER, 2.0F,
            2.0F);
    public static final Supplier<EntityType<HellknightEntity>> HELLKNIGHT = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "hellknight",
            HellknightEntity::new, MobCategory.MONSTER, 1.4F,
            3.5F);
    public static final Supplier<EntityType<Hellknight2016Entity>> HELLKNIGHT2016 = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "hellknight2016", Hellknight2016Entity::new, MobCategory.MONSTER, 1.8F,
            3.0F);
    public static final Supplier<EntityType<Hellknight2016Entity>> DREADKNIGHT = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "dreadknight", Hellknight2016Entity::new, MobCategory.MONSTER, 1.8F,
            3.0F);
    public static final Supplier<EntityType<CyberdemonEntity>> CYBERDEMON = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "cyberdemon",
            CyberdemonEntity::new, MobCategory.MONSTER, 3.0f,
            7.0F);
    public static final Supplier<EntityType<UnwillingEntity>> UNWILLING = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "unwilling",
            UnwillingEntity::new, MobCategory.MONSTER, 0.6f,
            1.95F);
    public static final Supplier<EntityType<PossessedSoldierEntity>> POSSESSEDSOLDIER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "possessed_soldier",
            PossessedSoldierEntity::new, MobCategory.MONSTER, 0.9f,
            2.35F);
    public static final Supplier<EntityType<GoreNestEntity>> GORE_NEST = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "gore_nest",
            GoreNestEntity::new, MobCategory.MONSTER, 3.0f,
            4.0F);
    public static final Supplier<EntityType<PossessedScientistEntity>> POSSESSEDSCIENTIST = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "possessed_scientist",
            PossessedScientistEntity::new, MobCategory.MONSTER, 1.5f,
            1.95F);
    public static final Supplier<EntityType<PossessedScientistEntity>> POSSESSEDWORKER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "possessed_worker",
            PossessedScientistEntity::new, MobCategory.MONSTER, 1.5f,
            1.95F);
    public static final Supplier<EntityType<CueBallEntity>> CUEBALL = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "cueball",
            CueBallEntity::new, MobCategory.MONSTER, 1.1F, 2.1F);
    public static final Supplier<EntityType<MechaZombieEntity>> MECHAZOMBIE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "mechazombie",
            MechaZombieEntity::new, MobCategory.MONSTER, 1.2f,
            2.3F);
    public static final Supplier<EntityType<ProwlerEntity>> PROWLER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "prowler",
            ProwlerEntity::new, MobCategory.MONSTER, 1.2f, 2.3F);
    public static final Supplier<EntityType<IconofsinEntity>> ICONOFSIN = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "iconofsin",
            IconofsinEntity::new, MobCategory.MONSTER, 6.3f,
            20.0F);
    public static final Supplier<EntityType<GargoyleEntity>> GARGOYLE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "gargoyle",
            GargoyleEntity::new, MobCategory.MONSTER, 1.3f,
            2.25F);
    public static final Supplier<EntityType<ArachnotronEntity>> ARACHNOTRONETERNAL = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "arachnotroneternal", ArachnotronEntity::new, MobCategory.MONSTER, 4.0F,
            3.0F);
    public static final Supplier<EntityType<DoomHunterEntity>> DOOMHUNTER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "doom_hunter",
            DoomHunterEntity::new, MobCategory.MONSTER, 3.0f,
            7.0F);
    public static final Supplier<EntityType<WhiplashEntity>> WHIPLASH = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "whiplash",
            WhiplashEntity::new, MobCategory.MONSTER, 1.7f,
            2.2F);
    public static final Supplier<EntityType<BaronEntity>> BARON2016 = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "baron2016",
            BaronEntity::new, MobCategory.MONSTER, 1.7f,
            4.2F);
    public static final Supplier<EntityType<FireBaronEntity>> FIREBARON = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "firebronebaron",
            FireBaronEntity::new, MobCategory.MONSTER, 1.7f,
            4.2F);
    public static final Supplier<EntityType<ArmoredBaronEntity>> ARMORBARON = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "armoredbaron", ArmoredBaronEntity::new, MobCategory.MONSTER, 1.7f,
            4.2F);
    public static final Supplier<EntityType<MaykrDroneEntity>> MAYKRDRONE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "maykr_drone",
            MaykrDroneEntity::new, MobCategory.MONSTER, 1.2f,
            2.7F);
    public static final Supplier<EntityType<SpiderMastermind2016Entity>> SPIDERMASTERMIND2016 = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "spidermastermind2016",
            SpiderMastermind2016Entity::new, MobCategory.MONSTER, 6.0F,
            4.0F);
    public static final Supplier<EntityType<BloodMaykrEntity>> BLOODMAYKR = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "blood_maykr",
            BloodMaykrEntity::new, MobCategory.MONSTER, 2.7f,
            5.5F);
    public static final Supplier<EntityType<MotherDemonEntity>> MOTHERDEMON = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "motherdemon",
            MotherDemonEntity::new, MobCategory.MONSTER, 6.3f,
            10.0F);
    public static final Supplier<EntityType<TentacleEntity>> TENTACLE = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "tentacle",
            TentacleEntity::new, MobCategory.MONSTER, 1.7f,
            2.2F);
    public static final Supplier<EntityType<TurretEntity>> TURRET = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "turret",
            TurretEntity::new, MobCategory.MONSTER, 1.7f,
            2.2F);
    public static final Supplier<EntityType<ArchMakyrEntity>> ARCHMAKER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "arch_maykr",
            ArchMakyrEntity::new, MobCategory.MONSTER, 4.7f,
            11.2F);
    public static final Supplier<EntityType<SummonerEntity>> SUMMONER = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "summoner",
            SummonerEntity::new, MobCategory.MONSTER, 0.9F,
            4.3F);
    public static final Supplier<EntityType<Revenant2016Entity>> REVENANT2016 = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "revenant2016", Revenant2016Entity::new, MobCategory.MONSTER, 1.9f,
            3.95F);
    public static final Supplier<EntityType<GladiatorEntity>> GLADIATOR = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "gladiator",
            GladiatorEntity::new, MobCategory.MONSTER, 1.7f,
            4.2F);
    public static final Supplier<EntityType<LostSoulEntity>> LOST_SOUL_ETERNAL = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID,
            "lost_soul_eternal",
            LostSoulEntity::new, MobCategory.MONSTER, 1.50F, 1.50F);
    public static final Supplier<EntityType<CarcassEntity>> CARCASS = CommonEntityRegistryInterface.registerEntity(
            MCDoom.MOD_ID, "carcass",
            CarcassEntity::new, MobCategory.MONSTER, 0.6f, 1.95F);

    public static void init() {
    }




}
