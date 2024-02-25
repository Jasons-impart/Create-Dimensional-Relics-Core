package com.delight.tool.armor;

import com.delight.tool.CreateDelight;
import earth.terrarium.ad_astra.client.renderer.armor.ArmourRenderers;
import earth.terrarium.ad_astra.client.renderer.armor.SpaceSuitModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

public class ArmorRenderer extends ArmourRenderers{


    public static void init(){
        ArmourRenderers.registerArmour((entity, stack, slot, original) -> {
            EntityModelSet modelLoader = Minecraft.getInstance().getEntityModels();
            ModelPart layer = modelLoader.bakeLayer(SpaceAlloyedModel.SPACE_ALLOYED_LAYER);
            return new SpaceSuitModel(layer, original, entity, slot, stack);
        }, CreateDelight.SPACE_ALLOYED_HELMET.get(), CreateDelight.SPACE_ALLOYED.get(), CreateDelight.SPACE_ALLOYED_PANTS.get(), CreateDelight.SPACE_ALLOYED_BOOTS.get());
     }
}
