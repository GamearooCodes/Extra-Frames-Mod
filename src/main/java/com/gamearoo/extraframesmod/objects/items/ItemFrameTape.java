package com.gamearoo.extraframesmod.objects.items;

import com.gamearoo.extraframesmod.Config;
import com.gamearoo.extraframesmod.ExtraFramesMod;
import com.gamearoo.extraframesmod.init.ItemInit;
import com.gamearoo.extraframesmod.utils.Reference;
import com.gamearoo.extraframesmod.utils.interfaces.IHasModel;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;

public class ItemFrameTape extends Item  implements IHasModel{
	public static PropertyInteger DYE = PropertyInteger.create("dye", 0, 15);
	
	
public ItemFrameTape() {
		
		setRegistryName("frame_tape_roll");
		setNoRepair();
		setMaxStackSize(1);
		setCreativeTab(ExtraFramesMod.extraframesmoditemstab);
		setHasSubtypes(true);	
		
		ItemInit.ITEMS.add(this);
	}

@Override
public void registerModels() {
	// TODO Auto-generated method stub
	for(EnumDyeColor color : EnumDyeColor.values()) {
		
		ModelLoader.setCustomModelResourceLocation(this, color.getMetadata(), new ModelResourceLocation(Reference.MOD_ID + ":frame_tape_" + color.getMetadata()));
	}
	
	
}

@Override
public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
	for(EnumDyeColor color : EnumDyeColor.values()) {
		
		items.add(new ItemStack(this, 1, color.getMetadata()));
		
	}
	
	
	
	
}

@Override
public int getItemBurnTime(ItemStack itemStack) {
	return Config.tapeBurnTime;
}

@Override
public String getUnlocalizedName(ItemStack stack) {
	String unlocalizedName = "item.frame_tape_roll.";
	int meta = stack.getMetadata();
	
	if (meta == EnumDyeColor.BLACK.getMetadata())
	{
		unlocalizedName += "black";
	}
	else if (meta == EnumDyeColor.BLUE.getMetadata())
	{
		unlocalizedName += "blue";
	}
	else if (meta == EnumDyeColor.BROWN.getMetadata())
	{
		unlocalizedName += "brown";
	}
	else if (meta == EnumDyeColor.CYAN.getMetadata())
	{
		unlocalizedName += "cyan";
	}
	else if (meta == EnumDyeColor.GRAY.getMetadata())
	{
		unlocalizedName += "gray";
	}
	else if (meta == EnumDyeColor.GREEN.getMetadata())
	{
		unlocalizedName += "green";
	}
	else if (meta == EnumDyeColor.LIGHT_BLUE.getMetadata())
	{
		unlocalizedName += "light_blue";
	}
	else if (meta == EnumDyeColor.SILVER.getMetadata())
	{
		unlocalizedName += "light_gray";
	}
	else if (meta == EnumDyeColor.LIME.getMetadata())
	{
		unlocalizedName += "lime";
	}
	else if (meta == EnumDyeColor.MAGENTA.getMetadata())
	{
		unlocalizedName += "magenta";
	}
	else if (meta == EnumDyeColor.ORANGE.getMetadata())
	{
		unlocalizedName += "orange";
	}
	else if (meta == EnumDyeColor.PINK.getMetadata())
	{
		unlocalizedName += "pink";
	}
	else if (meta == EnumDyeColor.PURPLE.getMetadata())
	{
		unlocalizedName += "purple";
	}
	else if (meta == EnumDyeColor.RED.getMetadata())
	{
		unlocalizedName += "red";
	}
	else if (meta == EnumDyeColor.WHITE.getMetadata())
	{
		unlocalizedName += "white";
	}
	else if (meta == EnumDyeColor.YELLOW.getMetadata())
	{
		unlocalizedName += "yellow";
	}
	
	else
	{
		unlocalizedName += "unknown";
	}
	
	return unlocalizedName; 
}
}
