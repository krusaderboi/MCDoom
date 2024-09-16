package mod.azure.doom;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.doom.config.DoomConfig;
import mod.azure.doom.registry.*;
import net.minecraft.resources.ResourceLocation;

public record MCDoom() {

    public static DoomConfig config;
    public static final String MOD_ID = "doom";

    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init(){
        config = AzureLibMod.registerConfig(DoomConfig.class, ConfigFormats.json()).getConfigInstance();
        DoomScreens.init();
        DoomSounds.init();
        DoomBlocks.init();
        DoomMobs.init();
        DoomItems.init();
        DoomParticles.init();
        DoomTabs.init();
        DoomRecipes.init();
    }

    public static <T> T self(Object object) {
        return (T) object;
    }

}