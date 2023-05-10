package com.gamearoo.extraframesmod;
import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "general";
	
	public static int glueBurnTime = 100;
	public static int tapeBurnTime = 50;
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
		glueBurnTime = cfg.getInt("glueBurnTime", CATEGORY_GENERAL, glueBurnTime, 1, Integer.MAX_VALUE, "How long should the glue burn for in a furnece?");
		tapeBurnTime = cfg.getInt("tapeBurnTime", CATEGORY_GENERAL, tapeBurnTime, 1, Integer.MAX_VALUE, "How long should the tapes burn for in a furnece?");
	}
}
