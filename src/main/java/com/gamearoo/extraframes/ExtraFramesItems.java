package com.gamearoo.extraframes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gamearoo.extraframes.item.ItemExtraColoredTrafficLightFrame;

public final class ExtraFramesItems {

	public static final List<ItemExtraColoredTrafficLightFrame> ALL_COLORED_FRAMES = new ArrayList<>();

	private ExtraFramesItems() {
	}

	public static List<ItemExtraColoredTrafficLightFrame> getAllColoredFrames() {
		return Collections.unmodifiableList(ALL_COLORED_FRAMES);
	}
}
