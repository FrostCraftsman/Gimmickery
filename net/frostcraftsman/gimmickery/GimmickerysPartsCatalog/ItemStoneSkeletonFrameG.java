package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemStoneSkeletonFrameG extends GimmickeryItemBase
{

	public ItemStoneSkeletonFrameG(int id) 
	{
		super(id);
		this.st("StoneSkeletonFrame");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);
	}

}
