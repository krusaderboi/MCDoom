package mod.azure.doom.items.powerup;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DaisyItem extends Item {

    public DaisyItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext context, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(Component.translatable("doom.daisy1.text").withStyle(ChatFormatting.YELLOW).withStyle(
                ChatFormatting.ITALIC));
        list.add(Component.translatable("doom.daisy2.text").withStyle(ChatFormatting.ITALIC));
        super.appendHoverText(itemStack, context, list, tooltipFlag);
    }
}