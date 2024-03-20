package com.jasonsimpart.createdimensionalrelicscore.block.crop;

import com.jasonsimpart.createdimensionalrelicscore.registry.CDRItems;
import earth.terrarium.ad_astra.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DryWheat extends DimensionCropBlock {
    public DryWheat(Properties properties) {
        super(properties, new ResourceLocation("ad_astra", "mars"));
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return CDRItems.DRY_WHEAT_SEEDS.get();
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter block, BlockPos pos) {
        return state.is(ModBlocks.MARS_SAND.get());
    }
}
