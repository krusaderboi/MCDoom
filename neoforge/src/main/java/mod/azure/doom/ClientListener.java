package mod.azure.doom;

import com.mojang.blaze3d.platform.InputConstants;
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
import mod.azure.doom.registry.DoomBlocks;
import mod.azure.doom.registry.DoomItems;
import mod.azure.doom.registry.DoomMobs;
import mod.azure.doom.registry.DoomScreens;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = MCDoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientListener {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(DoomMobs.MEATHOOOK_ENTITY.get(), MeatHookEntityRenderer::new);
        event.registerEntityRenderer(DoomMobs.GRENADE.get(), GrenadeRender::new);
        event.registerEntityRenderer(DoomMobs.BULLETS.get(), BulletsRender::new);
        event.registerEntityRenderer(DoomMobs.BFG_CELL.get(), BFGCellRender::new);
        event.registerEntityRenderer(DoomMobs.ROCKET.get(), RocketRender::new);
        event.registerEntityRenderer(DoomMobs.GLADIATORMACE.get(), GladiatorMaceRender::new);
        event.registerEntityRenderer(DoomMobs.DRONEBOLT.get(), DroneBoltRender::new);
        event.registerEntityRenderer(DoomMobs.FIRE.get(), FireProjectileRender::new);
        event.registerEntityRenderer(DoomMobs.BLOODBOLT.get(), BloodBoltRender::new);
        event.registerEntityRenderer(DoomMobs.BARENBLAST.get(), BarenBlastRender::new);
        event.registerEntityRenderer(DoomMobs.LOST_SOUL.get(), LostSoulRender::new);
        event.registerEntityRenderer(DoomMobs.LOST_SOUL_ETERNAL.get(), LostSoulEternalRender::new);
        event.registerEntityRenderer(DoomMobs.IMP.get(), ImpRender::new);
        event.registerEntityRenderer(DoomMobs.ARACHNOTRON.get(), ArachonotronRender::new);
        event.registerEntityRenderer(DoomMobs.PINKY.get(), PinkyRender::new);
        event.registerEntityRenderer(DoomMobs.CACODEMON.get(), CacodemonRender::new);
        event.registerEntityRenderer(DoomMobs.ARCHVILE.get(), ArchvileRender::new);
        event.registerEntityRenderer(DoomMobs.BARON.get(), BaronRender::new);
        event.registerEntityRenderer(DoomMobs.MANCUBUS.get(), MancubusRender::new);
        event.registerEntityRenderer(DoomMobs.SPIDERMASTERMIND.get(), SpiderMastermindRender::new);
        event.registerEntityRenderer(DoomMobs.ZOMBIEMAN.get(), ZombiemanRender::new);
        event.registerEntityRenderer(DoomMobs.REVENANT.get(), RevenantRender::new);
        event.registerEntityRenderer(DoomMobs.CHAINGUNNER.get(), ChaingunnerRender::new);
        event.registerEntityRenderer(DoomMobs.SHOTGUNGUY.get(), ShotgunguyRender::new);
        event.registerEntityRenderer(DoomMobs.MARAUDER.get(), MarauderRender::new);
        event.registerEntityRenderer(DoomMobs.PAIN.get(), PainRender::new);
        event.registerEntityRenderer(DoomMobs.HELLKNIGHT.get(), HellknightRender::new);
        event.registerEntityRenderer(DoomMobs.CYBERDEMON.get(), CyberdemonRender::new);
        event.registerEntityRenderer(DoomMobs.UNWILLING.get(), UnwillingRender::new);
        event.registerEntityRenderer(DoomMobs.ICONOFSIN.get(), IconofsinRender::new);
        event.registerEntityRenderer(DoomMobs.POSSESSEDSCIENTIST.get(), PossessedScientistRender::new);
        event.registerEntityRenderer(DoomMobs.POSSESSEDSOLDIER.get(), PossessedSoldierRender::new);
        event.registerEntityRenderer(DoomMobs.ENGERYCELLMOB.get(), EnergyCellMobRender::new);
        event.registerEntityRenderer(DoomMobs.ROCKETMOB.get(), RocketMobRender::new);
        event.registerEntityRenderer(DoomMobs.CHAINGUN_MOB.get(), ChaingunMobRender::new);
        event.registerEntityRenderer(DoomMobs.GORE_NEST.get(), GoreNestRender::new);
        event.registerEntityRenderer(DoomMobs.MECHAZOMBIE.get(), MechaZombieRender::new);
        event.registerEntityRenderer(DoomMobs.GARGOYLE.get(), GargoyleRender::new);
        event.registerEntityRenderer(DoomMobs.HELLKNIGHT2016.get(), Hellknight2016Render::new);
        event.registerEntityRenderer(DoomMobs.DOOMFIRE.get(), ArchvileFiringRender::new);
        event.registerEntityRenderer(DoomMobs.SPECTRE.get(), SpectreRender::new);
        event.registerEntityRenderer(DoomMobs.CUEBALL.get(), CueBallRender::new);
        event.registerEntityRenderer(DoomMobs.PROWLER.get(), ProwlerRender::new);
        event.registerEntityRenderer(DoomMobs.DREADKNIGHT.get(), DreadKnightRender::new);
        event.registerEntityRenderer(DoomMobs.IMP_STONE.get(), ImpStoneRender::new);
        event.registerEntityRenderer(DoomMobs.POSSESSEDWORKER.get(), PossessedWorkerRender::new);
        event.registerEntityRenderer(DoomMobs.DOOMHUNTER.get(), DoomHunterRender::new);
        event.registerEntityRenderer(DoomMobs.WHIPLASH.get(), WhiplashRender::new);
        event.registerEntityRenderer(DoomMobs.BARON2016.get(), Baron2016Render::new);
        event.registerEntityRenderer(DoomMobs.FIREBARON.get(), FireBaronRender::new);
        event.registerEntityRenderer(DoomMobs.ARMORBARON.get(), ArmoredBaronRender::new);
        event.registerEntityRenderer(DoomMobs.MAYKRDRONE.get(), MaykrDroneRender::new);
        event.registerEntityRenderer(DoomMobs.BLOODMAYKR.get(), BloodMaykrRender::new);
        event.registerEntityRenderer(DoomMobs.ARCHMAKER.get(), ArchMaykrRender::new);
        event.registerEntityRenderer(DoomMobs.SPIDERMASTERMIND2016.get(), SpiderMastermind2016Render::new);
        event.registerEntityRenderer(DoomMobs.ARACHNOTRONETERNAL.get(), ArachonotronEternalRender::new);
        event.registerEntityRenderer(DoomMobs.TENTACLE.get(), TentacleRender::new);
        event.registerEntityRenderer(DoomMobs.MOTHERDEMON.get(), MotherDemonRender::new);
        event.registerEntityRenderer(DoomMobs.TURRET.get(), TurretRender::new);
        event.registerEntityRenderer(DoomMobs.SUMMONER.get(), SummonerRender::new);
        event.registerEntityRenderer(DoomMobs.REVENANT2016.get(), Revenant2016Render::new);
        event.registerEntityRenderer(DoomMobs.GLADIATOR.get(), GladiatorRender::new);
        event.registerEntityRenderer(DoomMobs.CARCASS.get(), CarcassRender::new);

        event.registerEntityRenderer(DoomMobs.BARREL.get(), BarrelRender::new);
        event.registerBlockEntityRenderer(DoomMobs.TOTEM_BLOCK.get(), context -> new TotemRender());
        event.registerBlockEntityRenderer(DoomMobs.GUN_TABLE_ENTITY.get(), context -> new GunCraftingRender());
    }

    @SubscribeEvent
    public static void registerScreens(final RegisterMenuScreensEvent event){
        event.register(DoomScreens.SCREEN_HANDLER_TYPE.get(), GunTableScreen::new);
    }

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        new PacketHandler().registerMessages();
        ItemBlockRenderTypes.setRenderLayer(DoomBlocks.JUMP_PAD.get(), RenderType.translucent());
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

    @SubscribeEvent
    public static void registerKeys(final RegisterKeyMappingsEvent event) {
        DoomKeyBinds.HOOK = new KeyMapping("key.doom.meathook", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H,
                "category.doom.binds");
        event.register(DoomKeyBinds.HOOK);
    }
}
