package com.delight.tool;


import com.delight.tool.armor.BaseArmorMaterial;
import com.delight.tool.armor.SpaceAlloyed;
import com.delight.tool.client.Client;
import com.delight.tool.register.Layers;
import com.delight.tool.tab.CreativeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;

import earth.terrarium.ad_astra.client.registry.ClientModEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Supplier;

@Mod(CreateDelight.MOD_ID)
public class CreateDelight
{
	public static final String MOD_ID = "delight";
	public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registry.ITEM, CreateDelight.MOD_ID);
	public static final RegistryEntry<Item> SPACE_ALLOYED_HELMET = ITEMS.register("space_alloyed_helmet", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));
	public static final RegistryEntry<Item> SPACE_ALLOYED = ITEMS.register("space_alloyed_suit", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));
	public static final RegistryEntry<Item> SPACE_ALLOYED_PANTS = ITEMS.register("space_alloyed_pants", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));
	public static final RegistryEntry<Item> SPACE_ALLOYED_BOOTS = ITEMS.register("space_alloyed_boots", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));

	public CreateDelight()
	{
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.init();
		bus.addListener(CreateDelight::onCLientSetup);
		bus.addListener(CreateDelight::onRegisterLayerDefinitions);
	}

	public static void onCLientSetup(FMLClientSetupEvent event)
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
