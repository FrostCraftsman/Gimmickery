package net.frostcraftsman.gimmickery.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


/**
 * 自定义容器方块的基类
 */
public abstract class GimmickeryBlockContainerBase extends BlockContainer{

	/**
	 * @param par2Material 方块使用的逻辑材质类
	 */ GimmickeryBlockContainerBase(int id, Material par2Material) {
		super(id, par2Material);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 待修改！请@冰音琉 尽快修改此方法与GimmickeryBlockBase
	 * 的stb方法一样并以新的方式正确注册其本地语言名称
	 * 
	 * 最后记得帮我把注释改过来w
	 */
	public void stb(String par1Str,String par2Str){
		if(par1Str != ""){
			this.setUnlocalizedName(par1Str);
			this.setTextureName("gimmickery:" + par1Str);
			LanguageRegistry.addName(this, par2Str);
			GameRegistry.registerBlock(this, par1Str);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
}
