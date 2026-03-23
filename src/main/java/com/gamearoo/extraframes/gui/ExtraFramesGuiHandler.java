package com.gamearoo.extraframes.gui;

import com.gamearoo.extraframes.item.ItemExtraColoredTrafficLightFrame;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ExtraFramesGuiHandler implements IGuiHandler {

	public static final int GUI_EXTRA_COLORED_FRAME = 0;

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == GUI_EXTRA_COLORED_FRAME
				&& player.getHeldItemMainhand().getItem() instanceof ItemExtraColoredTrafficLightFrame) {
			ItemExtraColoredTrafficLightFrame item = (ItemExtraColoredTrafficLightFrame) player.getHeldItemMainhand()
					.getItem();
			ExtraColoredFrameContainer.beginLayout(item.getLayout());
			try {
				return new ExtraColoredFrameContainer(player.inventory, player.getHeldItemMainhand());
			} finally {
				ExtraColoredFrameContainer.endLayout();
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == GUI_EXTRA_COLORED_FRAME
				&& player.getHeldItemMainhand().getItem() instanceof ItemExtraColoredTrafficLightFrame) {
			return new ExtraColoredFrameGui(player.inventory, player.getHeldItemMainhand());
		}
		return null;
	}
}
