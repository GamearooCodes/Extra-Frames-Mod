package com.gamearoo.extraframes.gui;

import com.clussmanproductions.trafficcontrol.gui.BaseTrafficLightFrameGui;
import com.gamearoo.extraframes.FrameLayout;
import com.gamearoo.extraframes.item.ItemExtraColoredTrafficLightFrame;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class ExtraColoredFrameGui extends BaseTrafficLightFrameGui {

	private final FrameLayout layout;

	public ExtraColoredFrameGui(InventoryPlayer inventory, ItemStack frameStack) {
		super(openContainer(inventory, frameStack));
		this.layout = ((ItemExtraColoredTrafficLightFrame) frameStack.getItem()).getLayout();
		xSize = layout.getXSize();
		ySize = layout.getYSize();
	}

	private static ExtraColoredFrameContainer openContainer(InventoryPlayer inventory, ItemStack frameStack) {
		FrameLayout layout = ((ItemExtraColoredTrafficLightFrame) frameStack.getItem()).getLayout();
		ExtraColoredFrameContainer.beginLayout(layout);
		try {
			return new ExtraColoredFrameContainer(inventory, frameStack);
		} finally {
			ExtraColoredFrameContainer.endLayout();
		}
	}

	@Override
	protected String getGuiPngName() {
		return layout.getGuiTextureName();
	}
}
