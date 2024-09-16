package mod.azure.doom.client.render.tile;

import mod.azure.azurelib.common.api.client.renderer.GeoBlockRenderer;
import mod.azure.doom.blocks.blockentities.GunBlockEntity;
import mod.azure.doom.client.models.tile.GunCraftingModel;

public class GunCraftingRender extends GeoBlockRenderer<GunBlockEntity> {

    public GunCraftingRender() {
        super(new GunCraftingModel());
    }

}