package mod.azure.doom;

import com.mojang.blaze3d.platform.InputConstants;
import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.doom.client.DoomKeyBinds;
import mod.azure.doom.client.gui.GunTableScreen;
import mod.azure.doom.client.render.mobs.ambient.CueBallRender;
import mod.azure.doom.client.render.mobs.ambient.GoreNestRender;
import mod.azure.doom.client.render.mobs.ambient.TentacleRender;
import mod.azure.doom.client.render.mobs.ambient.TurretRender;
import mod.azure.doom.client.render.mobs.boss.*;
import mod.azure.doom.client.render.mobs.fodder.*;
import mod.azure.doom.client.render.mobs.heavy.*;
import mod.azure.doom.client.render.mobs.superheavy.*;
import mod.azure.doom.client.render.projectiles.*;
import mod.azure.doom.client.render.projectiles.entity.*;
import mod.azure.doom.client.render.tile.BarrelRender;
import mod.azure.doom.client.render.tile.GunCraftingRender;
import mod.azure.doom.client.render.tile.TotemRender;
import mod.azure.doom.helper.CommonUtils;
import mod.azure.doom.network.PacketHandler;
import mod.azure.doom.particles.PlasmaParticle;
import mod.azure.doom.registry.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.glfw.GLFW;

public final class ClientListener implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AzureLib.hasKeyBindsInitialized = true;
        DoomKeyBinds.HOOK = new KeyMapping("key.doom.meathook", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H,
                "category.doom.binds");
        KeyBindingHelper.registerKeyBinding(DoomKeyBinds.HOOK);
        new PacketHandler().registerMessages();
        MenuScreens.register(DoomScreens.SCREEN_HANDLER_TYPE.get(), GunTableScreen::new);
        this.initMobRenders();
        this.initItemPlacement();
        ParticleFactoryRegistry.getInstance().register(DoomParticles.PLASMA.get(), PlasmaParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(DoomParticles.PISTOL.get(), PlasmaParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(DoomParticles.UNMAYKR.get(), PlasmaParticle.Factory::new);
    }

    public void initMobRenders() {
        EntityRendererRegistry.register(DoomMobs.ARCHVILE.get(), ArchvileRender::new);
        EntityRendererRegistry.register(DoomMobs.BARREL.get(), BarrelRender::new);
        EntityRendererRegistry.register(DoomMobs.IMP.get(), ImpRender::new);
        EntityRendererRegistry.register(DoomMobs.PINKY.get(), PinkyRender::new);
        EntityRendererRegistry.register(DoomMobs.SPECTRE.get(), SpectreRender::new);
        EntityRendererRegistry.register(DoomMobs.LOST_SOUL.get(), LostSoulRender::new);
        EntityRendererRegistry.register(DoomMobs.LOST_SOUL_ETERNAL.get(), LostSoulEternalRender::new);
        EntityRendererRegistry.register(DoomMobs.CACODEMON.get(), CacodemonRender::new);
        EntityRendererRegistry.register(DoomMobs.BARON.get(), BaronRender::new);
        EntityRendererRegistry.register(DoomMobs.MANCUBUS.get(), MancubusRender::new);
        EntityRendererRegistry.register(DoomMobs.SPIDERMASTERMIND.get(), SpiderMastermindRender::new);
        EntityRendererRegistry.register(DoomMobs.ARACHNOTRON.get(), ArachonotronRender::new);
        EntityRendererRegistry.register(DoomMobs.ZOMBIEMAN.get(), ZombiemanRender::new);
        EntityRendererRegistry.register(DoomMobs.REVENANT.get(), RevenantRender::new);
        EntityRendererRegistry.register(DoomMobs.GORE_NEST.get(), GoreNestRender::new);
        EntityRendererRegistry.register(DoomMobs.CHAINGUNNER.get(), ChaingunnerRender::new);
        EntityRendererRegistry.register(DoomMobs.SHOTGUNGUY.get(), ShotgunguyRender::new);
        EntityRendererRegistry.register(DoomMobs.MARAUDER.get(), MarauderRender::new);
        EntityRendererRegistry.register(DoomMobs.PAIN.get(), PainRender::new);
        EntityRendererRegistry.register(DoomMobs.HELLKNIGHT.get(), HellknightRender::new);
        EntityRendererRegistry.register(DoomMobs.HELLKNIGHT2016.get(), Hellknight2016Render::new);
        EntityRendererRegistry.register(DoomMobs.CYBERDEMON.get(), CyberdemonRender::new);
        EntityRendererRegistry.register(DoomMobs.UNWILLING.get(), UnwillingRender::new);
        EntityRendererRegistry.register(DoomMobs.ICONOFSIN.get(), IconofsinRender::new);
        EntityRendererRegistry.register(DoomMobs.POSSESSEDSCIENTIST.get(), PossessedScientistRender::new);
        EntityRendererRegistry.register(DoomMobs.POSSESSEDSOLDIER.get(), PossessedSoldierRender::new);
        EntityRendererRegistry.register(DoomMobs.GARGOYLE.get(), GargoyleRender::new);
        EntityRendererRegistry.register(DoomMobs.MECHAZOMBIE.get(), MechaZombieRender::new);
        EntityRendererRegistry.register(DoomMobs.CUEBALL.get(), CueBallRender::new);
        EntityRendererRegistry.register(DoomMobs.PROWLER.get(), ProwlerRender::new);
        EntityRendererRegistry.register(DoomMobs.DREADKNIGHT.get(), DreadKnightRender::new);
        EntityRendererRegistry.register(DoomMobs.IMP_STONE.get(), ImpStoneRender::new);
        EntityRendererRegistry.register(DoomMobs.POSSESSEDWORKER.get(), PossessedWorkerRender::new);
        EntityRendererRegistry.register(DoomMobs.DOOMHUNTER.get(), DoomHunterRender::new);
        EntityRendererRegistry.register(DoomMobs.MAYKRDRONE.get(), MaykrDroneRender::new);
        EntityRendererRegistry.register(DoomMobs.WHIPLASH.get(), WhiplashRender::new);
        EntityRendererRegistry.register(DoomMobs.BARON2016.get(), Baron2016Render::new);
        EntityRendererRegistry.register(DoomMobs.FIREBARON.get(), FireBaronRender::new);
        EntityRendererRegistry.register(DoomMobs.ARMORBARON.get(), ArmoredBaronRender::new);
        EntityRendererRegistry.register(DoomMobs.BLOODMAYKR.get(), BloodMaykrRender::new);
        EntityRendererRegistry.register(DoomMobs.ARCHMAKER.get(), ArchMaykrRender::new);
        EntityRendererRegistry.register(DoomMobs.ARACHNOTRONETERNAL.get(), ArachonotronEternalRender::new);
        EntityRendererRegistry.register(DoomMobs.SPIDERMASTERMIND2016.get(), SpiderMastermind2016Render::new);
        EntityRendererRegistry.register(DoomMobs.TENTACLE.get(), TentacleRender::new);
        EntityRendererRegistry.register(DoomMobs.TURRET.get(), TurretRender::new);
        EntityRendererRegistry.register(DoomMobs.MOTHERDEMON.get(), MotherDemonRender::new);
        EntityRendererRegistry.register(DoomMobs.SUMMONER.get(), SummonerRender::new);
        EntityRendererRegistry.register(DoomMobs.REVENANT2016.get(), Revenant2016Render::new);
        EntityRendererRegistry.register(DoomMobs.GLADIATOR.get(), GladiatorRender::new);
        EntityRendererRegistry.register(DoomMobs.CARCASS.get(), CarcassRender::new);
        EntityRendererRegistry.register(DoomMobs.BARENBLAST.get(), BarenBlastRender::new);
        EntityRendererRegistry.register(DoomMobs.ROCKETMOB.get(), RocketMobRender::new);
        EntityRendererRegistry.register(DoomMobs.ENGERYCELLMOB.get(), EnergyCellMobRender::new);
        EntityRendererRegistry.register(DoomMobs.CHAINGUN_MOB.get(), ChaingunMobRender::new);
        EntityRendererRegistry.register(DoomMobs.DOOMFIRE.get(), ArchvileFiringRender::new);
        EntityRendererRegistry.register(DoomMobs.GLADIATORMACE.get(), GladiatorMaceRender::new);
        EntityRendererRegistry.register(DoomMobs.DRONEBOLT.get(), DroneBoltRender::new);
        EntityRendererRegistry.register(DoomMobs.BLOODBOLT.get(), BloodBoltRender::new);
        EntityRendererRegistry.register(DoomMobs.FIRE.get(), FireProjectileRender::new);
        EntityRendererRegistry.register(DoomMobs.GRENADE.get(), GrenadeRender::new);
        EntityRendererRegistry.register(DoomMobs.BFG_CELL.get(), BFGCellRender::new);
        EntityRendererRegistry.register(DoomMobs.ROCKET.get(), RocketRender::new);
        EntityRendererRegistry.register(DoomMobs.BULLETS.get(), BulletsRender::new);
        EntityRendererRegistry.register(DoomMobs.MEATHOOOK_ENTITY.get(), MeatHookEntityRenderer::new);
        BlockEntityRenderers.register(DoomMobs.TOTEM_BLOCK.get(),
                (BlockEntityRendererProvider.Context rendererDispatcherIn) -> new TotemRender());
        BlockEntityRenderers.register(DoomMobs.GUN_TABLE_ENTITY.get(),
                (BlockEntityRendererProvider.Context rendererDispatcherIn) -> new GunCraftingRender());
        BlockRenderLayerMap.INSTANCE.putBlock(DoomBlocks.JUMP_PAD.get(), RenderType.translucent());
    }

    public void initItemPlacement() {
        // Crucible
        ItemProperties.register(DoomItems.CRUCIBLESWORD.get(), ResourceLocation.parse("broken"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.isUsable(itemStack) ? 0.0F : 1.0F));
        // Marauder Axe
        ItemProperties.register(DoomItems.AXE_OPEN.get(), ResourceLocation.parse("broken"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.isUsable(itemStack) ? 0.0F : 1.0F));
        // NonCenter
        ItemProperties.register(DoomItems.SG.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.ROCKETLAUNCHER.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.PLASMAGUN.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.HEAVYCANNON.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.UNMAKER.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.UNMAYKR.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.CHAINGUN.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.BFG_ETERNAL.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.BALLISTA.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.SSG.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.PISTOL.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.DPLASMARIFLE.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.DGAUSS.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.DSG.get(), ResourceLocation.parse("nocenter"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.nonCentered() ? 1.0F : 0.0F));
        ItemProperties.register(DoomItems.CHAINSAW.get(), ResourceLocation.parse("stalled"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.isUsable(itemStack) ? 0.0F : 1.0F));
        ItemProperties.register(DoomItems.CHAINSAW64.get(), ResourceLocation.parse("stalled"),
                (itemStack, clientWorld, livingEntity, seed) -> (CommonUtils.isUsable(itemStack) ? 0.0F : 1.0F));
    }
}
