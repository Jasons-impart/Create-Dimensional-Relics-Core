package com.jasonsimpart.createdimensionalrelicscore.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class CreativeTab {
    public static final CreativeModeTab CREATE_DIMENSIONAL_RELICS_TAB = new CreativeModeTab("create_dimensional_relics_tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Items.APPLE);
        }
    };
}
