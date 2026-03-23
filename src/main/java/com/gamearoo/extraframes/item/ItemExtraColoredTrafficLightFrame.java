package com.gamearoo.extraframes.item;

import java.util.HashMap;
import java.util.List;

import com.clussmanproductions.trafficcontrol.blocks.BlockBaseTrafficLight;
import com.clussmanproductions.trafficcontrol.item.BaseItemTrafficLightFrame;
import com.clussmanproductions.trafficcontrol.tileentity.BaseTrafficLightTileEntity;
import com.clussmanproductions.trafficcontrol.util.CustomAngleCalculator;
import com.clussmanproductions.trafficcontrol.util.EnumTrafficLightBulbTypes;
import com.gamearoo.extraframes.ExtraFrameTileData;
import com.gamearoo.extraframes.ExtraFramesMod;
import com.gamearoo.extraframes.FrameLayout;
import com.gamearoo.extraframes.gui.ExtraFramesGuiHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemExtraColoredTrafficLightFrame extends BaseItemTrafficLightFrame {

	private final FrameLayout layout;
	private final EnumDyeColor dyeColor;

	public ItemExtraColoredTrafficLightFrame(FrameLayout layout, EnumDyeColor color) {
		super("extra_frame_" + layout.getRegistrySuffix() + "_" + color.getName());
		this.layout = layout;
		this.dyeColor = color;
		setUnlocalizedName(ExtraFramesMod.MODID + ".extra_frame." + layout.getRegistrySuffix() + "." + color.getName());
	}

	public FrameLayout getLayout() {
		return layout;
	}

	public EnumDyeColor getDyeColor() {
		return dyeColor;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0,
				new ModelResourceLocation(ExtraFramesMod.MODID + ":extra_frame_" + layout.getRegistrySuffix(), "inventory"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.openGui(ExtraFramesMod.instance, ExtraFramesGuiHandler.GUI_EXTRA_COLORED_FRAME, worldIn, 0, 0, 0);
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	@Override
	protected int getGuiID() {
		return ExtraFramesGuiHandler.GUI_EXTRA_COLORED_FRAME;
	}

	@Override
	public int getBulbCount() {
		return layout.getBulbCount();
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		IItemHandler handler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for (int i = 0; i < layout.getBulbCount(); i++) {
			ItemStack sub = handler.getStackInSlot(i);
			if (sub != ItemStack.EMPTY) {
				tooltip.add("Slot " + (i + 1) + ": " + sub.getItem().getItemStackDisplayName(sub));
			}
		}
	}

	@Override
	protected BlockBaseTrafficLight getBaseBlockTrafficLight() {
		return layout.getBlock();
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return EnumActionResult.SUCCESS;
		}

		BlockPos placePos = pos;
		if (!worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos)) {
			placePos = pos.offset(facing);
		}

		worldIn.setBlockState(placePos,
				getBaseBlockTrafficLight().getDefaultState().withProperty(BlockBaseTrafficLight.ROTATION,
						CustomAngleCalculator.getRotationForYaw(player.rotationYaw)));
		TileEntity tileEntity = worldIn.getTileEntity(placePos);
		if (!(tileEntity instanceof BaseTrafficLightTileEntity)) {
			return EnumActionResult.FAIL;
		}
		BaseTrafficLightTileEntity trafficLight = (BaseTrafficLightTileEntity) tileEntity;

		int bulbCount = getBulbCount();
		ItemStack heldItem = player.getHeldItem(hand);
		HashMap<Integer, EnumTrafficLightBulbTypes> bulbsBySlot = new HashMap<>(bulbCount);
		IItemHandler handler = heldItem.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		HashMap<Integer, Boolean> allowFlashBySlot = new HashMap<>();

		for (int i = 0; i < bulbCount; i++) {
			ItemStack bulbTypeInSlot = handler.getStackInSlot(i);
			if (bulbTypeInSlot == ItemStack.EMPTY) {
				bulbsBySlot.put(i, null);
			} else {
				bulbsBySlot.put(i, EnumTrafficLightBulbTypes.get(bulbTypeInSlot.getMetadata()));
			}
			allowFlashBySlot.put(i, getAlwaysFlash(heldItem, i));
		}

		trafficLight.setBulbsBySlot(bulbsBySlot);
		trafficLight.setAllowFlashBySlot(allowFlashBySlot);

		NBTTagCompound data = trafficLight.getTileData();
		data.setByte(ExtraFrameTileData.NBT_KEY, (byte) dyeColor.getMetadata());
		trafficLight.markDirty();
		IBlockState state = worldIn.getBlockState(placePos);
		worldIn.notifyBlockUpdate(placePos, state, state, 3);

		player.getHeldItemMainhand().shrink(1);
		return EnumActionResult.SUCCESS;
	}
}
