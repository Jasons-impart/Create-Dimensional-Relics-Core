package com.jasonsimpart.createdelightcore.registry;

import com.jasonsimpart.createdelightcore.item.PearlWandItem;
import com.jasonsimpart.createdelightcore.CreateDelightCore;
import com.jasonsimpart.createdelightcore.armor.BaseArmorMaterial;
import com.jasonsimpart.createdelightcore.armor.SpaceAlloyed;
import com.jasonsimpart.createdelightcore.tab.CreativeTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateDelightCore.MODID);

    // Space Alloyed Suit
    public static final RegistryObject<Item> SPACE_ALLOYED_HELMET = ITEMS.register("space_alloyed_helmet", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));
    public static final RegistryObject<Item> SPACE_ALLOYED = ITEMS.register("space_alloyed_suit", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));
    public static final RegistryObject<Item> SPACE_ALLOYED_PANTS = ITEMS.register("space_alloyed_pants", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));
    public static final RegistryObject<Item> SPACE_ALLOYED_BOOTS = ITEMS.register("space_alloyed_boots", () -> new SpaceAlloyed(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant()));

    // Developer's Items
    public static final RegistryObject<Item> PEARL_WAND = ITEMS.register("pearl_wand", PearlWandItem::new);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
