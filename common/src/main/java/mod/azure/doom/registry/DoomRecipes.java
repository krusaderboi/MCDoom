package mod.azure.doom.registry;

import mod.azure.doom.MCDoom;
import mod.azure.doom.recipes.GunTableRecipe.Serializer;
import mod.azure.doom.registry.interfaces.CommonRecipeRegistryInterface;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class DoomRecipes {
    public static final Supplier<RecipeSerializer<?>> GUN_TABLE_SERIAL = CommonRecipeRegistryInterface.registerRecipe(
            MCDoom.MOD_ID, "gun_table", () -> Serializer.INSTANCE);

    public static void init() {
    }
}
