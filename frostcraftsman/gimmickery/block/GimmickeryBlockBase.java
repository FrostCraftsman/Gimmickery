package net.frostcraftsman.gimmickery.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


/**
 * ���з���ĸ���
 */
public class GimmickeryBlockBase extends Block{

	/**
	 * @param par2Material �������
	 */
	public GimmickeryBlockBase(int id, Material par2Material) {
		super(id, par2Material);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ��ο�GimmickeryItemBase
	 * @param par1Str �ڲ���ƣ���ͼ�ļ���
	 * @param par2Str ��ʾ������
	 */
	public void stb(String par1Str){
		if(par1Str != ""){
			this.setUnlocalizedName(par1Str);
			this.setTextureName("gimmickery:" + par1Str);
			GameRegistry.registerBlock(this, par1Str);
		}
	}
}
