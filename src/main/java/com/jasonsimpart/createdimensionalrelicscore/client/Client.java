package com.jasonsimpart.createdimensionalrelicscore.client;

import com.jasonsimpart.createdimensionalrelicscore.armor.ArmorRenderer;
import com.jasonsimpart.createdimensionalrelicscore.registry.CDRBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Client {
    public static void init(){
        ArmorRenderer.init();
    }
}
