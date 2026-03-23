package com.gamearoo.extraframes;

import org.apache.logging.log4j.Logger;

import com.gamearoo.extraframes.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = ExtraFramesMod.MODID,
		name = ExtraFramesMod.NAME,
		version = ExtraFramesMod.VERSION,
		acceptedMinecraftVersions = "[1.12.2]",
		dependencies = "required-after:trafficcontrol")
public class ExtraFramesMod {

	public static final String MODID = "extraframesmod";
	public static final String NAME = "Extra Frames Mod";
	public static final String VERSION = "1.0";

	@Instance
	public static ExtraFramesMod instance;

	@SidedProxy(clientSide = "com.gamearoo.extraframes.proxy.ClientProxy", serverSide = "com.gamearoo.extraframes.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		logger = e.getModLog();
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
}
