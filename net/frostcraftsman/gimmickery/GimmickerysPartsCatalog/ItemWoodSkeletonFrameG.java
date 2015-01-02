package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemWoodSkeletonFrameG extends GimmickeryItemBase
{

	public ItemWoodSkeletonFrameG(int id) 
	{
		super(id);
		this.st("WoodSkeletonFrame");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);
	}

}
