package com.gamearoo.extraframes;

import java.util.List;

import com.clussmanproductions.trafficcontrol.ModBlocks;
import com.clussmanproductions.trafficcontrol.blocks.BlockBaseTrafficLight;
import com.clussmanproductions.trafficcontrol.gui.BaseTrafficLightFrameContainer.FrameSlotInfo;
import com.clussmanproductions.trafficcontrol.gui.BaseTrafficLightFrameContainer.FrameSlotInfo.EnumCheckboxOrientation;
import com.clussmanproductions.trafficcontrol.gui.SlotItemHandlerListenable;
import com.google.common.collect.ImmutableList;

import net.minecraftforge.items.IItemHandler;

/**
 * Mirrors Traffic Control frame types: bulb counts, target block, GUI texture, and slot layout.
 */
public enum FrameLayout {

	STANDARD_3("3", 174, 200, "traffic_light_frame_gui.png") {
		@Override
		public BlockBaseTrafficLight getBlock() {
			return ModBlocks.traffic_light;
		}

		@Override
		public int getBulbCount() {
			return 3;
		}

		@Override
		public List<FrameSlotInfo> buildSlots(IItemHandler h) {
			return ImmutableList.of(
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 0, 79, 13)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 1, 79, 44)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 2, 79, 76)));
		}
	},
	ONE("1", 174, 200, "traffic_light_1_frame_gui.png") {
		@Override
		public BlockBaseTrafficLight getBlock() {
			return ModBlocks.traffic_light_1;
		}

		@Override
		public int getBulbCount() {
			return 1;
		}

		@Override
		public List<FrameSlotInfo> buildSlots(IItemHandler h) {
			return ImmutableList.of(
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 0, 79, 44)));
		}
	},
	TWO("2", 174, 200, "traffic_light_2_frame_gui.png") {
		@Override
		public BlockBaseTrafficLight getBlock() {
			return ModBlocks.traffic_light_2;
		}

		@Override
		public int getBulbCount() {
			return 2;
		}

		@Override
		public List<FrameSlotInfo> buildSlots(IItemHandler h) {
			return ImmutableList.of(
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 0, 79, 13)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 1, 79, 44)));
		}
	},
	FOUR("4", 174, 263, "traffic_light_4_frame_gui.png") {
		@Override
		public BlockBaseTrafficLight getBlock() {
			return ModBlocks.traffic_light_4;
		}

		@Override
		public int getBulbCount() {
			return 4;
		}

		@Override
		public List<FrameSlotInfo> buildSlots(IItemHandler h) {
			return ImmutableList.of(
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 0, 79, 44)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 1, 79, 75)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 2, 79, 106)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 3, 79, 139)));
		}
	},
	FIVE("5", 174, 263, "traffic_light_5_frame_gui.png") {
		@Override
		public BlockBaseTrafficLight getBlock() {
			return ModBlocks.traffic_light_5;
		}

		@Override
		public int getBulbCount() {
			return 5;
		}

		@Override
		public List<FrameSlotInfo> buildSlots(IItemHandler h) {
			return ImmutableList.of(
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 0, 79, 12)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 1, 79, 44)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 2, 79, 76)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 3, 79, 107)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 4, 79, 139)));
		}
	},
	SIX_STYLE("6", 174, 210, "traffic_light_6_frame_gui.png") {
		@Override
		public BlockBaseTrafficLight getBlock() {
			return ModBlocks.traffic_light_6;
		}

		@Override
		public int getBulbCount() {
			return 4;
		}

		@Override
		public List<FrameSlotInfo> buildSlots(IItemHandler h) {
			return ImmutableList.of(
					new FrameSlotInfo(EnumCheckboxOrientation.LEFT, new SlotItemHandlerListenable(h, 0, 59, 11)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 1, 110, 11)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 2, 83, 52)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 3, 83, 95)));
		}
	},
	DOGHOUSE("doghouse", 174, 210, "traffic_light_doghouse_frame_gui.png") {
		@Override
		public BlockBaseTrafficLight getBlock() {
			return ModBlocks.traffic_light_doghouse;
		}

		@Override
		public int getBulbCount() {
			return 5;
		}

		@Override
		public List<FrameSlotInfo> buildSlots(IItemHandler h) {
			return ImmutableList.of(
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 0, 79, 10)),
					new FrameSlotInfo(EnumCheckboxOrientation.LEFT, new SlotItemHandlerListenable(h, 1, 48, 54)),
					new FrameSlotInfo(EnumCheckboxOrientation.LEFT, new SlotItemHandlerListenable(h, 2, 48, 86)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 3, 110, 54)),
					new FrameSlotInfo(EnumCheckboxOrientation.RIGHT, new SlotItemHandlerListenable(h, 4, 110, 86)));
		}
	};

	private final String registrySuffix;
	private final int xSize;
	private final int ySize;
	private final String guiTextureName;

	FrameLayout(String registrySuffix, int xSize, int ySize, String guiTextureName) {
		this.registrySuffix = registrySuffix;
		this.xSize = xSize;
		this.ySize = ySize;
		this.guiTextureName = guiTextureName;
	}

	public String getRegistrySuffix() {
		return registrySuffix;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
	}

	public String getGuiTextureName() {
		return guiTextureName;
	}

	public abstract BlockBaseTrafficLight getBlock();

	public abstract int getBulbCount();

	public abstract List<FrameSlotInfo> buildSlots(IItemHandler frameStackHandler);
}
