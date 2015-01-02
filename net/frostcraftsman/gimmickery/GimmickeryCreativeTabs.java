package net.frostcraftsman.gimmickery;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class GimmickeryCreativeTabs extends CreativeTabs{

	/**
     * @param label Tab栏的名称
     */
	public GimmickeryCreativeTabs(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Block.pumpkin.blockID;
	}


}
