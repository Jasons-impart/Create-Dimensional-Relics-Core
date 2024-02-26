package com.jasonsimpart.createdelightcore.register;

import com.jasonsimpart.createdelightcore.armor.SpaceAlloyedModel;
import earth.terrarium.ad_astra.client.registry.ClientModEntities;

public class Layers {
    public static void registerEntityLayers(ClientModEntities.LayerDefinitionRegistry registry) {
        registry.register(SpaceAlloyedModel.SPACE_ALLOYED_LAYER, SpaceAlloyedModel::createBodyLayer);
    }
}
