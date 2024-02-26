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
            ModelPart layer = modelLoader.bakeLayer(SpaceAlloyedModel.SPACE_ALLOYED_LAYER);
            return new SpaceSuitModel(layer, original, entity, slot, stack);
        }, ItemRegistries.SPACE_ALLOYED_HELMET.get(), ItemRegistries.SPACE_ALLOYED.get(), ItemRegistries.SPACE_ALLOYED_PANTS.get(), ItemRegistries.SPACE_ALLOYED_BOOTS.get());
     }
}
