package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemGoldMagicSkinG extends GimmickeryItemBase
{

	public ItemGoldMagicSkinG(int id) 
	{
		super(id);
		this.st("GoldMagicSkin");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//设置最大堆叠数为64
		// TODO Auto-generated constructor stub
	}

}
