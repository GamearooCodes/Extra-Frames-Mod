package com.gamearoo.extraframesmod.tabs;


import com.gamearoo.extraframesmod.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ExtraFramesModItemsTab extends CreativeTabs {
	public ExtraFramesModItemsTab(String label) {
		super("extraframesmoditemstab");
		
		
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.FRAME_TAPE_ROLL, 1, 0);
	}
}
