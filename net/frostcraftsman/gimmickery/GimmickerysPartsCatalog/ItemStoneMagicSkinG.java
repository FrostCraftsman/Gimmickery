package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemStoneMagicSkinG extends GimmickeryItemBase
{

	public ItemStoneMagicSkinG(int id) 
	{
		super(id);
		this.st("StoneMagicSkin");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//设置最大堆叠数为64
	}



}
