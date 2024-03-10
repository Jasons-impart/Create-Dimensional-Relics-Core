package com.jasonsimpart.createdimensionalrelicscore.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public abstract class DimensionCropBlock extends CropBlock {
    public final ResourceKey<Level> dimension;

    public DimensionCropBlock(Properties properties, ResourceKey<Level> dimension) {
        super(properties);
        this.dimension = dimension;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (level.dimension().equals(dimension))
            super.randomTick(state, level, pos, source);
    }
}
