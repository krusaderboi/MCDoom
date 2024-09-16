package mod.azure.doom.blocks;

import com.mojang.serialization.MapCodec;
import mod.azure.doom.blocks.blockentities.IconBlockEntity;
import mod.azure.doom.registry.DoomBlocks;
import mod.azure.doom.registry.DoomMobs;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DoomWallBlock extends BaseEntityBlock {

    public static final BooleanProperty light = RedstoneTorchBlock.LIT;
    @Nullable
    private static BlockPattern iconPatternFull;
    public static final MapCodec<BaseEntityBlock> CODEC = simpleCodec(DoomWallBlock::new);

    public DoomWallBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(light, Boolean.TRUE));
    }

    public static void checkIconSpawn(Level worldIn, BlockPos pos, IconBlockEntity tileEntityIn) {
        if (!worldIn.isClientSide) {
            var flag = isFlag(tileEntityIn);
            if (flag && pos.getY() >= 3 && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
                var blockpattern = getOrCreateIconFull();
                var patternHelper = blockpattern.find(worldIn, pos);
                if (patternHelper != null) {
                    for (var i = 0; i < blockpattern.getWidth(); ++i)
                        for (var j = 0; j < blockpattern.getHeight(); ++j) {
                            var cachedblockinfo = patternHelper.getBlock(i, j, 0);
                            worldIn.setBlock(cachedblockinfo.getPos(), Blocks.AIR.defaultBlockState(), 2);
                            worldIn.levelEvent(2001, cachedblockinfo.getPos(), Block.getId(cachedblockinfo.getState()));
                        }

                    var witherentity = DoomMobs.ICONOFSIN.get().create(worldIn);
                    var blockpos = patternHelper.getBlock(1, 2, 0).getPos();
                    assert witherentity != null;
                    witherentity.moveTo(blockpos.getX() + 0.5D, blockpos.getY() + 0.55D, blockpos.getZ() + 0.5D,
                            patternHelper.getForwards().getAxis() == Direction.Axis.X ? 0.0F : 90.0F, 0.0F);
                    witherentity.yBodyRot = patternHelper.getForwards().getAxis() == Direction.Axis.X ? 0.0F : 90.0F;
                    witherentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 4));
                    witherentity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 4));
                    worldIn.addFreshEntity(witherentity);

                    for (ServerPlayer serverplayerentity : worldIn.getEntitiesOfClass(ServerPlayer.class,
                            witherentity.getBoundingBox().inflate(50.0D)))
                        CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity, witherentity);

                    for (var k = 0; k < blockpattern.getWidth(); ++k)
                        for (var l = 0; l < blockpattern.getHeight(); ++l)
                            worldIn.updateNeighborsAt(patternHelper.getBlock(k, l, 0).getPos(), Blocks.AIR);
                }
            }
        }
    }

    private static boolean isFlag(IconBlockEntity tileEntityIn) {
        var block = tileEntityIn.getBlockState().getBlock();
        return block == DoomBlocks.ICON_WALL1.get() || block == DoomBlocks.ICON_WALL2.get() || block == DoomBlocks.ICON_WALL3.get() || block == DoomBlocks.ICON_WALL4.get() || block == DoomBlocks.ICON_WALL5.get() || block == DoomBlocks.ICON_WALL6.get() || block == DoomBlocks.ICON_WALL7.get() || block == DoomBlocks.ICON_WALL8.get() || block == DoomBlocks.ICON_WALL9.get() || block == DoomBlocks.ICON_WALL10.get() || block == DoomBlocks.ICON_WALL11.get() || block == DoomBlocks.ICON_WALL12.get() || block == DoomBlocks.ICON_WALL13.get() || block == DoomBlocks.ICON_WALL14.get() || block == DoomBlocks.ICON_WALL15.get() || block == DoomBlocks.ICON_WALL16.get();
    }

    public static BlockPattern getOrCreateIconFull() {
        if (iconPatternFull == null) {
            iconPatternFull = BlockPatternBuilder.start().aisle("!@#$", "%^&*", "()-_", "+=12").where('!',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL1.get()))).where('@',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL2.get()))).where('#',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL3.get()))).where('$',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL4.get()))).where('%',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL5.get()))).where('^',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL6.get()))).where('&',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL7.get()))).where('*',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL8.get()))).where('(',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL9.get()))).where(')',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL10.get()))).where('-',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL11.get()))).where('_',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL12.get()))).where('+',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL13.get()))).where('=',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL14.get()))).where('1',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL15.get()))).where('2',
                    BlockInWorld.hasState(BlockStatePredicate.forBlock(DoomBlocks.ICON_WALL16.get()))).build();
        }
        return iconPatternFull;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(light);
    }

    @Override
    public void setPlacedBy(@NotNull Level worldIn, @NotNull BlockPos pos, @NotNull BlockState state, LivingEntity placer, @NotNull ItemStack stack) {
        super.setPlacedBy(worldIn, pos, state, placer, stack);
        var tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof IconBlockEntity iconBlockEntity) checkIconSpawn(worldIn, pos, iconBlockEntity);
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return DoomMobs.ICON_BLOCK.get().create(pos, state);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
}