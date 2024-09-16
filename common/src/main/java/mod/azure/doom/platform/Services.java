package mod.azure.doom.platform;

import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.doom.platform.services.*;

import java.util.ServiceLoader;

public class Services {

    public static final CommonRegistry COMMON_REGISTRY = load(CommonRegistry.class);
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    private Services() {

    }

    public static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }
}