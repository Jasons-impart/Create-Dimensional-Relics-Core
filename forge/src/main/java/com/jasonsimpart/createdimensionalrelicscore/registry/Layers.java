package com.jasonsimpart.createdimensionalrelicscore.registry;

import com.jasonsimpart.createdimensionalrelicscore.armor.SpaceAlloyedModel;
import earth.terrarium.ad_astra.client.registry.ClientModEntities;

public class Layers {
    public static void registerEntityLayers(ClientModEntities.LayerDefinitionRegistry registry) {
        registry.register(SpaceAlloyedModel.SPACE_ALLOYED_LAYER, SpaceAlloyedModel::createBodyLayer);
    }
}
