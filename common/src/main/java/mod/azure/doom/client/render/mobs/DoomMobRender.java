package mod.azure.doom.client.render.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import mod.azure.doom.entities.DemonEntity;
import mod.azure.doom.entities.projectiles.MeatHookEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class DoomMobRender<T extends DemonEntity & GeoEntity> extends GeoEntityRenderer<T> {
    public DoomMobRender(EntityRendererProvider.Context renderManager, GeoModel<T> model) {
        super(renderManager, model);
    }

    @Override
    protected void applyRotations(T animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        if (this.isMicrowaving(animatable)) {
            rotationYaw += (float) (Math.cos((double) animatable.tickCount * 3.25) * Math.PI * 0.4000000059604645);
        }
        super.applyRotations(animatable, poseStack, ageInTicks, rotationYaw, partialTick);
    }

    public boolean isMicrowaving(T entity) {
        return entity.getFirstPassenger() != null && entity.getFirstPassenger() instanceof MeatHookEntity;
    }

    @Override
    protected int getBlockLightLevel(@NotNull T entityIn, @NotNull BlockPos partialTicks) {
        return 15;
    }

    @Override
    protected float getDeathMaxRotation(T entityLivingBaseIn) {
        return 0.0F;
    }

    @Override
    public float getMotionAnimThreshold(T animatable) {
        return 0.005f;
    }
}
