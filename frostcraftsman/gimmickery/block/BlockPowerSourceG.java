package net.frostcraftsman.gimmickery.block;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProps;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class BlockPowerSourceG extends GimmickeryBlockBase{

	public BlockPowerSourceG(int id, Material par2Material) {
		super(id, par2Material);
		this.stb("PowerSourceBlock", "��Դ����");
		this.setHardness(1.5f); //��ʡ��
		this.setResistance(10.0f); //��ʡ��
		this.setLightValue(0.0f); //��ʡ��
		this.setStepSound(Block.soundStoneFootstep); //��ʡ��
		this.setCreativeTab(Gimmickery.gct); //��ʡ��
		// TODO Auto-generated constructor stub
		this.setBlockBounds(0F, 0F, 0F, 1F, 2F, 1F);
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }

	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	public int getRenderType()
    {
        return GimmickeryClientProps.RENDER_MUILTY_FACE_BLOCK;
    }
	
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
        return false;
    }
}
