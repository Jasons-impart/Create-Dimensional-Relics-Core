package com.jasonsimpart.createdimensionalrelicscore.armor;

import com.jasonsimpart.createdimensionalrelicscore.registry.CDRItems;
import earth.terrarium.ad_astra.client.renderer.armor.ArmourRenderers;
import earth.terrarium.ad_astra.client.renderer.armor.SpaceSuitModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;

public class ArmorRenderer extends ArmourRenderers{
    public static void init(){
        ArmourRenderers.registerArmour((entity, stack, slot, original) -> {
            EntityModelSet modelLoader = Minecraft.getInstance().getEntityModels();
            ModelPart layer = modelLoader.bakeLayer(SpaceAlloyModel.SPACE_ALLOY_LAYER);
            return new SpaceSuitModel(layer, original, entity, slot, stack);
        }, CDRItems.SPACE_ALLOY_HELMET.get(), CDRItems.SPACE_ALLOY_CHESTPLATE.get(), CDRItems.SPACE_ALLOYED_LEGGINGS.get(), CDRItems.SPACE_ALLOYED_BOOTS.get());
     }
}
