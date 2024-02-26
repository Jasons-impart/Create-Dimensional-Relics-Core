package com.jasonsimpart.createdimensionalrelicscore;


import com.jasonsimpart.createdimensionalrelicscore.client.Client;
import com.jasonsimpart.createdimensionalrelicscore.registry.Layers;

import com.jasonsimpart.createdimensionalrelicscore.registry.ItemRegistries;
import earth.terrarium.ad_astra.client.registry.ClientModEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Supplier;

@Mod(CreateDimensionalRelicsCore.MODID)
public class CreateDimensionalRelicsCore
{
	public static final String MODID = "createdimensionalrelicscore";
	public CreateDimensionalRelicsCore() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemRegistries.register(bus);

		bus.addListener(CreateDimensionalRelicsCore::onClientSetup);
		bus.addListener(CreateDimensionalRelicsCore::onRegisterLayerDefinitions);
	}

	public static void onClientSetup(FMLClientSetupEvent event)
	{
		Client.init();
	}

	public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		Layers.registerEntityLayers(new ClientModEntities.LayerDefinitionRegistry() {
			@Override
			public void register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
				event.registerLayerDefinition(location, definition);
			}
		});
	}
}
