package mod.azure.doom;

import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.doom.helper.DoomLoot;
import mod.azure.doom.helper.MobAttributes;
import mod.azure.doom.helper.MobSpawn;
import mod.azure.doom.items.powerup.accessory.DaisyAccessory;
import mod.azure.doom.network.PacketHandler;
import mod.azure.doom.registry.DoomItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public final class FabricMCDoomMod implements ModInitializer {

    @Override
    public void onInitialize() {
        MCDoom.init();
        AzureLib.initialize();
        AzureLib.hasKeyBindsInitialized = true;
        DaisyAccessory.init();
        new PacketHandler().registerMessages();
        MobSpawn.addSpawnEntries();
        MobAttributes.initialize();
        LootTableEvents.MODIFY.register((key, table, source, registries)-> {
                    if (DoomLoot.BASTION_BRIDGE.equals(key.location()) || DoomLoot.BASTION_HOGLIN_STABLE.equals(
                            key.location()) || DoomLoot.BASTION_OTHER.equals(key.location()) || DoomLoot.BASTION_TREASURE.equals(
                            key.location()) || DoomLoot.NETHER_BRIDGE.equals(key.location()) || DoomLoot.RUINED_PORTAL.equals(
                            key.location()) || DoomLoot.SPAWN_BONUS_CHEST.equals(key.location())) {
                        LootPool poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                                .with(LootItem.lootTableItem(DoomItems.INMORTAL.get()).build())
                                .with(LootItem.lootTableItem(DoomItems.INVISIBLE.get()).build())
                                .with(LootItem.lootTableItem(DoomItems.MEGA.get()).build())
                                .with(LootItem.lootTableItem(DoomItems.POWER.get()).build())
                                .with(LootItem.lootTableItem(DoomItems.SOULCUBE.get()).build())
                                .with(LootItem.lootTableItem(DoomItems.DAISY.get()).build()).build();
                        table.pool(poolBuilder);
                    }
        });
        FuelRegistry.INSTANCE.add(DoomItems.ARGENT_ENERGY.get(), 32767);
    }
}
