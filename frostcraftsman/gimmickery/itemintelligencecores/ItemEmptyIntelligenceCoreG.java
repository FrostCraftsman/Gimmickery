package net.frostcraftsman.gimmickery.itemintelligencecores;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemEmptyIntelligenceCoreG extends GimmickeryItemBase
{

	public ItemEmptyIntelligenceCoreG(int id) 
	{
		super(id);
		this.st("EmptyIntelligenceCore");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//���ѵ�Ĭ��64����ʡ��
	}

}
