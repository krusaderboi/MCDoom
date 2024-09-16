package mod.azure.doom.registry;

import mod.azure.doom.MCDoom;
import mod.azure.doom.client.gui.GunTableScreenHandler;
import mod.azure.doom.registry.interfaces.CommonMenuTypesRegistryInterface;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class DoomScreens {

    public static final Supplier<MenuType<GunTableScreenHandler>> SCREEN_HANDLER_TYPE = CommonMenuTypesRegistryInterface.registerScreen(
            MCDoom.MOD_ID, "gun_table_gui", () -> new MenuType<>(GunTableScreenHandler::new, FeatureFlags.VANILLA_SET));

    public static void init() {
    }
}
