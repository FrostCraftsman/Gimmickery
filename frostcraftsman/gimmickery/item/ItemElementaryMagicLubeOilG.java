package net.frostcraftsman.gimmickery.item;

import net.frostcraftsman.gimmickery.Gimmickery;

public class ItemElementaryMagicLubeOilG extends GimmickeryItemBase
{

	public ItemElementaryMagicLubeOilG(int id) 
	{
		super(id);
		this.st("ElementaryMagicLubeOil");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//设置最大堆叠数为64
	}

}
