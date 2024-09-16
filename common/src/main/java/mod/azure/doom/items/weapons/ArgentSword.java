package mod.azure.doom.items.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ArgentSword extends SwordItem {

    public ArgentSword() {
        super(Tiers.NETHERITE, new Properties().stacksTo(1).durability(9000));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext context, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(Component.translatable("doom.argent_powered.text").withStyle(ChatFormatting.RED).withStyle(
                ChatFormatting.ITALIC));
        super.appendHoverText(itemStack, context, list, tooltipFlag);
    }

}