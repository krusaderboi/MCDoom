package mod.azure.doom.registry;

import mod.azure.doom.MCDoom;
import mod.azure.doom.items.UnopenedItem;
import mod.azure.doom.items.ammo.AmmoItem;
import mod.azure.doom.items.argent.ArgentEnergyItem;
import mod.azure.doom.items.argent.ArgentPlateItem;
import mod.azure.doom.items.armor.DoomArmor;
import mod.azure.doom.items.blockitems.DoomBlockItem;
import mod.azure.doom.items.enums.AmmoEnum;
import mod.azure.doom.items.enums.ArmorTypeEnum;
import mod.azure.doom.items.enums.GunTypeEnum;
import mod.azure.doom.items.enums.MeleeWeaponEnum;
import mod.azure.doom.items.powerup.*;
import mod.azure.doom.items.tools.*;
import mod.azure.doom.items.weapons.ArgentSword;
import mod.azure.doom.items.weapons.BaseSwordItem;
import mod.azure.doom.items.weapons.DoomBaseItem;
import mod.azure.doom.items.weapons.GrenadeItem;
import mod.azure.doom.platform.Services;
import mod.azure.doom.registry.interfaces.CommonItemRegistryInterface;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

public class DoomItems {
    //Power Ups
    public static final Supplier<Item> DAISY = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"daisy", DaisyItem::new);
    public static final Supplier<Item> INMORTAL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"inmortalsphere", InmortalSphereItem::new);
    public static final Supplier<Item> INVISIBLE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"invisiblesphere", InvisibleSphereItem::new);
    public static final Supplier<Item> MEGA = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"megasphere", MegaSphereItem::new);
    public static final Supplier<Item> POWER = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"powersphere", PowerSphereItem::new);
    public static final Supplier<Item> SOULCUBE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"soulcube", SoulCubeItem::new);
    // BLOCKS
    public static final Supplier<Item> GUN_TABLE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID, "gun_table",
            () -> new DoomBlockItem(DoomBlocks.GUN_TABLE.get(), new Item.Properties(), "gun_table") {
            });
    public static final Supplier<Item> TOTEM = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"totem",
            () -> new DoomBlockItem(DoomBlocks.TOTEM.get(), new Item.Properties(), "totem") {
            });
    public static final Supplier<Item> ITEM = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"barrel",
            () -> new BlockItem(DoomBlocks.BARREL_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> ARGENT_BLOCK = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_block",
            () -> new BlockItem(DoomBlocks.ARGENT_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> ARGENT_LAMP_BLOCK = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_lamp_block",
            () -> new BlockItem(DoomBlocks.ARGENT_LAMP_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> DOOM_SAND = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doom_sand",
            () -> new BlockItem(DoomBlocks.DOOM_SAND.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL1 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall1",
            () -> new BlockItem(DoomBlocks.ICON_WALL1.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL2 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall2",
            () -> new BlockItem(DoomBlocks.ICON_WALL2.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL3 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall3",
            () -> new BlockItem(DoomBlocks.ICON_WALL3.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL4 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall4",
            () -> new BlockItem(DoomBlocks.ICON_WALL4.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL5 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall5",
            () -> new BlockItem(DoomBlocks.ICON_WALL5.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL6 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall6",
            () -> new BlockItem(DoomBlocks.ICON_WALL6.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL7 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall7",
            () -> new BlockItem(DoomBlocks.ICON_WALL7.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL8 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall8",
            () -> new BlockItem(DoomBlocks.ICON_WALL8.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL9 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall9",
            () -> new BlockItem(DoomBlocks.ICON_WALL9.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL10 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall10",
            () -> new BlockItem(DoomBlocks.ICON_WALL10.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL11 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall11",
            () -> new BlockItem(DoomBlocks.ICON_WALL11.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL12 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall12",
            () -> new BlockItem(DoomBlocks.ICON_WALL12.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL13 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall13",
            () -> new BlockItem(DoomBlocks.ICON_WALL13.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL14 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall14",
            () -> new BlockItem(DoomBlocks.ICON_WALL14.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL15 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall15",
            () -> new BlockItem(DoomBlocks.ICON_WALL15.get(), new Item.Properties()));
    public static final Supplier<Item> ICON_WALL16 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_wall16",
            () -> new BlockItem(DoomBlocks.ICON_WALL16.get(), new Item.Properties()));

    public static final Supplier<Item> E1M1_1 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block1",
            () -> new BlockItem(DoomBlocks.E1M1_1.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_2 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block2",
            () -> new BlockItem(DoomBlocks.E1M1_2.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_3 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block3",
            () -> new BlockItem(DoomBlocks.E1M1_3.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_4 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block4",
            () -> new BlockItem(DoomBlocks.E1M1_4.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_5 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block5",
            () -> new BlockItem(DoomBlocks.E1M1_5.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_6 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block6",
            () -> new BlockItem(DoomBlocks.E1M1_6.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_7 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block7",
            () -> new BlockItem(DoomBlocks.E1M1_7.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_8 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block8",
            () -> new BlockItem(DoomBlocks.E1M1_8.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_9 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block9",
            () -> new BlockItem(DoomBlocks.E1M1_9.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_10 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block10",
            () -> new BlockItem(DoomBlocks.E1M1_10.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_11 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block11",
            () -> new BlockItem(DoomBlocks.E1M1_11.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_12 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block12",
            () -> new BlockItem(DoomBlocks.E1M1_12.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_13 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block13",
            () -> new BlockItem(DoomBlocks.E1M1_13.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_14 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block14",
            () -> new BlockItem(DoomBlocks.E1M1_14.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_15 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block15",
            () -> new BlockItem(DoomBlocks.E1M1_15.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_16 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block16",
            () -> new BlockItem(DoomBlocks.E1M1_16.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_17 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block17",
            () -> new BlockItem(DoomBlocks.E1M1_17.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_18 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block18",
            () -> new BlockItem(DoomBlocks.E1M1_18.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_19 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block19",
            () -> new BlockItem(DoomBlocks.E1M1_19.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_20 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block20",
            () -> new BlockItem(DoomBlocks.E1M1_20.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_21 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block21",
            () -> new BlockItem(DoomBlocks.E1M1_21.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_22 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block22",
            () -> new BlockItem(DoomBlocks.E1M1_22.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_23 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block23",
            () -> new BlockItem(DoomBlocks.E1M1_23.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_24 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block24",
            () -> new BlockItem(DoomBlocks.E1M1_24.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_25 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block25", () -> new BlockItem(DoomBlocks.E1M1_25.get(), new Item.Properties()));
    public static final Supplier<Item> E1M1_26 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"e1m1_block26", () -> new BlockItem(DoomBlocks.E1M1_26.get(), new Item.Properties()));
    public static final Supplier<Item> JUMP_PAD = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"jump_pad", () -> new BlockItem(DoomBlocks.JUMP_PAD.get(), new Item.Properties()));
    // AMMO
    public static final Supplier<Item> SHOTGUN_SHELLS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"shotgun_shells", () -> new AmmoItem(AmmoEnum.SHELL));
    public static final Supplier<Item> ARGENT_BOLT = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_bolt", () -> new AmmoItem(AmmoEnum.ARGENT_BOLT));
    public static final Supplier<Item> UNMAKRY_BOLT = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"unmaykr_bolt", () -> new AmmoItem(AmmoEnum.UNMAYKR_BOLT));
    public static final Supplier<Item> ENERGY_CELLS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"energy_cells", () -> new AmmoItem(AmmoEnum.ENGERY));
    public static final Supplier<Item> CHAINGUN_BULLETS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"chaingunbullets", () -> new AmmoItem(AmmoEnum.CHAINGUN));
    public static final Supplier<Item> BULLETS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bullets", () -> new AmmoItem(AmmoEnum.CLIP));
    public static final Supplier<Item> BFG_CELL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bfg_cell", () -> new AmmoItem(AmmoEnum.BFG_CELL));
    public static final Supplier<Item> ROCKET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"rocket", () -> new AmmoItem(AmmoEnum.ROCKET));
    public static final Supplier<Item> GAS_BARREL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gas_barrel", () -> new Item(new Item.Properties()));
    // MISC
    public static final Supplier<Item> ICON_ICON = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_icon", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ARGENT_ENERGY = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_energy", ArgentEnergyItem::new);
    public static final Supplier<Item> ARGENT_PLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_plate", ArgentPlateItem::new);
    // SPAWNEGGS
    public static final Supplier<SpawnEggItem> IMP_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"imp_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.IMP, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> ARACHNOTRON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"arachnotron_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.ARACHNOTRON, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> LOST_SOUL_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"lost_soul_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.LOST_SOUL, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> LOST_SOUL_ETERNAL_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"lost_soul_eternal_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.LOST_SOUL_ETERNAL, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> PINKY_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"pinky_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.PINKY, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> ARCHVILE_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"archvile_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.ARCHVILE, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> BARON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"baron_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.BARON, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> CACODEMON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cacodemon_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.CACODEMON, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> MANCUBUS_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"mancubus_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.MANCUBUS, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> SPIDERMASTERMIND_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"spidermastermind_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.SPIDERMASTERMIND, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> ZOMBIEMAN_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"zombieman_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.ZOMBIEMAN, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> CHAINGUNNER_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"chaingunner_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.CHAINGUNNER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> HELLKNIGHT_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"hellknight_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.HELLKNIGHT, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> MARAUDER_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"marauder_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.MARAUDER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> PAIN_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"pain_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.PAIN, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> REVENANT_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"revenant_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.REVENANT, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> SHOTGUNGUY_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"shotgunguy_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.SHOTGUNGUY, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> CYBERDEMON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cyberdemon_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.CYBERDEMON, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> ICON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"icon_of_sin_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.ICONOFSIN, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> UNWILLING_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"unwilling_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.UNWILLING, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> MECH_ZOMBIE_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"mechazombie_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.MECHAZOMBIE, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> GORE_NEST_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gorenest_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.GORE_NEST, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> POSSESSED_SCIENTIST_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,
            "possessed_scientist_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.POSSESSEDSCIENTIST, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> POSSESSED_SOLDIER_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"possessed_soldier_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.POSSESSEDSOLDIER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> HELLKNIGHT2016_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"hellknight2016_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.HELLKNIGHT2016, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> GARGOYLE_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gargoyle_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.GARGOYLE, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> SPECTRE_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"spectre_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.SPECTRE, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> CUEBALL_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cueball_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.CUEBALL, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> PROWLER_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"prowler_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.PROWLER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> DREADKNIGHT_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"dreadknight_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.DREADKNIGHT, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> STONEIMP_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"stoneimp_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.IMP_STONE, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> POSSESSED_WORKER_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"possessed_worker_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.POSSESSEDWORKER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> DOOMHUNTER_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doom_hunter_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.DOOMHUNTER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> WHIPLASH_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"whiplash_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.WHIPLASH, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> BARON2016_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"baron2016_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.BARON2016, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> FIREBORNE_BARON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"firebronebaron_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.FIREBARON, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> ARMORED_BARON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"armoredbaron_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.ARMORBARON, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> MAYKR_DRONE_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"maykr_drone_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.MAYKRDRONE, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> BLOOD_MAYKR_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"blood_maykr_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.BLOODMAYKR, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> ARCH_MAKYR_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"arch_maykr_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.ARCHMAKER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> ARACHNOTRONETERNAL_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,
            "arachnotroneternal_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.ARACHNOTRONETERNAL, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> SPIDERMASTERMIND2016_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,
            "spidermastermind2016_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.SPIDERMASTERMIND2016, 11022961, 11035249,
                    new Item.Properties()));
    public static final Supplier<SpawnEggItem> TENTACLE_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"tentacle_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.TENTACLE, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> MOTHERDEMON_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"motherdemon_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.MOTHERDEMON, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> TURRET_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"turret_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.TURRET, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> SUMMONER_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"summoner_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.SUMMONER, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> REVENANT2016_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"revenant2016_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.REVENANT2016, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> GLADIATOR_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gladiator_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.GLADIATOR, 11022961, 11035249, new Item.Properties()));
    public static final Supplier<SpawnEggItem> CARCASS_SPAWN_EGG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"carcass_spawn_egg",
            Services.COMMON_REGISTRY.makeSpawnEggFor(DoomMobs.CARCASS, 0xe4c7be, 0x5a575a, new Item.Properties()));
    // WEAPONS AND TOOLS
    public static final Supplier<Item> ARGENT_AXE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_axe",
            () -> new ArgentAxe());
    public static final Supplier<Item> ARGENT_HOE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_hoe",
            () -> new ArgentHoe());
    public static final Supplier<Item> ARGENT_PAXEL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_paxel",
            () -> new ArgentPaxel());
    public static final Supplier<Item> ARGENT_PICKAXE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_pickaxe",
            () -> new ArgentPickaxe());
    public static final Supplier<Item> ARGENT_SHOVEL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_shovel",
            () -> new ArgentShovel());
    public static final Supplier<Item> ARGENT_SWORD = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"argent_sword",
            () -> new ArgentSword());
    public static final Supplier<Item> SWORD_CLOSED = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cruciblesword_closed", UnopenedItem::new);
    public static final Supplier<Item> AXE_CLOSED = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"axe_marauder_closed", UnopenedItem::new);
    public static final Supplier<Item> SG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"shotgun",
            () -> new DoomBaseItem(GunTypeEnum.SHOTGUN, 50) {
            });
    public static final Supplier<Item> BFG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bfg9000",
            () -> new DoomBaseItem(GunTypeEnum.BFG9000, 400) {
            });
    public static final Supplier<Item> PISTOL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"pistol",
            () -> new DoomBaseItem(GunTypeEnum.PISTOL, 200) {
            });
    public static final Supplier<Item> BFG_ETERNAL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bfg_eternal",
            () -> new DoomBaseItem(GunTypeEnum.BFG, 400) {
            });
    public static final Supplier<Item> DGAUSS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomed_gauss",
            () -> new DoomBaseItem(GunTypeEnum.DGAUSS, 10) {
            });
    public static final Supplier<Item> BALLISTA = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"ballista",
            () -> new DoomBaseItem(GunTypeEnum.BALLISTA, 10) {
            });
    public static final Supplier<Item> CHAINGUN = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"chaingun",
            () -> new DoomBaseItem(GunTypeEnum.CHAINGUN, 200) {
            });
    public static final Supplier<Item> UNMAYKR = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"unmaykr",
            () -> new DoomBaseItem(GunTypeEnum.UNMAYKR, 9000) {
            });
    public static final Supplier<Item> UNMAKER = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"unmaker",
            () -> new DoomBaseItem(GunTypeEnum.UNMAKER, 9000) {
            });
    public static final Supplier<Item> DSG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomed_shotgun",
            () -> new DoomBaseItem(GunTypeEnum.DSHOTGUN, 50) {
            });
    public static final Supplier<Item> PLASMAGUN = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"plasmagun",
            () -> new DoomBaseItem(GunTypeEnum.PLAMSA, 400) {
            });
    public static final Supplier<Item> SSG = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"supershotgun",
            () -> new DoomBaseItem(GunTypeEnum.SUPERSHOTGUN, 52) {
            });
    public static final Supplier<Item> HEAVYCANNON = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"heavycannon",
            () -> new DoomBaseItem(GunTypeEnum.HEAVYCANNON, 200) {
            });
    public static final Supplier<Item> DPLASMARIFLE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomed_plasma_rifle",
            () -> new DoomBaseItem(GunTypeEnum.DPLASMA, 400) {
            });
    public static final Supplier<Item> ROCKETLAUNCHER = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"rocketlauncher",
            () -> new DoomBaseItem(GunTypeEnum.ROCKETLAUNCHER, 50) {
            });
    public static final Supplier<Item> AXE_OPEN = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"axe_marauder_open",
            () -> new BaseSwordItem(MeleeWeaponEnum.MARAUDER_AXE, MCDoom.config.marauder_max_uses) {
            });
    public static final Supplier<Item> CHAINSAW64 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"chainsaw64",
            () -> new BaseSwordItem(MeleeWeaponEnum.CHAINSAW_64, 600) {
            });
    public static final Supplier<Item> CHAINSAW = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"chainsaw",
            () -> new BaseSwordItem(MeleeWeaponEnum.CHAINSAW, 600) {
            });
    public static final Supplier<Item> CHAINSAW_ETERNAL = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"chainsaweternal",
            () -> new BaseSwordItem(MeleeWeaponEnum.ETERNAL_CHAINSAW, 600) {
            });
    public static final Supplier<Item> SENTINELHAMMER = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"sentinelhammer",
            () -> new BaseSwordItem(MeleeWeaponEnum.SENTINEL_HAMMER, MCDoom.config.sentinelhammer_max_uses) {
            });
    public static final Supplier<Item> DARKLORDCRUCIBLE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"darklordcrucible",
            () -> new BaseSwordItem(MeleeWeaponEnum.DARK_CRUCIBLE, MCDoom.config.darkcrucible_max_uses) {
            });
    public static final Supplier<Item> CRUCIBLESWORD = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cruciblesword",
            () -> new BaseSwordItem(MeleeWeaponEnum.CRUCIBLE, MCDoom.config.crucible_max_uses) {
            });
    public static final Supplier<Item> GRENADE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomed_grenade", GrenadeItem::new);
    // ARMOR
    public static final Supplier<Item> DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.DOOM) {
            });
    public static final Supplier<Item> DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.DOOM) {
            });
    public static final Supplier<Item> DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.DOOM) {
            });
    public static final Supplier<Item> DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.DOOM) {
            });
    public static final Supplier<Item> PRAETOR_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"praetor_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.PRAETOR) {
            });
    public static final Supplier<Item> PRAETOR_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"praetor_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.PRAETOR) {
            });
    public static final Supplier<Item> PRAETOR_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"praetor_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.PRAETOR) {
            });
    public static final Supplier<Item> PRAETOR_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"praetor_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.PRAETOR) {
            });
    public static final Supplier<Item> ASTRO_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"astro_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.ASTRO) {
            });
    public static final Supplier<Item> ASTRO_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"astro_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.ASTRO) {
            });
    public static final Supplier<Item> ASTRO_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"astro_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.ASTRO) {
            });
    public static final Supplier<Item> ASTRO_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"astro_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.ASTRO) {
            });
    public static final Supplier<Item> CRIMSON_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"crimson_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.CRIMSON) {
            });
    public static final Supplier<Item> CRIMSON_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"crimson_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.CRIMSON) {
            });
    public static final Supplier<Item> CRIMSON_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"crimson_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.CRIMSON) {
            });
    public static final Supplier<Item> CRIMSON_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"crimson_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.CRIMSON) {
            });
    public static final Supplier<Item> MIDNIGHT_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"midnight_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.MIDNIGHT) {
            });
    public static final Supplier<Item> MIDNIGHT_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"midnight_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.MIDNIGHT) {
            });
    public static final Supplier<Item> MIDNIGHT_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"midnight_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.MIDNIGHT) {
            });
    public static final Supplier<Item> MIDNIGHT_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"midnight_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.MIDNIGHT) {
            });
    public static final Supplier<Item> DEMONIC_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demonic_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.DEMONIC) {
            });
    public static final Supplier<Item> DEMONIC_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demonic_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.DEMONIC) {
            });
    public static final Supplier<Item> DEMONIC_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demonic_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.DEMONIC) {
            });
    public static final Supplier<Item> DEMONIC_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demonic_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.DEMONIC) {
            });
    public static final Supplier<Item> DEMONCIDE_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demoncide_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.DEMONCIDE) {
            });
    public static final Supplier<Item> DEMONCIDE_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demoncide_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.DEMONCIDE) {
            });
    public static final Supplier<Item> DEMONCIDE_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demoncide_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.DEMONCIDE) {
            });
    public static final Supplier<Item> DEMONCIDE_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"demoncide_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.DEMONCIDE) {
            });
    public static final Supplier<Item> SENTINEL_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"sentinel_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.SENTINEL) {
            });
    public static final Supplier<Item> SENTINEL_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"sentinel_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.SENTINEL) {
            });
    public static final Supplier<Item> SENTINEL_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"sentinel_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.SENTINEL) {
            });
    public static final Supplier<Item> SENTINEL_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"sentinel_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.SENTINEL) {
            });
    public static final Supplier<Item> EMBER_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"ember_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.EMBER) {
            });
    public static final Supplier<Item> EMBER_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"ember_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.EMBER) {
            });
    public static final Supplier<Item> EMBER_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"ember_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.EMBER) {
            });
    public static final Supplier<Item> EMBER_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"ember_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.EMBER) {
            });
    public static final Supplier<Item> ZOMBIE_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"zombie_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.ZOMBIE) {
            });
    public static final Supplier<Item> ZOMBIE_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"zombie_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.ZOMBIE) {
            });
    public static final Supplier<Item> ZOMBIE_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"zombie_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.ZOMBIE) {
            });
    public static final Supplier<Item> ZOMBIE_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"zombie_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.ZOMBIE) {
            });
    public static final Supplier<Item> PHOBOS_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"phobos_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.PHOBOS) {
            });
    public static final Supplier<Item> PHOBOS_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"phobos_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.PHOBOS) {
            });
    public static final Supplier<Item> PHOBOS_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"phobos_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.PHOBOS) {
            });
    public static final Supplier<Item> PHOBOS_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"phobos_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.PHOBOS) {
            });
    public static final Supplier<Item> NIGHTMARE_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"nightmare_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.NIGHTMARE) {
            });
    public static final Supplier<Item> NIGHTMARE_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"nightmare_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.NIGHTMARE) {
            });
    public static final Supplier<Item> NIGHTMARE_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"nightmare_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.NIGHTMARE) {
            });
    public static final Supplier<Item> NIGHTMARE_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"nightmare_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.NIGHTMARE) {
            });
    public static final Supplier<Item> PURPLEPONY_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"purplepony_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.PURPLE_PONY) {
            });
    public static final Supplier<Item> PURPLEPONY_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"purplepony_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.PURPLE_PONY) {
            });
    public static final Supplier<Item> PURPLEPONY_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"purplepony_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.PURPLE_PONY) {
            });
    public static final Supplier<Item> PURPLEPONY_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"purplepony_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.PURPLE_PONY) {
            });
    public static final Supplier<Item> DOOMICORN_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomicorn_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.DOOMICORN) {
            });
    public static final Supplier<Item> DOOMICORN_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomicorn_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.DOOMICORN) {
            });
    public static final Supplier<Item> DOOMICORN_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomicorn_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.DOOMICORN) {
            });
    public static final Supplier<Item> DOOMICORN_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"doomicorn_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.DOOMICORN) {
            });
    public static final Supplier<Item> GOLD_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gold_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.GOLD) {
            });
    public static final Supplier<Item> GOLD_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gold_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.GOLD) {
            });
    public static final Supplier<Item> GOLD_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gold_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.GOLD) {
            });
    public static final Supplier<Item> GOLD_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"gold_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.GOLD) {
            });
    public static final Supplier<Item> TWENTY_FIVE_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"twenty_five_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.TWENTYFIVE) {
            });
    public static final Supplier<Item> TWENTY_FIVE_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"twenty_five_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.TWENTYFIVE) {
            });
    public static final Supplier<Item> TWENTY_FIVE_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"twenty_five_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.TWENTYFIVE) {
            });
    public static final Supplier<Item> TWENTY_FIVE_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"twenty_five_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.TWENTYFIVE) {
            });
    public static final Supplier<Item> BRONZE_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bronze_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.BRONZE) {
            });
    public static final Supplier<Item> BRONZE_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bronze_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.BRONZE) {
            });
    public static final Supplier<Item> BRONZE_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bronze_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.BRONZE) {
            });
    public static final Supplier<Item> BRONZE_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"bronze_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.BRONZE) {
            });
    public static final Supplier<Item> CULTIST_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cultist_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.CULTIST) {
            });
    public static final Supplier<Item> CULTIST_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cultist_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.CULTIST) {
            });
    public static final Supplier<Item> CULTIST_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cultist_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.CULTIST) {
            });
    public static final Supplier<Item> CULTIST_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"cultist_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.CULTIST) {
            });
    public static final Supplier<Item> MAYKR_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"maykr_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.MAYKR) {
            });
    public static final Supplier<Item> MAYKR_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"maykr_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.MAYKR) {
            });
    public static final Supplier<Item> MAYKR_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"maykr_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.MAYKR) {
            });
    public static final Supplier<Item> MAYKR_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"maykr_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.MAYKR) {
            });
    public static final Supplier<Item> PAINTER_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"painter_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.PAINTER) {
            });
    public static final Supplier<Item> PAINTER_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"painter_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.PAINTER) {
            });
    public static final Supplier<Item> CLASSIC_DOOM_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_doom_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.CLASSIC_GREEN) {
            });
    public static final Supplier<Item> CLASSIC_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_doom_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.CLASSIC_GREEN) {
            });
    public static final Supplier<Item> CLASSIC_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_doom_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.CLASSIC_GREEN) {
            });
    public static final Supplier<Item> CLASSIC_RED_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_red_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.CLASSIC_RED) {
            });
    public static final Supplier<Item> CLASSIC_RED_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_red_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.CLASSIC_RED) {
            });
    public static final Supplier<Item> CLASSIC_INDIGO_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_black_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.CLASSIC_INDIGO) {
            });
    public static final Supplier<Item> CLASSIC_INDIGO_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_black_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.CLASSIC_INDIGO) {
            });
    public static final Supplier<Item> CLASSIC_BRONZE_DOOM_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,
            "classic_bronze_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.CLASSIC_BRONZE) {
            });
    public static final Supplier<Item> CLASSIC_BRONZE_DOOM_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_bronze_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.CLASSIC_BRONZE) {
            });
    public static final Supplier<Item> CLASSIC_DOOM_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"classic_doom_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.CLASSIC_GREEN) {
            });
    public static final Supplier<Item> MULLET_DOOM_HELMET1 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"redneck_doom1_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.MULLET1) {
            });
    public static final Supplier<Item> MULLET_DOOM_CHESTPLATE1 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"redneck_doom1_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.MULLET1) {
            });
    public static final Supplier<Item> MULLET_DOOM_CHESTPLATE2 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"redneck_doom2_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.MULLET2) {
            });
    public static final Supplier<Item> MULLET_DOOM_CHESTPLATE3 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"redneck_doom3_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.MULLET3) {
            });
    public static final Supplier<Item> MULLET_DOOM_LEGGINGS1 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"redneck_doom1_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.MULLET1) {
            });
    public static final Supplier<Item> MULLET_DOOM_BOOTS1 = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"redneck_doom1_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.MULLET1) {
            });
    public static final Supplier<Item> HOTROD_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"hotrod_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.HOTROD) {
            });
    public static final Supplier<Item> HOTROD_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"hotrod_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.HOTROD) {
            });
    public static final Supplier<Item> HOTROD_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"hotrod_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.HOTROD) {
            });
    public static final Supplier<Item> HOTROD_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"hotrod_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.HOTROD) {
            });
    public static final Supplier<Item> SANTA_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"santa_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.SANTA) {
            });
    public static final Supplier<Item> DARKLORD_HELMET = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"darklord_helmet",
            () -> new DoomArmor(ArmorItem.Type.HELMET, ArmorTypeEnum.DARK_LORD) {
            });
    public static final Supplier<Item> DARKLORD_CHESTPLATE = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"darklord_chestplate",
            () -> new DoomArmor(ArmorItem.Type.CHESTPLATE, ArmorTypeEnum.DARK_LORD) {
            });
    public static final Supplier<Item> DARKLORD_LEGGINGS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"darklord_leggings",
            () -> new DoomArmor(ArmorItem.Type.LEGGINGS, ArmorTypeEnum.DARK_LORD) {
            });
    public static final Supplier<Item> DARKLORD_BOOTS = CommonItemRegistryInterface.registerItem(MCDoom.MOD_ID,"darklord_boots",
            () -> new DoomArmor(ArmorItem.Type.BOOTS, ArmorTypeEnum.DARK_LORD) {
            });
    public static void init() {
    }
}
