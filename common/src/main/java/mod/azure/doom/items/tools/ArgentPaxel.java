package mod.azure.doom.items.tools;

import mod.azure.doom.registry.DoomTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class ArgentPaxel extends DiggerItem {
    protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Shovel.getFlattenables();
    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = Axe.getStrippables();

    public ArgentPaxel() {
        super(Tiers.NETHERITE,  DoomTags.PAXEL_BLOCKS, new Properties().stacksTo(1));
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return 30;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        final var world = context.getLevel();
        final var blockPos = context.getClickedPos();
        final var player = context.getPlayer();
        final var blockstate = world.getBlockState(blockPos);
        BlockState resultToSet = null;
        final var strippedResult = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
        if (strippedResult != null) {
            world.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            resultToSet = strippedResult.defaultBlockState().setValue(RotatedPillarBlock.AXIS,
                    blockstate.getValue(RotatedPillarBlock.AXIS));
        } else if (context.getClickedFace() != Direction.DOWN) {
            final var foundResult = SHOVEL_LOOKUP.get(blockstate.getBlock());
            if (foundResult != null && world.getBlockState(blockPos.above()).isAir()) {
                world.playSound(player, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else if (blockstate.getBlock() instanceof CampfireBlock && Boolean.TRUE.equals(
                    blockstate.getValue(CampfireBlock.LIT)))
                resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
        }
        if (resultToSet == null) return InteractionResult.PASS;
        if (!world.isClientSide()) {
            world.setBlock(blockPos, resultToSet, 11);
            if (player != null)
                context.getItemInHand().hurtAndBreak(1, player, player.getEquipmentSlotForItem(player.getMainHandItem()));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext context, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(Component.translatable("doom.argent_powered.text").withStyle(ChatFormatting.RED).withStyle(
                ChatFormatting.ITALIC));
        super.appendHoverText(itemStack, context, list, tooltipFlag);
    }

    private static final class Axe extends AxeItem {
        public static Map<Block, Block> getStrippables() {
            return AxeItem.STRIPPABLES;
        }

        private Axe(Tier tier, Properties properties) {
            super(tier, properties);
        }
    }

    private static final class Shovel extends ShovelItem {
        public static Map<Block, BlockState> getFlattenables() {
            return ShovelItem.FLATTENABLES;
        }

        private Shovel(Tier tier, Properties properties) {
            super(tier, properties);
        }
    }

}