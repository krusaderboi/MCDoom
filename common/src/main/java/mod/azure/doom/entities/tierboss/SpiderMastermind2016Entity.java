package mod.azure.doom.entities.tierboss;

import mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.sblforked.api.core.BrainActivityGroup;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.InvalidateAttackTarget;
import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.entities.DoomAnimationsDefault;
import mod.azure.doom.entities.task.DemonProjectileAttack;
import mod.azure.doom.registry.DoomSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SpiderMastermind2016Entity extends SpiderMastermindEntity {

    public SpiderMastermind2016Entity(EntityType<? extends DemonEntity> entityType, Level worldIn) {
        super((EntityType<SpiderMastermindEntity>) entityType, worldIn);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        var isDead = this.dead || this.getHealth() < 0.01 || this.isDeadOrDying();
        controllers.add(new AnimationController<>(this, "livingController", 0, event -> {
            if (event.isMoving() && !isDead && !this.swinging)
                return event.setAndContinue(DoomAnimationsDefault.WALKING);
            return event.setAndContinue(isDead ? DoomAnimationsDefault.DEATH : DoomAnimationsDefault.IDLE);
        }).triggerableAnim("death", DoomAnimationsDefault.DEATH).setSoundKeyframeHandler(event -> {
            if (event.getKeyframeData().getSound().matches("walk") && (level().isClientSide()))
                level().playLocalSound(this.getX(), this.getY(), this.getZ(),
                        DoomSounds.SPIDERDEMON_AMBIENT.get(), SoundSource.HOSTILE,
                        0.25F, 1.0F, false);
        })).add(new AnimationController<>(this, "attackController", 0, event -> PlayState.STOP).setSoundKeyframeHandler(
                event -> {
                    if (event.getKeyframeData().getSound().matches("attack") && (level().isClientSide()))
                        level().playLocalSound(this.getX(), this.getY(), this.getZ(),
                                DoomSounds.PLASMA_FIRING.get(), SoundSource.HOSTILE,
                                0.25F, 1.0F, false);
                }).triggerableAnim("ranged", DoomAnimationsDefault.ATTACKING));
    }

    @Override
    protected void customServerAiStep() {
        tickBrain(this);
        super.customServerAiStep();
    }

    @Override
    public BrainActivityGroup<SpiderMastermindEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(new InvalidateAttackTarget<>().invalidateIf(
                        (target, entity) -> !target.isAlive() || !entity.hasLineOfSight(target)),
                new SetWalkTargetToAttackTarget<>().speedMod((owner, target) -> 1.05F),
                new DemonProjectileAttack<>(7).attackInterval(mob -> 40));
    }

    @Override
    public double getEyeY() {
        return 2.5;
    }
}
