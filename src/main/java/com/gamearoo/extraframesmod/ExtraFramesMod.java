package com.gamearoo.extraframesmod;




import java.io.File;

import com.gamearoo.extraframesmod.proxy.CommonProxy;
import com.gamearoo.extraframesmod.tabs.*;
import com.gamearoo.extraframesmod.utils.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.NAME, useMetadata = true)
public class ExtraFramesMod {
	@Mod.Instance
	public static ExtraFramesMod instance;
	@SidedProxy(clientSide = "com.gamearoo.extraframesmod.proxy.ClientProxy", serverSide = "com.gamearoo.extraframesmod.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	
	
	public static Configuration config;
	
	

	
	
	public static final CreativeTabs extraframesmoditemstab = new ExtraFramesModItemsTab("extraframesmoditemstab");
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "extraframesmod.cfg"));
		Config.readConfig();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		
	}
	
}
