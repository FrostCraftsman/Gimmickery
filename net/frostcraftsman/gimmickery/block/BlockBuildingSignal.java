package net.frostcraftsman.gimmickery.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.frostcraftsman.gimmickery.Gimmickery;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockBuildingSignal extends GimmickeryBlockContainerBase{

	public BlockBuildingSignal(int par1, Material par2Material) {
		super(par1, par2Material);
		this.stb("BlockBuildingSignal", "工匠信标");
		this.setCreativeTab(Gimmickery.gct);
		this.setTextureName("gimmickery:BlockBuildingSignal");
		this.setBlockBounds(0F, 0F, 0F, 1F, 2F, 1F);
		this.setLightOpacity(0);
		this.setLightValue(1.0F);
	}

	public static void onBlockAdded(World worldObj, double posX, double posY,
			double posZ) {
		// TODO 自动生成的方法存根
		
	}
}
