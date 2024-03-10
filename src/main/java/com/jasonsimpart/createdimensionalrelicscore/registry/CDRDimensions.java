package com.jasonsimpart.createdimensionalrelicscore.registry;

import com.jasonsimpart.createdimensionalrelicscore.CreateDimensionalRelicsCore;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class CDRDimensions {
    public static ResourceKey<Level> WHITERING = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CreateDimensionalRelicsCore.MODID, "whitering"));
}
