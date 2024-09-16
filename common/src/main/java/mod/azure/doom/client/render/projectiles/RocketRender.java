package mod.azure.doom.client.render.projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.internal.client.util.RenderUtils;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import mod.azure.doom.client.models.projectiles.RocketModel;
import mod.azure.doom.entities.projectiles.RocketEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class RocketRender extends GeoEntityRenderer<RocketEntity> {

    public RocketRender(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new RocketModel());
    }

    @Override
    protected int getBlockLightLevel(@NotNull RocketEntity entityIn, @NotNull BlockPos partialTicks) {
        return 15;
    }

    @Override
    public void preRender(PoseStack poseStack, RocketEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        RenderUtils.faceRotation(poseStack, animatable, partialTick);
        poseStack.scale(animatable.tickCount > 2 ? 1.0F : 0.0F, animatable.tickCount > 2 ? 1.0F : 0.0F, animatable.tickCount > 2 ? 1.0F : 0.0F);
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
    }

}