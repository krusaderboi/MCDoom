package mod.azure.doom.client.render.mobs.fodder;

import mod.azure.doom.client.models.mobs.fodder.LostSoulModel;
import mod.azure.doom.client.render.mobs.DoomMobRender;
import mod.azure.doom.entities.tierfodder.LostSoulEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LostSoulRender extends DoomMobRender<LostSoulEntity> {

    public LostSoulRender(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new LostSoulModel());
    }
}