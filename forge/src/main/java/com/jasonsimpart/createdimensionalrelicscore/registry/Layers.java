package com.jasonsimpart.createdimensionalrelicscore.registry;

import com.jasonsimpart.createdimensionalrelicscore.armor.SpaceAlloyModel;
import earth.terrarium.ad_astra.client.registry.ClientModEntities;

public class Layers {
    public static void registerEntityLayers(ClientModEntities.LayerDefinitionRegistry registry) {
        registry.register(SpaceAlloyModel.SPACE_ALLOY_LAYER, SpaceAlloyModel::createBodyLayer);
    }
}
