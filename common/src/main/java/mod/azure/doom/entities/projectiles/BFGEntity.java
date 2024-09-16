package mod.azure.doom.entities.projectiles;

import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.doom.MCDoom;
import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.entities.tierambient.GoreNestEntity;
import mod.azure.doom.entities.tierboss.ArchMakyrEntity;
import mod.azure.doom.entities.tierboss.GladiatorEntity;
import mod.azure.doom.entities.tierboss.IconofsinEntity;
import mod.azure.doom.entities.tierboss.MotherDemonEntity;
import mod.azure.doom.helper.CommonUtils;
import mod.azure.doom.registry.DoomMobs;
import mod.azure.doom.registry.DoomParticles;
import mod.azure.doom.registry.DoomSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BFGEntity extends AbstractArrow implements GeoEntity {

    private static final EntityDataAccessor<Integer> TARGET_ENTITY = SynchedEntityData.defineId(BFGEntity.class, EntityDataSerializers.INT);
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    Random rand = new Random();
    List<String> whitelistEntries = Arrays.asList(MCDoom.config.bfg_damage_mob_whitelist);
    int randomIndex = rand.nextInt(whitelistEntries.size());
    ResourceLocation randomElement1 = ResourceLocation.parse(whitelistEntries.get(randomIndex));
    EntityType<?> randomElement = BuiltInRegistries.ENTITY_TYPE.get(randomElement1);
    private int idleTicks = 0;

    public BFGEntity(EntityType<? extends BFGEntity> entityType, Level world) {
        super(entityType, world);
        this.pickup = Pickup.DISALLOWED;
    }

    public BFGEntity(Level world, LivingEntity owner) {
        super(DoomMobs.BFG_CELL.get(), world);
        this.pickup = Pickup.DISALLOWED;
        this.setOwner(owner);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, event -> event.setAndContinue(RawAnimation.begin().thenLoop("idle"))));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    protected void tickDespawn() {
        if (tickCount >= 120) remove(RemovalReason.KILLED);
    }

    @Override
    protected void doPostHurtEffects(@NotNull LivingEntity living) {
        super.doPostHurtEffects(living);
        if (!(living instanceof Player) && !(living instanceof IconofsinEntity)) {
            living.setDeltaMovement(0, 0, 0);
            living.invulnerableTime = 0;
        }
    }

    @Override
    protected boolean tryPickup(@NotNull Player player) {
        return false;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putShort("life", (short)this.tickCount);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.tickCount = compound.getShort("life");
    }

    @Override
    public void tick() {
        var idleOpt = 100;
        if (getDeltaMovement().lengthSqr() < 0.01) idleTicks++;
        else idleTicks = 0;
        if (idleTicks < idleOpt) super.tick();
        var isInsideWaterBlock = level().isWaterAt(blockPosition());
        CommonUtils.spawnLightSource(this, isInsideWaterBlock);
        if (this.tickCount >= 80) this.remove(RemovalReason.DISCARDED);
        CommonUtils.setOnFire(this);
        if (this.level().isClientSide()) {
            var x = this.getX() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            var z = this.getZ() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            this.level().addParticle(ParticleTypes.FLASH, true, x, this.getY(1), z, 0, 0, 0);
        }
        this.level().getEntitiesOfClass(LivingEntity.class,
                new AABB(this.blockPosition().above()).inflate(24D, 24D, 24D)).forEach(e -> {
            var listEntity = randomElement.tryCast(e);
            if (!(e instanceof Player || e instanceof EnderDragon || e instanceof GoreNestEntity || e instanceof IconofsinEntity || e instanceof ArchMakyrEntity || e instanceof GladiatorEntity || e instanceof MotherDemonEntity) && (e instanceof Monster || e instanceof Slime || e instanceof Phantom || e instanceof DemonEntity || e instanceof Shulker || e instanceof Hoglin || (e == listEntity)) && e.isAlive()) {
                e.hurt(damageSources().explosion(this, this.getOwner()), MCDoom.config.bfgball_damage_aoe);
            }
            if (e instanceof EnderDragon enderDragon && e.isAlive()) {
                enderDragon.head.hurt(damageSources().playerAttack((Player) this.getOwner()),
                        MCDoom.config.bfgball_damage_dragon * 0.3F);
            }
            if (e instanceof IconofsinEntity || e instanceof ArchMakyrEntity || e instanceof GladiatorEntity || e instanceof MotherDemonEntity && e.isAlive())
                e.hurt(damageSources().playerAttack((Player) this.getOwner()), MCDoom.config.bfgball_damage_aoe * 0.1F);
        });
    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return Items.AIR.getDefaultInstance();
    }

    @Override
    public boolean isNoGravity() {
        return !this.isInWater();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (!this.level().isClientSide()) this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        if (!this.level().isClientSide) {
            this.doDamage();
            this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 1.0F,
                    MCDoom.config.enable_block_breaking ? Level.ExplosionInteraction.BLOCK : Level.ExplosionInteraction.NONE);
            this.remove(RemovalReason.KILLED);
        }
        this.playSound(DoomSounds.BFG_HIT.get(), 1.0F,
                1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
    }

    public void doDamage() {
        this.level().getEntitiesOfClass(LivingEntity.class,
                new AABB(this.blockPosition().above()).inflate(24D, 24D, 24D)).forEach(e -> {
            var listEntity = randomElement.tryCast(e);
            if (!(e instanceof Player || e instanceof EnderDragon || e instanceof GoreNestEntity || e instanceof IconofsinEntity || e instanceof ArchMakyrEntity || e instanceof GladiatorEntity || e instanceof MotherDemonEntity) && (e instanceof Monster || e instanceof Slime || e instanceof Phantom || e instanceof DemonEntity || e instanceof Shulker || e instanceof Hoglin || (e == listEntity))) {
                if (this.isOnFire()) e.setRemainingFireTicks(50);
                e.hurt(damageSources().playerAttack((Player) this.getOwner()), MCDoom.config.bfgball_damage);
                if (!this.level().isClientSide) {
                    var list1 = this.level().getEntitiesOfClass(LivingEntity.class,
                            this.getBoundingBox().inflate(4.0D, 2.0D, 4.0D));
                    var areaEffectCloud = new AreaEffectCloud(e.level(), e.getX(), e.getY(), e.getZ());
                    areaEffectCloud.setParticle(ParticleTypes.TOTEM_OF_UNDYING);
                    areaEffectCloud.setRadius(3.0F);
                    areaEffectCloud.setDuration(10);
                    if (!list1.isEmpty()) {
                        for (var livingentity : list1) {
                            var d0 = this.distanceToSqr(livingentity);
                            if (d0 < 16.0D) areaEffectCloud.setPos(e.getX(), e.getEyeY(), e.getZ());
                        }
                    }
                    e.level().addFreshEntity(areaEffectCloud);
                }
            }
            if (e instanceof EnderDragon enderDragon && e.isAlive())
                enderDragon.head.hurt(damageSources().playerAttack((Player) this.getOwner()),
                        MCDoom.config.bfgball_damage_dragon * 0.3F);
            if (e instanceof IconofsinEntity || e instanceof ArchMakyrEntity || e instanceof GladiatorEntity || e instanceof MotherDemonEntity && e.isAlive()) {
                if (this.isOnFire()) e.setRemainingFireTicks(50);
                e.hurt(damageSources().playerAttack((Player) this.getOwner()), MCDoom.config.bfgball_damage * 0.1F);
            }
        });
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(TARGET_ENTITY, 0);
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return Items.AIR.getDefaultInstance();
    }
}