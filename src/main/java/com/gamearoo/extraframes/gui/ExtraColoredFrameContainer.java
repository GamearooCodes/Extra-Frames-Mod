package com.gamearoo.extraframes.gui;

import java.util.List;

import com.clussmanproductions.trafficcontrol.ModItems;
import com.clussmanproductions.trafficcontrol.gui.BaseTrafficLightFrameContainer;
import com.clussmanproductions.trafficcontrol.item.BaseItemTrafficLightFrame;
import com.gamearoo.extraframes.FrameLayout;
import com.gamearoo.extraframes.item.ItemExtraColoredTrafficLightFrame;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class ExtraColoredFrameContainer extends BaseTrafficLightFrameContainer {

	/**
	 * BaseTrafficLightFrameContainer's constructor calls {@link #getYSize()} and
	 * {@link #getItemSlots} before a subclass could assign fields. Call {@link #beginLayout}
	 * immediately before {@code new ExtraColoredFrameContainer(...)}, then {@link #endLayout}
	 * in a {@code finally} block (see {@link ExtraFramesGuiHandler} and
	 * {@link ExtraColoredFrameGui}).
	 */
	private static final ThreadLocal<FrameLayout> LAYOUT_PENDING = new ThreadLocal<>();

	private final FrameLayout layout;

	public static void beginLayout(FrameLayout layout) {
		LAYOUT_PENDING.set(layout);
	}

	public static void endLayout() {
		LAYOUT_PENDING.remove();
	}

	public ExtraColoredFrameContainer(InventoryPlayer inventory, ItemStack frameStack) {
		super(inventory, frameStack);
		this.layout = LAYOUT_PENDING.get();
		if (this.layout == null) {
			throw new IllegalStateException("Call ExtraColoredFrameContainer.beginLayout before constructing.");
		}
	}

	private FrameLayout activeLayout() {
		return layout != null ? layout : LAYOUT_PENDING.get();
	}

	@Override
	protected List<FrameSlotInfo> getItemSlots(IItemHandler frameStackHandler) {
		return activeLayout().buildSlots(frameStackHandler);
	}

	@Override
	protected BaseItemTrafficLightFrame getValidFrameItem() {
		return ModItems.traffic_light_frame;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return playerIn.getHeldItemMainhand().getItem() instanceof ItemExtraColoredTrafficLightFrame;
	}

	@Override
	protected int getYSize() {
		return activeLayout().getYSize();
	}
}
