package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemIronMagicSkinG extends GimmickeryItemBase
{

	public ItemIronMagicSkinG(int id) 
	{
		super(id);
		this.st("IronMagicSkin");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//设置最大堆叠数为64
	}


}
