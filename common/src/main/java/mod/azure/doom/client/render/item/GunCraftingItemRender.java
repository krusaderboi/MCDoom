package mod.azure.doom.client.render.item;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.doom.client.models.items.GunCraftingItemModel;
import mod.azure.doom.items.blockitems.DoomBlockItem;

public class GunCraftingItemRender extends GeoItemRenderer<DoomBlockItem> {

    public GunCraftingItemRender() {
        super(new GunCraftingItemModel());
    }

}