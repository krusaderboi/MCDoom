package mod.azure.doom.rei;

import com.mojang.datafixers.util.Pair;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import mod.azure.doom.recipes.GunTableRecipe;

import java.util.Collections;
import java.util.List;

public class DoomDisplay implements Display {
    public final List<EntryIngredient> input;
    public final List<Integer> count;
    public final EntryIngredient output;
    public final GunTableRecipe recipe2;

    public DoomDisplay(GunTableRecipe recipe) {
        input = recipe.ingredients().stream().map(Pair::getFirst).map(EntryIngredients::ofIngredient).toList();
        count = recipe.ingredients().stream().map(Pair::getSecond).toList();
        output = EntryIngredients.of(recipe.output());
        recipe2 = recipe;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return recipe2.ingredients().stream().map(Pair::getFirst).map(EntryIngredients::ofIngredient).toList();
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return Collections.singletonList(output);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ReiPlugin.CRAFTING;
    }
}