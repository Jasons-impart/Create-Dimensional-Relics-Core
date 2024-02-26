package com.jasonsimpart.createdelightcore.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CreativeTab {
    public static final CreativeModeTab DELIGHT_TAB = new CreativeModeTab("delight_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.APPLE);
        }
    };
}
