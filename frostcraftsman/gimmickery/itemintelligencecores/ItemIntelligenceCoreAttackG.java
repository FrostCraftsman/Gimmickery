package net.frostcraftsman.gimmickery.itemintelligencecores;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;

public class ItemIntelligenceCoreAttackG extends GimmickeryItemBase
{

	public ItemIntelligenceCoreAttackG(int id) 
	{
		super(id);
		this.st("IntelligenceCoreAttack");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//���ѵ�Ĭ��64����ʡ��
	}
}

