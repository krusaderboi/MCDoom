package mod.azure.doom.entities.projectiles.entity;

import mod.azure.doom.MCDoom;
import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.platform.Services;
import mod.azure.doom.registry.DoomMobs;
import mod.azure.doom.registry.DoomSounds;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class DroneBoltEntity extends AbstractHurtingProjectile {

    private float directHitDamage = 2;

    public DroneBoltEntity(EntityType<DroneBoltEntity> entity, Level level) {
        super(entity, level);
    }

    public DroneBoltEntity(Level worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ, float directHitDamage) {
        super(DoomMobs.DRONEBOLT.get(), accelX, accelY, accelZ, worldIn);
        this.directHitDamage = directHitDamage;
    }

    @Override
    public boolean isNoGravity() {
        return !isInWater();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result) {
        super.onHitBlock(result);
        if (!level().isClientSide()) {
            explode();
            remove(RemovalReason.DISCARDED);
        }
        this.playSound(DoomSounds.ROCKET_HIT.get(), 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
    }

    protected void explode() {
        level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 1.0F, false,
                MCDoom.config.enable_block_breaking ? Level.ExplosionInteraction.BLOCK : Level.ExplosionInteraction.NONE);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (!level().isClientSide()) {
            final var entity = entityHitResult.getEntity();
            final var entity2 = getOwner();
            if (entity instanceof LivingEntity livingEntity && (!(entity instanceof DemonEntity))) {
                livingEntity.hurt(damageSources().mobProjectile(this, livingEntity), directHitDamage);
            }
            if (entity2 instanceof LivingEntity) {
                remove(RemovalReason.DISCARDED);
            }
        }
        this.playSound(DoomSounds.UNMAKYR_FIRE.get(), 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount >= 80) remove(RemovalReason.DISCARDED);
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

}