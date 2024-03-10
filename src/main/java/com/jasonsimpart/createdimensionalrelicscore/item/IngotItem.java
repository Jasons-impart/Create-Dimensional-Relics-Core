package com.jasonsimpart.createdimensionalrelicscore.item;

import com.jasonsimpart.createdimensionalrelicscore.tab.CreativeTab;
import net.minecraft.world.item.Item;

public class IngotItem extends Item {

    public IngotItem() {
        super(new Properties().tab(CreativeTab.CREATE_DIMENSIONAL_RELICS_TAB).stacksTo(64));
    }
}
