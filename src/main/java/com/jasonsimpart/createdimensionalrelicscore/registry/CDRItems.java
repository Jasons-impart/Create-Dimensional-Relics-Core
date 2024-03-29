package com.jasonsimpart.createdimensionalrelicscore.registry;

import com.jasonsimpart.createdimensionalrelicscore.item.IngotItem;
import com.jasonsimpart.createdimensionalrelicscore.item.PearlWandItem;
import com.jasonsimpart.createdimensionalrelicscore.CreateDimensionalRelicsCore;
import com.jasonsimpart.createdimensionalrelicscore.armor.BaseArmorMaterial;
import com.jasonsimpart.createdimensionalrelicscore.armor.SpaceAlloy;
import com.jasonsimpart.createdimensionalrelicscore.tab.CreativeTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CDRItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateDimensionalRelicsCore.MODID);

    // Space Alloyed Suit
    public static final Item.Properties SPACE_ALLOY_PROPERTIES = new Item.Properties()
            .tab(CreativeTab.CREATE_DIMENSIONAL_RELICS_TAB)
            .fireResistant()
            .rarity(Rarity.EPIC);
    public static final RegistryObject<Item> SPACE_ALLOY_HELMET = ITEMS.register("space_alloy_helmet", () -> new SpaceAlloy(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.HEAD, SPACE_ALLOY_PROPERTIES));
    public static final RegistryObject<Item> SPACE_ALLOY_CHESTPLATE = ITEMS.register("space_alloy_chestplate", () -> new SpaceAlloy(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.CHEST, SPACE_ALLOY_PROPERTIES));
    public static final RegistryObject<Item> SPACE_ALLOYED_LEGGINGS = ITEMS.register("space_alloy_leggings", () -> new SpaceAlloy(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.LEGS, SPACE_ALLOY_PROPERTIES));
    public static final RegistryObject<Item> SPACE_ALLOYED_BOOTS = ITEMS.register("space_alloy_boots", () -> new SpaceAlloy(BaseArmorMaterial.BASE_ARMOR, EquipmentSlot.FEET, SPACE_ALLOY_PROPERTIES));

    // ingots
    public static final RegistryObject<Item> OVERCHARGED_REDSTONE = ITEMS.register("overcharged_redstone", IngotItem::new);
    public static final RegistryObject<Item> SPACE_ALLOY_INGOT = ITEMS.register("space_alloy_ingot", IngotItem::new);
    public static final RegistryObject<Item> SPACE_ALLOY_NUGGET = ITEMS.register("space_alloy_nugget", IngotItem::new);
    public static final RegistryObject<Item> SPACE_ALLOY_SHEET = ITEMS.register("space_alloy_sheet", IngotItem::new);

    // Developer's Items
    public static final RegistryObject<Item> PEARL_WAND = ITEMS.register("pearl_wand", PearlWandItem::new);

    // Crops
    public static final RegistryObject<Item> DRY_WHEAT_SEEDS = ITEMS.register("dry_wheat_seeds", () -> new ItemNameBlockItem(CDRBlocks.FUEL_PLANT.get(), new Item.Properties().tab(CreativeTab.CREATE_DIMENSIONAL_RELICS_TAB)));
    public static final RegistryObject<Item> DRY_WHEAT = ITEMS.register("dry_wheat", () -> new Item(new Item.Properties().tab(CreativeTab.CREATE_DIMENSIONAL_RELICS_TAB)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
