package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemIronSkeletonFrameG extends GimmickeryItemBase
{

	public ItemIronSkeletonFrameG(int id) 
	{
		super(id);
		this.st("IronSkeletonFrame");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);
	}


}
