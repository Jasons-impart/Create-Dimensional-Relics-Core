package com.jasonsimpart.createdimensionalrelicscore.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public abstract class DimensionCropBlock extends CropBlock {
    public final ResourceLocation dimension;

    public DimensionCropBlock(Properties properties, ResourceLocation dimension) {
        super(properties);
        this.dimension = dimension;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (level instanceof ServerLevel serverLevel) {
            if (!serverLevel.dimension().location().equals(dimension))
                return false;
        }
        return super.canSurvive(state, level, pos);
    }
}
