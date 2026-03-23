package com.gamearoo.extraframes.proxy;

import com.clussmanproductions.trafficcontrol.ModBlocks;
import com.gamearoo.extraframes.ExtraFrameTileData;
import com.gamearoo.extraframes.ExtraFramesItems;
import com.gamearoo.extraframes.item.ItemExtraColoredTrafficLightFrame;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		Minecraft mc = Minecraft.getMinecraft();
		// Single-layer TC item icons (multiply tint on dark metal: light dyes read darker than the palette).
		// Avoid a second "white_textured" layer on top — it draws above the frame and replaces it with a flat square.
		mc.getItemColors().registerItemColorHandler(
				(ItemStack stack, int tintIndex) -> {
					if (stack.getItem() instanceof ItemExtraColoredTrafficLightFrame) {
						return ((ItemExtraColoredTrafficLightFrame) stack.getItem()).getDyeColor().getColorValue();
					}
					return 0xFFFFFF;
				},
				ExtraFramesItems.ALL_COLORED_FRAMES.toArray(new ItemExtraColoredTrafficLightFrame[0]));

		// Backing / blinders use tintindex 0 + frame_tint_base in patched trafficcontrol:block models.
		// No ExtraFramesDye => black multiply (default Traffic Control look). With dye => vanilla dye RGB.
		mc.getBlockColors().registerBlockColorHandler(
				(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex) -> {
					if (tintIndex != 0) {
						return 0xFFFFFF;
					}
					if (world == null || pos == null) {
						return 0x000000;
					}
					TileEntity te = world.getTileEntity(pos);
					if (te == null) {
						return 0x000000;
					}
					NBTTagCompound data = te.getTileData();
					if (!data.hasKey(ExtraFrameTileData.NBT_KEY, 1)) {
						return 0x000000;
					}
					int meta = data.getByte(ExtraFrameTileData.NBT_KEY) & 15;
					return EnumDyeColor.byMetadata(meta).getColorValue();
				},
				ModBlocks.traffic_light,
				ModBlocks.traffic_light_1,
				ModBlocks.traffic_light_2,
				ModBlocks.traffic_light_4,
				ModBlocks.traffic_light_5,
				ModBlocks.traffic_light_6,
				ModBlocks.traffic_light_doghouse);
	}
}
