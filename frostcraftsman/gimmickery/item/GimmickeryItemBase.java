package net.frostcraftsman.gimmickery.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;


/**
 * ������Ʒ�ĸ���
 */
public class GimmickeryItemBase extends Item{

	public GimmickeryItemBase(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �����ڲ���ƣ���ʾ��Ʒ����ͼ
	 * @param par1Str �ڲ���ƺ���ͼ�����ü������� 
	 * @param par2Str ������ҿ�������� 
	 */
	public void st(String par1Str) {
		if(par1Str != " ") {
			this.setUnlocalizedName(par1Str);
			this.setTextureName("gimmickery:" + par1Str);
		}
	}
}
