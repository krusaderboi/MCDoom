package mod.azure.doom.blocks.blockentities;

import mod.azure.doom.platform.Services;
import mod.azure.doom.registry.DoomMobs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IconBlockEntity extends BlockEntity {

    public IconBlockEntity(BlockPos pos, BlockState state) {
        super(DoomMobs.ICON_BLOCK.get(), pos, state);
    }

}