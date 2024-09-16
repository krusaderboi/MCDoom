package mod.azure.doom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.entities.tierambient.CueBallEntity;
import mod.azure.doom.entities.tierambient.GoreNestEntity;
import mod.azure.doom.entities.tierambient.TentacleEntity;
import mod.azure.doom.entities.tierambient.TurretEntity;
import mod.azure.doom.entities.tierboss.*;
import mod.azure.doom.entities.tierfodder.*;
import mod.azure.doom.entities.tierheavy.*;
import mod.azure.doom.entities.tiersuperheavy.*;
import mod.azure.doom.items.powerup.accessory.DaisyAccessory;
import mod.azure.doom.network.PacketHandler;
import mod.azure.doom.registry.DoomMobs;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@Mod(MCDoom.MOD_ID)
public final class NeoForgeMCDoomMod {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MCDoom.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MCDoom.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, MCDoom.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, MCDoom.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MCDoom.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MCDoom.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCDoom.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, MCDoom.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, MCDoom.MOD_ID);



    public NeoForgeMCDoomMod(IEventBus modEventBus) {
        MCDoom.init();
        AzureLib.initialize();
        ModEntitySpawn.SERIALIZER.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        SOUNDS.register(modEventBus);
        ENTITIES.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        PARTICLES.register(modEventBus);
        TABS.register(modEventBus);
        RECIPE_SERIALIZER.register(modEventBus);
        MENU_TYPES.register(modEventBus);
        AzureLib.hasKeyBindsInitialized = true;
        modEventBus.addListener(this::onInitialize);
        modEventBus.addListener(this::createEntityAttributes);
        modEventBus.addListener(this::createSpawnPlacements);
    }

    public void onInitialize(FMLCommonSetupEvent event){
        new PacketHandler().registerMessages();
        DaisyAccessory.init();
    }

    public void createSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(DoomMobs.GLADIATOR.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.ARCHVILE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.LOST_SOUL.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.LOST_SOUL_ETERNAL.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.ZOMBIEMAN.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.SPIDERMASTERMIND.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.ARACHNOTRON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.MANCUBUS.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.BARON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.REVENANT.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.IMP.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.PINKY.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.SPECTRE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.CACODEMON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.CHAINGUNNER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.MARAUDER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.SHOTGUNGUY.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.PAIN.get(), SpawnPlacementTypes.IN_LAVA,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.HELLKNIGHT.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.HELLKNIGHT2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.CYBERDEMON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.UNWILLING.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.POSSESSEDSCIENTIST.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.POSSESSEDSOLDIER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.ICONOFSIN.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.GORE_NEST.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.MECHAZOMBIE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.GARGOYLE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.CUEBALL.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.PROWLER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.DREADKNIGHT.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.IMP_STONE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.POSSESSEDWORKER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.DOOMHUNTER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.WHIPLASH.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.FIREBARON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.BARON2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.ARMORBARON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.ARACHNOTRONETERNAL.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.MAYKRDRONE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.SPIDERMASTERMIND2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.BLOODMAYKR.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.ARCHMAKER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.TENTACLE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.MOTHERDEMON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.TURRET.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.SUMMONER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.REVENANT2016.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(DoomMobs.CARCASS.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEntity::canSpawnInDark,
                RegisterSpawnPlacementsEvent.Operation.AND);
    }

    public void createEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(DoomMobs.GLADIATOR.get(), GladiatorEntity.createMobAttributes().build());
        event.put(DoomMobs.CYBERDEMON.get(), CyberdemonEntity.createMobAttributes().build());
        event.put(DoomMobs.ARCHVILE.get(), ArchvileEntity.createMobAttributes().build());
        event.put(DoomMobs.BARON.get(), BaronEntity.createMobAttributes().build());
        event.put(DoomMobs.CHAINGUNNER.get(), ChaingunnerEntity.createMobAttributes().build());
        event.put(DoomMobs.HELLKNIGHT.get(), HellknightEntity.createMobAttributes().build());
        event.put(DoomMobs.HELLKNIGHT2016.get(), Hellknight2016Entity.createMobAttributes().build());
        event.put(DoomMobs.ICONOFSIN.get(), IconofsinEntity.createMobAttributes().build());
        event.put(DoomMobs.IMP.get(), ImpEntity.createMobAttributes().build());
        event.put(DoomMobs.MANCUBUS.get(), MancubusEntity.createMobAttributes().build());
        event.put(DoomMobs.MARAUDER.get(), MarauderEntity.createMobAttributes().build());
        event.put(DoomMobs.PINKY.get(), PinkyEntity.createMobAttributes().build());
        event.put(DoomMobs.SPECTRE.get(), SpectreEntity.createMobAttributes().build());
        event.put(DoomMobs.LOST_SOUL.get(), LostSoulEntity.createMobAttributes().build());
        event.put(DoomMobs.LOST_SOUL_ETERNAL.get(), LostSoulEntity.createMobAttributes().build());
        event.put(DoomMobs.POSSESSEDSCIENTIST.get(), PossessedScientistEntity.createMobAttributes().build());
        event.put(DoomMobs.POSSESSEDSOLDIER.get(), PossessedSoldierEntity.createMobAttributes().build());
        event.put(DoomMobs.REVENANT.get(), RevenantEntity.createMobAttributes().build());
        event.put(DoomMobs.SHOTGUNGUY.get(), ShotgunguyEntity.createMobAttributes().build());
        event.put(DoomMobs.ARACHNOTRON.get(), ArachnotronEntity.createMobAttributes().build());
        event.put(DoomMobs.SPIDERMASTERMIND.get(), SpiderMastermindEntity.createMobAttributes().build());
        event.put(DoomMobs.UNWILLING.get(), UnwillingEntity.createMobAttributes().build());
        event.put(DoomMobs.ZOMBIEMAN.get(), ZombiemanEntity.createMobAttributes().build());
        event.put(DoomMobs.CACODEMON.get(), CacodemonEntity.createMobAttributes().build());
        event.put(DoomMobs.PAIN.get(), PainEntity.createMobAttributes().build());
        event.put(DoomMobs.GORE_NEST.get(), GoreNestEntity.createMobAttributes().build());
        event.put(DoomMobs.MECHAZOMBIE.get(), MechaZombieEntity.createMobAttributes().build());
        event.put(DoomMobs.GARGOYLE.get(), GargoyleEntity.createMobAttributes().build());
        event.put(DoomMobs.CUEBALL.get(), CueBallEntity.createMobAttributes().build());
        event.put(DoomMobs.PROWLER.get(), ProwlerEntity.createMobAttributes().build());
        event.put(DoomMobs.DREADKNIGHT.get(), Hellknight2016Entity.createMobAttributes().build());
        event.put(DoomMobs.IMP_STONE.get(), ImpStoneEntity.createMobAttributes().build());
        event.put(DoomMobs.POSSESSEDWORKER.get(), PossessedScientistEntity.createMobAttributes().build());
        event.put(DoomMobs.DOOMHUNTER.get(), DoomHunterEntity.createMobAttributes().build());
        event.put(DoomMobs.WHIPLASH.get(), WhiplashEntity.createMobAttributes().build());
        event.put(DoomMobs.BARON2016.get(), BaronEntity.createMobAttributes().build());
        event.put(DoomMobs.ARMORBARON.get(), ArmoredBaronEntity.createMobAttributes().build());
        event.put(DoomMobs.ARACHNOTRONETERNAL.get(), ArachnotronEntity.createMobAttributes().build());
        event.put(DoomMobs.MAYKRDRONE.get(), MaykrDroneEntity.createMobAttributes().build());
        event.put(DoomMobs.SPIDERMASTERMIND2016.get(), SpiderMastermindEntity.createMobAttributes().build());
        event.put(DoomMobs.BLOODMAYKR.get(), BloodMaykrEntity.createMobAttributes().build());
        event.put(DoomMobs.ARCHMAKER.get(), ArchMakyrEntity.createMobAttributes().build());
        event.put(DoomMobs.FIREBARON.get(), FireBaronEntity.createMobAttributes().build());
        event.put(DoomMobs.TENTACLE.get(), TentacleEntity.createMobAttributes().build());
        event.put(DoomMobs.MOTHERDEMON.get(), MotherDemonEntity.createMobAttributes().build());
        event.put(DoomMobs.TURRET.get(), TurretEntity.createMobAttributes().build());
        event.put(DoomMobs.SUMMONER.get(), SummonerEntity.createMobAttributes().build());
        event.put(DoomMobs.REVENANT2016.get(), Revenant2016Entity.createMobAttributes().build());
        event.put(DoomMobs.CARCASS.get(), CarcassEntity.createMobAttributes().build());
    }

    record ModEntitySpawn(HolderSet<Biome> biomes, MobSpawnSettings.SpawnerData spawn) implements BiomeModifier {

        public static DeferredRegister<MapCodec<? extends BiomeModifier>> SERIALIZER = DeferredRegister.create(
                NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MCDoom.MOD_ID);

        static Supplier<MapCodec<ModEntitySpawn>> DOOM_SPAWN_CODEC = SERIALIZER.register("mobspawns",
                () -> RecordCodecBuilder.mapCodec(
                        builder -> builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(
                                        ModEntitySpawn::biomes),
                                MobSpawnSettings.SpawnerData.CODEC.fieldOf("spawn").forGetter(
                                        ModEntitySpawn::spawn)).apply(builder, ModEntitySpawn::new)));

        @Override
        public void modify(@NotNull Holder<Biome> biome, @NotNull Phase phase, ModifiableBiomeInfo.BiomeInfo.@NotNull Builder builder) {
            if (phase == Phase.ADD && biomes.contains(biome)) {
                builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, spawn);
            }
        }

        @Override
        public @NotNull MapCodec<? extends BiomeModifier> codec() {
            return DOOM_SPAWN_CODEC.get();
        }
    }
}
