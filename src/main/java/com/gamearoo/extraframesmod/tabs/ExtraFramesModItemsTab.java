package com.gamearoo.extraframesmod.tabs;

import com.clussmanproductions.trafficcontrol.ModItems;
import com.gamearoo.extraframesmod.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ExtraFramesModItemsTab extends CreativeTabs {
	public ExtraFramesModItemsTab(String label) {
		super("extraframesmoditemstab");
		
		
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.traffic_light_1_frame);
	}
}
