package mod.azure.doom.entities.tierambient;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.sblforked.api.SmartBrainOwner;
import mod.azure.azurelib.sblforked.api.core.BrainActivityGroup;
import mod.azure.azurelib.sblforked.api.core.SmartBrainProvider;
import mod.azure.azurelib.sblforked.api.core.behaviour.FirstApplicableBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.OneRandomBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.look.LookAtTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.misc.Idle;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.FloatToSurfaceOfFluid;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.MoveToWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetRandomWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.InvalidateAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetPlayerLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetRandomLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.TargetOrRetaliate;
import mod.azure.azurelib.sblforked.api.core.sensor.ExtendedSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.custom.UnreachableTargetSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.HurtBySensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import mod.azure.doom.MCDoom;
import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.entities.DoomAnimationsDefault;
import mod.azure.doom.entities.task.DemonMeleeAttack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CueBallEntity extends DemonEntity implements SmartBrainOwner<CueBallEntity> {

    public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(CueBallEntity.class,
            EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> FUSE_SPEED = SynchedEntityData.defineId(CueBallEntity.class,
            EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> CHARGED = SynchedEntityData.defineId(CueBallEntity.class,
            EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IGNITED = SynchedEntityData.defineId(CueBallEntity.class,
            EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private int currentFuseTime;
    private int fuseTime = 30;
    private int explosionRadius = 4;

    public CueBallEntity(EntityType<CueBallEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public static AttributeSupplier.@NotNull Builder createMobAttributes() {
        return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.MAX_HEALTH,
                MCDoom.config.cueball_health).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.MOVEMENT_SPEED,
                0.3D).add(Attributes.ATTACK_KNOCKBACK, 0.0D);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, event -> {
            if (event.isMoving()) return event.setAndContinue(DoomAnimationsDefault.WALK);
            if (dead || getHealth() < 0.01 || isDeadOrDying() && event.getAnimatable().getVariant() == 3)
                return event.setAndContinue(DoomAnimationsDefault.DEATH);
            return event.setAndContinue(DoomAnimationsDefault.IDLE);
        }).triggerableAnim("death", DoomAnimationsDefault.DEATH));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void knockback(double strength, double x, double z) {
        super.knockback(3, x, z);
    }

    @Override
    protected void tickDeath() {
        ++deathTime;
        if (getVariant() != 3) {
            if (deathTime == 30) {
                remove(RemovalReason.KILLED);
                if (!level().isClientSide) explode();
            }
        } else {
            if (deathTime == 5) {
                remove(RemovalReason.KILLED);
                if (!level().isClientSide) {
                    final var aabb = new AABB(blockPosition().above()).inflate(24D, 24D, 24D);
                    level().getEntitiesOfClass(DemonEntity.class, aabb).forEach(e -> {
                        if (e.isAlive()) e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 1));
                    });
                }
            }
        }
    }

    protected void explode() {
        level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 1.0F, Level.ExplosionInteraction.NONE);
    }

    @Override
    protected void customServerAiStep() {
        tickBrain(this);
        super.customServerAiStep();
    }

    @Override
    protected Brain.@NotNull Provider<?> brainProvider() {
        return new SmartBrainProvider<>(this);
    }

    @Override
    public List<ExtendedSensor<CueBallEntity>> getSensors() {
        return ObjectArrayList.of(new NearbyLivingEntitySensor<CueBallEntity>().setPredicate(
                        (target, entity) -> target.isAlive() && entity.hasLineOfSight(
                                target) && !(target instanceof DemonEntity)), new HurtBySensor<>(),
                new UnreachableTargetSensor<>());
    }

    @Override
    public BrainActivityGroup<CueBallEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(new LookAtTarget<>(), new LookAtTargetSink(40, 300),
                new FloatToSurfaceOfFluid<>(), new MoveToWalkTarget<>());
    }

    @Override
    public BrainActivityGroup<CueBallEntity> getIdleTasks() {
        return BrainActivityGroup.idleTasks(new FirstApplicableBehaviour<CueBallEntity>(
                        new TargetOrRetaliate<>().alertAlliesWhen((mob, entity) -> this.isAggressive()),
                        new SetPlayerLookTarget<>().stopIf(
                                target -> !target.isAlive() || target instanceof Player player && player.isCreative()),
                        new SetRandomLookTarget<>()),
                new OneRandomBehaviour<>(new SetRandomWalkTarget<>().setRadius(20).speedModifier(0.75f),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(30, 60))));
    }

    @Override
    public BrainActivityGroup<CueBallEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(
                new InvalidateAttackTarget<>().invalidateIf((target, entity) -> !target.isAlive()),
                new SetWalkTargetToAttackTarget<>().speedMod((owner, entity) -> 0.85F), new DemonMeleeAttack<>(0));
    }

    @Override
    protected void registerGoals() {
    }

    protected boolean shouldDrown() {
        return false;
    }

    protected boolean shouldBurnInDay() {
        return false;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        flameTimer = (flameTimer + 1) % 2;
        if (level().isClientSide && getVariant() == 3) {
            for (var i = 0; i < 2; ++i)
                level().addParticle(ParticleTypes.PORTAL, getRandomX(0.5D), getRandomY() - 0.25D, getRandomZ(0.5D),
                        (random.nextDouble() - 0.5D) * 2.0D, -random.nextDouble(), (random.nextDouble() - 0.5D) * 2.0D);
        }
        if (isAlive() && getVariant() != 3) {
            int i;
            if (isIgnited()) setFuseSpeed(1);
            if ((i = getFuseSpeed()) > 0 && currentFuseTime == 0) this.gameEvent(GameEvent.PRIME_FUSE);
            currentFuseTime += i;
            if (currentFuseTime < 0) currentFuseTime = 0;
            if (currentFuseTime >= fuseTime) {
                currentFuseTime = fuseTime;
                if (!(getHealth() < 0.01 || isDeadOrDying())) explode();
                kill();
            }
        }
    }

    public int getFlameTimer() {
        return flameTimer;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
        builder.define(FUSE_SPEED, -1);
        builder.define(CHARGED, false);
        builder.define(IGNITED, false);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setVariant(tag.getInt("Variant"));
        if (Boolean.TRUE.equals(entityData.get(CHARGED))) tag.putBoolean("powered", true);
        tag.putShort("Fuse", (short) fuseTime);
        tag.putByte("ExplosionRadius", (byte) explosionRadius);
        tag.putBoolean("ignited", isIgnited());
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", getVariant());
        entityData.set(CHARGED, tag.getBoolean("powered"));
        if (tag.contains("Fuse", 99)) fuseTime = tag.getShort("Fuse");
        if (tag.contains("ExplosionRadius", 99)) explosionRadius = tag.getByte("ExplosionRadius");
        if (tag.getBoolean("ignited")) ignite();
    }

    public int getVariant() {
        return Mth.clamp(entityData.get(VARIANT), 1, 3);
    }

    public void setVariant(int variant) {
        entityData.set(VARIANT, variant);
    }

    public int getVariants() {
        return 3;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        final var random = getRandom().nextInt(0, 4);
        setVariant(random);
        return spawnGroupData;
    }

    @Override
    public Component getCustomName() {
        if (getVariant() == 3) return Component.translatable("entity.doom.screecher");
        if (getVariant() == 2) return Component.translatable("entity.doom.possessedengineer");
        return super.getCustomName();
    }

    public int getFuseSpeed() {
        return entityData.get(FUSE_SPEED);
    }

    public void setFuseSpeed(int fuseSpeed) {
        entityData.set(FUSE_SPEED, fuseSpeed);
    }

    public boolean isIgnited() {
        return entityData.get(IGNITED);
    }

    public void ignite() {
        entityData.set(IGNITED, true);
    }

}
