package com.delight.tool.register;

import com.delight.tool.armor.ArmorRenderer;
import com.delight.tool.armor.SpaceAlloyedModel;
import earth.terrarium.ad_astra.client.registry.ClientModEntities;

public class Layers {
    public static void registerEntityLayers(ClientModEntities.LayerDefinitionRegistry registry) {
        registry.register(SpaceAlloyedModel.SPACE_ALLOYED_LAYER, SpaceAlloyedModel::createBodyLayer);
    }
}
