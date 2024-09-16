package mod.azure.doom.registry;

import mod.azure.doom.MCDoom;
import mod.azure.doom.blocks.*;
import mod.azure.doom.registry.interfaces.CommonBlockRegistryInterface;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class DoomBlocks {

    public static final Supplier<Block> GUN_TABLE = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"gun_table", GunTableBlock::new);
    public static final Supplier<Block> BARREL_BLOCK = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"barrel", BarrelBlock::new);
    public static final Supplier<Block> ARGENT_BLOCK = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"argent_block", ArgentBlock::new);
    public static final Supplier<Block> ARGENT_LAMP_BLOCK = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"argent_lamp_block",
            ArgentLampBlock::new);
    public static final Supplier<Block> DOOM_SAND = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"doom_sand", DoomSandBlock::new);
    public static final Supplier<Block> JUMP_PAD = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"jump_pad", JumppadBlock::new);
    public static final Supplier<Block> ICON_WALL1 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall1", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL2 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall2", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL3 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall3", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL4 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall4", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL5 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall5", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL6 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall6", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL7 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall7", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL8 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall8", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL9 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall9", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL10 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall10", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL11 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall11", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL12 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall12", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL13 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall13", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL14 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall14", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL15 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall15", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> ICON_WALL16 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"icon_wall16", () -> new DoomWallBlock(
            BlockBehaviour.Properties.of().explosionResistance(30).strength(4.0F).sound(SoundType.METAL)));
    public static final Supplier<Block> TOTEM = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"totem", () -> new TotemBlock(
            BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK).noOcclusion().requiresCorrectToolForDrops().explosionResistance(30).strength(4.0F)));



     public static final Supplier<Block> E1M1_1 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block1", ArgentLampBlock::new);
     public static final Supplier<Block> E1M1_2 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block2", ArgentLampBlock::new);
     public static final Supplier<Block> E1M1_3 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block3", ArgentLampBlock::new);
     public static final Supplier<Block> E1M1_4 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block4", ArgentLampBlock::new);
     public static final Supplier<Block> E1M1_8 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block8",
            () -> new E1M1StairsBlock(E1M1_4.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(E1M1_4.get())));
     public static final Supplier<Block> E1M1_5 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block5", ArgentLampBlock::new);
     public static final Supplier<Block> E1M1_7 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block7",
            () -> new E1M1StairsBlock(E1M1_5.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(E1M1_5.get())));
     public static final Supplier<Block> E1M1_27 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block27",
            () -> new E1M1StairsBlock(E1M1_5.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(E1M1_5.get())));
     public static final Supplier<Block> E1M1_28 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block28",
            () -> new E1M1StairsBlock(E1M1_5.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(E1M1_5.get())));
     public static final Supplier<Block> E1M1_29 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block29",
            () -> new E1M1StairsBlock(E1M1_5.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(E1M1_5.get())));
     public static final Supplier<Block> E1M1_6 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block6", ArgentLampBlock::new);
     public static final Supplier<Block> E1M1_9 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block9", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_10 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block10", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_11 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block11", E1M1TurnableHurtBlock::new);
     public static final Supplier<Block> E1M1_12 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block12", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_13 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block13", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_14 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block14", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_15 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block15", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_16 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block16", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_17 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block17", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_18 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block18", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_19 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block19", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_20 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block20", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_21 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block21", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_22 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block22", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_23 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block23", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_24 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block24", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_25 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block25", E1M1TurnableBlock::new);
     public static final Supplier<Block> E1M1_26 = CommonBlockRegistryInterface.registerBlock(MCDoom.MOD_ID,"e1m1_block26", E1M1TurnableBlock::new);

    public static void init() {
    }

}
