package com.gamearoo.extraframes.proxy;

import com.gamearoo.extraframes.ExtraFramesMod;
import com.gamearoo.extraframes.gui.ExtraFramesGuiHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtraFramesMod.instance, new ExtraFramesGuiHandler());
	}

	public void init(FMLInitializationEvent e) {
	}
}
