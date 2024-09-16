package mod.azure.doom.recipes;

import mod.azure.doom.client.gui.GunTableInventory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;

public interface GunRecipes extends Recipe<GunTableInventory.CustomRecipeInput> {
    default @NotNull RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }
}