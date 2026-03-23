package com.gamearoo.extraframes;

import com.gamearoo.extraframes.item.ItemExtraColoredTrafficLightFrame;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = ExtraFramesMod.MODID)
public class ExtraFramesRegistry {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		ExtraFramesItems.ALL_COLORED_FRAMES.clear();
		for (FrameLayout layout : FrameLayout.values()) {
			for (EnumDyeColor color : EnumDyeColor.values()) {
				ItemExtraColoredTrafficLightFrame item = new ItemExtraColoredTrafficLightFrame(layout, color);
				event.getRegistry().register(item);
				ExtraFramesItems.ALL_COLORED_FRAMES.add(item);
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
		for (ItemExtraColoredTrafficLightFrame item : ExtraFramesItems.ALL_COLORED_FRAMES) {
			item.initModel();
		}
	}
}
