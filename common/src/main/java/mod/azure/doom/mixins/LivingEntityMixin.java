package mod.azure.doom.mixins;

import io.wispforest.accessories.api.AccessoriesCapability;
import mod.azure.doom.MCDoom;
import mod.azure.doom.registry.DoomItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract EquipmentSlot getEquipmentSlotForItem(ItemStack stack);

    @Inject(method = "checkTotemDeathProtection", at = @At(value = "HEAD"), cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> ci) {
        final LivingEntity livingEntity = MCDoom.self(this);
        if (MCDoom.config.enable_soulcube_effects) {
            ItemStack stack = AccessoriesCapability.getOptionally(livingEntity)
                    .map(capability -> {
                        var equippedRef = capability.getFirstEquipped(DoomItems.SOULCUBE.get());

                        return (equippedRef != null) ? equippedRef.stack() : ItemStack.EMPTY;
                    }).orElse(ItemStack.EMPTY);

            if (!stack.isEmpty()) {
                stack.hurtAndBreak(1, livingEntity, livingEntity.getEquipmentSlotForItem(stack));
                livingEntity.setHealth(20.0F);
                livingEntity.removeAllEffects();
                livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 4));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 4));
                livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 95);
                ci.setReturnValue(true);
            }
        }
    }

}