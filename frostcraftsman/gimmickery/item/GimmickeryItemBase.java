package net.frostcraftsman.gimmickery.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;


/**
 * 自定义物品的基类
 */
public class GimmickeryItemBase extends Item{

	public GimmickeryItemBase(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 快捷设定内部逻辑名称的方法
	 * @param par1Str 内部逻辑名称 
	 */
	public void st(String par1Str) {
		if(par1Str != " ") {
			this.setUnlocalizedName(par1Str);
			this.setTextureName("gimmickery:" + par1Str);
		}
	}
}
