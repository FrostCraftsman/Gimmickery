package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemWoodMagicSkinG extends GimmickeryItemBase
{

	public ItemWoodMagicSkinG(int id) {
		super(id);
		this.st("WoodMagicSkin");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//���ѵ�Ĭ��64����ʡ��
	}

}
