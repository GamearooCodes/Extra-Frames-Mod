package com.gamearoo.extraframesmod;
import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "general";
	
	public static int tapeMaxFrames = 8;
	public static int tooltipCharWrapLength = 256;
	public static void readConfig()
	{
		Configuration cfg = ExtraFramesMod.config;
		try
		{
			cfg.load();
			initGeneralConfig(cfg);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if (cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
		tooltipCharWrapLength = cfg.getInt("tooltipCharWrapLength", CATEGORY_GENERAL, tooltipCharWrapLength, 64, 5412, "How many letters should be rendered in a tooltip before it wraps down to the next line?");
		tapeMaxFrames = cfg.getInt("tapeMaxFrames", CATEGORY_GENERAL, tapeMaxFrames, 1, Integer.MAX_VALUE, "How many frames should a Frame Tape Roll work on?");
	}
}
