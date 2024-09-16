package mod.azure.doom.client.models.mobs.fodder;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.doom.MCDoom;
import mod.azure.doom.entities.tierfodder.ShotgunguyEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ShotgunguyModel extends GeoModel<ShotgunguyEntity> {

    @Override
    public ResourceLocation getModelResource(ShotgunguyEntity object) {
        return MCDoom.modResource("geo/shotgunzombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShotgunguyEntity object) {
        return ResourceLocation.fromNamespaceAndPath(MCDoom.MOD_ID,
                "textures/entity/" + (object.getVariant() == 2 ? "shotgunguy64" : "shotgunguy") + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShotgunguyEntity object) {
        return MCDoom.modResource("animations/shotgunzombie.animation.json");
    }

    @Override
    public void setCustomAnimations(ShotgunguyEntity animatable, long instanceId, AnimationState<ShotgunguyEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        var head = getAnimationProcessor().getBone("bipedHead");
        var entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        if (head != null) {
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }

    @Override
    public RenderType getRenderType(ShotgunguyEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}