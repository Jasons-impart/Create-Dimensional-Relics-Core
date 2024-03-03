package com.jasonsimpart.createdimensionalrelicscore.armor;

import com.jasonsimpart.createdimensionalrelicscore.registry.ItemRegistries;
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
        }, ItemRegistries.SPACE_ALLOY_HELMET.get(), ItemRegistries.SPACE_ALLOY_CHESTPLATE.get(), ItemRegistries.SPACE_ALLOYED_LEGGINGS.get(), ItemRegistries.SPACE_ALLOYED_BOOTS.get());
     }
}
