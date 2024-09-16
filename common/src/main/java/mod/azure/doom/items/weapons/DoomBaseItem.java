package mod.azure.doom.items.weapons;

import commonnetwork.api.Network;
import mod.azure.azurelib.common.api.client.helper.ClientUtils;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.animatable.SingletonGeoAnimatable;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import mod.azure.azurelib.core.animation.Animation.LoopType;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.doom.MCDoom;
import mod.azure.doom.client.DoomKeyBinds;
import mod.azure.doom.client.render.weapons.GunRender;
import mod.azure.doom.entities.projectiles.BulletEntity;
import mod.azure.doom.entities.projectiles.MeatHookEntity;
import mod.azure.doom.helper.CommonUtils;
import mod.azure.doom.helper.PlayerProperties;
import mod.azure.doom.items.enums.GunTypeEnum;
import mod.azure.doom.network.FiringPacket;
import mod.azure.doom.network.HookPacket;
import mod.azure.doom.network.ReloadPacket;
import mod.azure.doom.registry.DoomItems;
import mod.azure.doom.registry.DoomSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public abstract class DoomBaseItem extends Item implements GeoItem {
    protected final GunTypeEnum gunTypeEnum;
    private static final String firing = "firing";
    private static final String controller = "controller";
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    protected DoomBaseItem(GunTypeEnum gunTypeEnum, int maxClipSize) {
        super(new Item.Properties().stacksTo(1).durability(maxClipSize + 1));
        this.gunTypeEnum = gunTypeEnum;
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public static void shoot(Player player) {
        if (player.getMainHandItem().getDamageValue() < (player.getMainHandItem().getMaxDamage() - 1) && player.getMainHandItem().getItem() instanceof DoomBaseItem gunBase) {
            if (!player.getCooldowns().isOnCooldown(player.getMainHandItem().getItem()))
                gunBase.singleFire(player.getMainHandItem(), player.level(), player);
        } else {
            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    DoomSounds.EMPTY.get(), SoundSource.PLAYERS, 0.25F, 1.3F);
        }
    }

    public static void shootHook(Player player) {
        final var stack = player.getMainHandItem();
        if (stack.getDamageValue() < stack.getMaxDamage() - 2 && !player.level().isClientSide() && !player.getCooldowns().isOnCooldown(
                stack.getItem()) && stack.getItem() instanceof DoomBaseItem gunItem && gunItem.getGunTypeEnum() == GunTypeEnum.SUPERSHOTGUN) {
            player.getCooldowns().addCooldown(gunItem, 5);
            if (!((PlayerProperties) player).hasMeatHook()) {
                final var hookShot = new MeatHookEntity(player.level(), player);
                hookShot.shootFromRotation(player, player.getXRot(), player.getYRot() + 10, 0.0F, 20.0F, 1.0F);
                hookShot.setProperties(stack, MCDoom.config.max_meathook_distance, 100, player.getXRot(),
                        player.getYRot(), 0f, 1.5F);
                hookShot.getEntityData().set(MeatHookEntity.FORCED_YAW, player.getYRot());
                hookShot.setVariant(0);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CHAIN_FALL,
                        SoundSource.PLAYERS, 1.5F, 1.3F);
                player.level().addFreshEntity(hookShot);
            }
            ((PlayerProperties) player).setHasMeatHook(!((PlayerProperties) player).hasMeatHook());
        }
    }

    public static void reload(Player user, InteractionHand hand) {
        if (user.getMainHandItem().getItem() instanceof DoomBaseItem gunBase) {
            while (!user.isCreative() && user.getMainHandItem().getDamageValue() != 0 && user.getInventory().countItem(
                    gunBase.getAmmoType()) > 0) {
                CommonUtils.removeAmmo(gunBase.getAmmoType(), user);
                user.getCooldowns().addCooldown(gunBase, gunBase.getReloadCoolDown());
                user.getMainHandItem().hurtAndBreak(-gunBase.getReloadAmount(), user, user.getEquipmentSlotForItem(user.getMainHandItem()));
                user.getMainHandItem().setPopTime(3);
                if (gunBase.getReloadSound() != null)
                    user.level().playSound(null, user.getX(), user.getY(), user.getZ(), gunBase.getReloadSound(),
                            SoundSource.PLAYERS, 1.00F, 1.0F);
                if (!user.level().isClientSide && (gunBase.getGunTypeEnum() == GunTypeEnum.SUPERSHOTGUN || gunBase.getGunTypeEnum() == GunTypeEnum.DSHOTGUN || gunBase.getGunTypeEnum() == GunTypeEnum.SHOTGUN))
                    gunBase.triggerAnim(user,
                            GeoItem.getOrAssignId(user.getItemInHand(hand), (ServerLevel) user.level()),
                            DoomBaseItem.controller, "reload");
            }
        }
    }

    public GunTypeEnum getGunTypeEnum() {
        return this.gunTypeEnum;
    }

    public Item getAmmoType() {
        switch (this.getGunTypeEnum()) {
            case BALLISTA, DGAUSS -> {
                return DoomItems.ARGENT_BOLT.get();
            }
            case BFG, BFG9000 -> {
                return DoomItems.BFG_CELL.get();
            }
            case DPLASMA, PLAMSA -> {
                return DoomItems.ENERGY_CELLS.get();
            }
            case DSHOTGUN, SHOTGUN, SUPERSHOTGUN -> {
                return DoomItems.SHOTGUN_SHELLS.get();
            }
            case HEAVYCANNON, PISTOL -> {
                return DoomItems.BULLETS.get();
            }
            case ROCKETLAUNCHER -> {
                return DoomItems.ROCKET.get();
            }
            case UNMAKER, UNMAYKR -> {
                return DoomItems.UNMAKRY_BOLT.get();
            }
            default -> {
                return DoomItems.CHAINGUN_BULLETS.get();
            }
        }
    }

    public SoundEvent getReloadSound() {
        switch (this.getGunTypeEnum()) {
            case BALLISTA, BFG, BFG9000, CHAINGUN, DGAUSS, DPLASMA, HEAVYCANNON, PISTOL, PLAMSA, UNMAKER, UNMAYKR -> {
                return DoomSounds.CLIPRELOAD.get();
            }
            case DSHOTGUN, SHOTGUN, SUPERSHOTGUN -> {
                return DoomSounds.SHOTGUNRELOAD.get();
            }
            default -> {
                return SoundEvents.METAL_BREAK;
            }
        }
    }

    public SoundEvent getFiringSound() {
        switch (this.getGunTypeEnum()) {
            case BALLISTA, DGAUSS -> {
                return DoomSounds.BALLISTA_FIRING.get();
            }
            case BFG, BFG9000 -> {
                return DoomSounds.BFG_FIRING.get();
            }
            case CHAINGUN -> {
                return DoomSounds.CHAINGUN_SHOOT.get();
            }
            case DPLASMA, PLAMSA -> {
                return DoomSounds.PLASMA_FIRING.get();
            }
            case DSHOTGUN, SHOTGUN -> {
                return DoomSounds.SHOTGUN_SHOOT.get();
            }
            case HEAVYCANNON -> {
                return DoomSounds.HEAVY_CANNON.get();
            }
            case PISTOL -> {
                return DoomSounds.PISTOL_HIT.get();
            }
            case ROCKETLAUNCHER -> {
                return DoomSounds.ROCKET_FIRING.get();
            }
            case SUPERSHOTGUN -> {
                return DoomSounds.SUPER_SHOTGUN_SHOOT.get();
            }
            case UNMAKER, UNMAYKR -> {
                return DoomSounds.UNMAKYR_FIRE.get();
            }
        }
        return null;
    }

    public int getReloadAmount() {
        switch (this.getGunTypeEnum()) {
            case BALLISTA, DGAUSS -> {
                return 1;
            }
            case BFG, BFG9000, DPLASMA, PLAMSA, UNMAKER, UNMAYKR -> {
                return 20;
            }
            case DSHOTGUN, SHOTGUN, SUPERSHOTGUN -> {
                return 4;
            }
            case HEAVYCANNON, PISTOL -> {
                return 10;
            }
            case ROCKETLAUNCHER -> {
                return 2;
            }
            default -> {
                return 50;
            }
        }
    }

    public int getCoolDown() {
        switch (this.gunTypeEnum) {
            case BALLISTA, BFG, BFG9000, DGAUSS, ROCKETLAUNCHER -> {
                return 40;
            }
            case DSHOTGUN, SHOTGUN -> {
                return 18;
            }
            case SUPERSHOTGUN -> {
                return 30;
            }
            case DPLASMA, PISTOL, PLAMSA, UNMAKER, UNMAYKR -> {
                return 5;
            }
            case HEAVYCANNON -> {
                return 4;
            }
            default -> {
                return 3;
            }
        }
    }

    public int getReloadCoolDown() {
        switch (this.gunTypeEnum) {
            case BALLISTA, BFG, BFG9000, DGAUSS, SUPERSHOTGUN -> {
                return 15;
            }
            case CHAINGUN, ROCKETLAUNCHER, UNMAKER, UNMAYKR -> {
                return 10;
            }
            case DPLASMA, DSHOTGUN, HEAVYCANNON, PISTOL, PLAMSA, SHOTGUN -> {
                return 5;
            }
        }
        return 0;
    }

    private void singleFire(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Player player) {
        player.getCooldowns().addCooldown(this, this.getCoolDown());
        CommonUtils.spawnLightSource(player, player.level().isWaterAt(player.blockPosition()));
        itemStack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(player.getMainHandItem()));
        if (this.getFiringSound() != null)
            level.playSound(null, player.getX(), player.getY(), player.getZ(), getFiringSound(), SoundSource.PLAYERS,
                    0.25F, 1.3F);
        Projectile bullet = null;
        switch (this.gunTypeEnum) {
            case BALLISTA -> {
                bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.argent_bolt_damage);
                ((BulletEntity) bullet).setParticle(3);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);
            }
            case DGAUSS -> {
                bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.argent_bolt_damage);
                ((BulletEntity) bullet).setParticle(4);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);
            }
            case BFG, BFG9000 -> {
                bullet = CommonUtils.createBFG(level, player);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);
            }
            case CHAINGUN -> {
                bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.chaingun_bullet_damage);
                ((BulletEntity) bullet).setParticle(2);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);
            }
            case DPLASMA, PLAMSA -> {
                    bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.energycell_damage);
                    ((BulletEntity) bullet).setParticle(6);
                    bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                    level.playSound(null, player.getX(), player.getY(), player.getZ(), getFiringSound(),
                            SoundSource.PLAYERS, 0.25F, 1.3F);
                    level.addFreshEntity(bullet);
            }
            case DSHOTGUN -> {
                    bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.bullet_damage);
                    ((BulletEntity) bullet).setParticle(2);
                    bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                    level.playSound(null, player.getX(), player.getY(), player.getZ(), getFiringSound(),
                            SoundSource.PLAYERS, 0.25F, 1.3F);
                    level.addFreshEntity(bullet);
            }
            case SHOTGUN -> {
                bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.shotgun_damage);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);
            }
            case PISTOL -> {
                bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.bullet_damage);
                ((BulletEntity) bullet).setParticle(1);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);
            }
            case HEAVYCANNON -> {
                    bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.bullet_damage);
                    ((BulletEntity) bullet).setParticle(2);
                    bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                    level.playSound(null, player.getX(), player.getY(), player.getZ(), getFiringSound(),
                            SoundSource.PLAYERS, 0.25F, 1.3F);
                    level.addFreshEntity(bullet);
            }
            case ROCKETLAUNCHER -> {
                bullet = CommonUtils.createRocket(level, itemStack, player);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 0.75F, 1.0F);
                level.addFreshEntity(bullet);
            }
            case SUPERSHOTGUN -> {
                bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.shotgun_damage);
                ((BulletEntity) bullet).setParticle(2);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                var bullet2 = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.shotgun_damage);
                bullet2.shootFromRotation(player, player.getXRot(), player.getYRot() - 1, 0.0F, 3.0F, 1.0F);
                bullet2.setParticle(2);
                level.addFreshEntity(bullet2);
                level.addFreshEntity(bullet);
            }
            case UNMAKER, UNMAYKR -> {
                bullet = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.unmaykr_damage);
                ((BulletEntity) bullet).setParticle(5);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);

                var bullet1 = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.unmaykr_damage);
                bullet1.shootFromRotation(player, player.getXRot(), player.getYRot() + 10, 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet1);

                var bullet2 = CommonUtils.createBullet(level, itemStack, player, MCDoom.config.unmaykr_damage);
                bullet2.shootFromRotation(player, player.getXRot(), player.getYRot() - 10, 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet2);
            }
        }
        if (bullet != null) {
            if (this.getGunTypeEnum() != GunTypeEnum.BFG && this.getGunTypeEnum() != GunTypeEnum.DPLASMA)
                bullet.moveTo(player.getX(), player.getY(0.5), player.getZ(), 0, 0);
        }
        if (gunTypeEnum != GunTypeEnum.PLAMSA)
            this.triggerAnim(player, GeoItem.getOrAssignId(itemStack, (ServerLevel) player.level()),
                    DoomBaseItem.controller, "firing");
        if (gunTypeEnum == GunTypeEnum.PLAMSA)
            this.triggerAnim(player, GeoItem.getOrAssignId(itemStack, (ServerLevel) player.level()),
                    DoomBaseItem.controller, "firing_faster");
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level world, @NotNull Entity entity, int slot, boolean selected) {
        if (world.isClientSide && entity instanceof Player player && player.getMainHandItem().getItem() instanceof DoomBaseItem && selected) {
            if (ClientUtils.RELOAD.consumeClick()) {
                Network.getNetworkHandler().sendToServer(new ReloadPacket());
            }
            if (AzureLibMod.config.useVanillaUseKey) {
                if (Minecraft.getInstance().options.keyUse.isDown()) {
                    Network.getNetworkHandler().sendToServer(new FiringPacket());
                }
            } else {
                if (ClientUtils.FIRE_WEAPON.isDown()) {
                    Network.getNetworkHandler().sendToServer(new FiringPacket());
                }
            }
            if (DoomKeyBinds.HOOK.consumeClick()) {
                Network.getNetworkHandler().sendToServer(new HookPacket());
            }
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) {
        final var itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 72000;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        return false;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext context, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(Component.translatable(
                "Ammo: " + (itemStack.getMaxDamage() - itemStack.getDamageValue() - 1) + " / " + (itemStack.getMaxDamage() - 1)).withStyle(
                ChatFormatting.ITALIC));
        if (getGunTypeEnum() == GunTypeEnum.DGAUSS || getGunTypeEnum() == GunTypeEnum.DPLASMA || getGunTypeEnum() == GunTypeEnum.DSHOTGUN) {
            list.add(Component.translatable("doom.doomed_credit.text").withStyle(ChatFormatting.RED).withStyle(
                    ChatFormatting.ITALIC));
            list.add(Component.translatable("doom.doomed_credit1.text").withStyle(ChatFormatting.RED).withStyle(
                    ChatFormatting.ITALIC));
        }
        super.appendHoverText(itemStack, context, list, tooltipFlag);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, DoomBaseItem.controller, event -> PlayState.CONTINUE).triggerableAnim(
                        DoomBaseItem.firing,
                        RawAnimation.begin().then(DoomBaseItem.firing, LoopType.PLAY_ONCE)).triggerableAnim(
                        "firing_faster",
                        RawAnimation.begin().then("firing_faster", LoopType.PLAY_ONCE)).triggerableAnim("hook",
                        RawAnimation.begin().then("hook", LoopType.PLAY_ONCE)).triggerableAnim("reload",
                        RawAnimation.begin().then("reload", LoopType.PLAY_ONCE)));
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private GunRender<DoomBaseItem> renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                this.renderer = new GunRender<DoomBaseItem>(getGunTypeEnum());
                return this.renderer;
            }
        });
    }
}