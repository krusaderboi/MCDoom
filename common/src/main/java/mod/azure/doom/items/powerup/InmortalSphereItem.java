package mod.azure.doom.items.powerup;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class InmortalSphereItem extends Item {

    public InmortalSphereItem() {
        super(new Properties().stacksTo(64));
    }

    @Override
    public void onUseTick(@NotNull Level worldIn, @NotNull LivingEntity livingEntityIn, @NotNull ItemStack stack, int count) {
        if (livingEntityIn instanceof Player playerentity && !worldIn.isClientSide()) {
            livingEntityIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 4));
            livingEntityIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 4));
            if (!playerentity.getAbilities().instabuild) {
                stack.shrink(1);
                if (stack.isEmpty()) playerentity.getInventory().removeItem(stack);
            }
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) {
        final var itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.NONE;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 7000;
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, Player user, @NotNull LivingEntity entity, @NotNull InteractionHand hand) {
        user.getItemInHand(hand);
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext context, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(Component.translatable("doom.inmortal.text").withStyle(ChatFormatting.ITALIC));
        super.appendHoverText(itemStack, context, list, tooltipFlag);
    }

}