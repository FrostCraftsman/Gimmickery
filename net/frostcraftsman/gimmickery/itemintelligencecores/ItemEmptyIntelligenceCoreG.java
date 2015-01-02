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
		this.setMaxStackSize(64);//设置最大堆叠数为64
	}

}
