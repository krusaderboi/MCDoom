package mod.azure.doom.items.powerup.accessory;

import io.wispforest.accessories.api.AccessoriesAPI;
import io.wispforest.accessories.api.Accessory;
import io.wispforest.accessories.api.DropRule;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import mod.azure.doom.MCDoom;
import mod.azure.doom.registry.DoomItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

public class DaisyAccessory implements Accessory {
    public static void init() {
        AccessoriesAPI.registerAccessory(DoomItems.DAISY.get(), new DaisyAccessory());
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        if (MCDoom.config.enable_daisy_effects) {
            builder.addExclusive(Attributes.MOVEMENT_SPEED, new AttributeModifier(MCDoom.modResource("daisy_speed"), 2.0,
                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        }
        Accessory.super.getDynamicModifiers(stack, reference, builder);
    }

    @Override
    public DropRule getDropRule(ItemStack stack, SlotReference reference, DamageSource source) {
        return DropRule.DROP;
    }
}
