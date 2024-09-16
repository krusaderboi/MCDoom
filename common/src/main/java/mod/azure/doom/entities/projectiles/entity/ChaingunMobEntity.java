package mod.azure.doom.entities.projectiles.entity;

import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.registry.DoomSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class ChaingunMobEntity extends AbstractHurtingProjectile {

    public ChaingunMobEntity(EntityType<? extends ChaingunMobEntity> entity, Level level) {
        super(entity, level);
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount >= 80) remove(RemovalReason.DISCARDED);
        if (level().isClientSide())
            level().addParticle(ParticleTypes.SMOKE, true, this.getX() + random.nextDouble() * getBbWidth() * 0.5D,
                    this.getY(), this.getZ() + random.nextDouble() * getBbWidth() * 0.5D, 0, 0, 0);
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    public boolean isNoGravity() {
        return !isInWater();
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (!level().isClientSide()) {
            final var entity = entityHitResult.getEntity();
            final var entity2 = getOwner();
            float directHitDamage = 3F;
            if (entity instanceof LivingEntity livingEntity && (!(entity instanceof DemonEntity))) {
                livingEntity.hurt(damageSources().mobProjectile(this, livingEntity), directHitDamage);
            }
            if (entity2 instanceof LivingEntity) {
                remove(RemovalReason.DISCARDED);
            }
        }
        this.playSound(DoomSounds.CHAINGUN_SHOOT.get(), 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }
}