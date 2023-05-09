package com.gamearoo.extraframesmod.objects.items;

import com.gamearoo.extraframesmod.ExtraFramesMod;
import com.gamearoo.extraframesmod.init.ItemInit;
import com.gamearoo.extraframesmod.utils.interfaces.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGlueTapeBottle extends Item implements IHasModel {
	public ItemGlueTapeBottle(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ExtraFramesMod.extraframesmoditemstab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return 100;
	}
	@Override
	public void registerModels() {
		ExtraFramesMod.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
