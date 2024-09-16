package mod.azure.doom.blocks;

import mod.azure.doom.blocks.blockentities.BarrelEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BarrelBlock extends Block {
    public static final DirectionProperty direction = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty light = RedstoneTorchBlock.LIT;

    public BarrelBlock() {
        super(Properties.of().sound(SoundType.METAL).instabreak().noOcclusion());
        this.registerDefaultState(
                this.stateDefinition.any().setValue(direction, Direction.NORTH).setValue(light, Boolean.TRUE));
    }

    private static void explode(Level level, BlockPos blockPos) {
        if (level.isClientSide) return;
        var primedTnt = new BarrelEntity(level, blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5);
        level.addFreshEntity(primedTnt);
    }

    @Override
    public boolean dropFromExplosion(@NotNull Explosion explosionIn) {
        return false;
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull Block blockIn, @NotNull BlockPos fromPos, boolean isMoving) {
        explode(worldIn, pos);
        worldIn.removeBlock(pos, false);
    }

    @Override
    public void wasExploded(Level worldIn, @NotNull BlockPos pos, @NotNull Explosion explosionIn) {
        if (!worldIn.isClientSide) {
            var tntentity = new BarrelEntity(worldIn, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);
            worldIn.addFreshEntity(tntentity);
        }
    }

    @Override
    public void playerDestroy(Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack tool) {
        if (!level.isClientSide() && !player.isCreative()) explode(level, pos);
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        var itemstack = player.getItemInHand(hand);
        if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE))
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        else {
            explode(level, pos);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
            if (!player.isCreative() && !itemstack.is(Items.FLINT_AND_STEEL))
                itemstack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(itemstack));
            else itemstack.shrink(1);

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    @Override
    public void onProjectileHit(Level level, @NotNull BlockState blockState, @NotNull BlockHitResult blockHitResult, @NotNull Projectile projectile) {
        if (!level.isClientSide) {
            var blockPos = blockHitResult.getBlockPos();
            explode(level, blockPos);
            level.removeBlock(blockPos, false);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(direction, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(direction, rot.rotate(state.getValue(direction)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(direction)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(direction, light);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Shapes.box(0.06f, 0f, 0.06f, 0.94f, 1.0f, 0.94f);
    }

}