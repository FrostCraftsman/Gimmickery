package net.frostcraftsman.gimmickery.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


/**
 * 自定义普通方块的基类
 */
public class GimmickeryBlockBase extends Block{

	/**
	 * @param par2Material 方块使用的逻辑材质类
	 */
	public GimmickeryBlockBase(int id, Material par2Material) {
		super(id, par2Material);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 快捷设定内部逻辑名称的方法
	 * @param par1Str 方块名称（内部逻辑名称）
	 */
	public void stb(String par1Str){
		if(par1Str != ""){
			this.setUnlocalizedName(par1Str);
			this.setTextureName("gimmickery:" + par1Str);
			GameRegistry.registerBlock(this, par1Str);
		}
	}
}
