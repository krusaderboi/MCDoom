package mod.azure.doom.client.render.projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.internal.client.util.RenderUtils;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import mod.azure.doom.client.models.projectiles.BFGBallModel;
import mod.azure.doom.entities.projectiles.BFGEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class BFGCellRender extends GeoEntityRenderer<BFGEntity> {

    public BFGCellRender(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new BFGBallModel());
    }

    @Override
    protected int getBlockLightLevel(@NotNull BFGEntity entityIn, @NotNull BlockPos partialTicks) {
        return 15;
    }

    @Override
    public void preRender(PoseStack poseStack, BFGEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        RenderUtils.faceRotation(poseStack, animatable, partialTick);
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
    }

}