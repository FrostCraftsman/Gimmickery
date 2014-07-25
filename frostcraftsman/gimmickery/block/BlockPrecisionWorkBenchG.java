package net.frostcraftsman.gimmickery.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostcraftsman.gimmickery.Gimmickery;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockPrecisionWorkBenchG extends GimmickeryBlockBase{

	@SideOnly(Side.CLIENT)
    private Icon PrecisionWorkBenchIconTop;
    @SideOnly(Side.CLIENT)
    private Icon PrecisionWorkBenchIconFront;
	
	public BlockPrecisionWorkBenchG(int id, Material par2Material) {
		super(id, par2Material);
		this.stb("PrecisionWorkBench", "���ܹ���̨");
		this.setHardness(1.5f); //��ʡ��
		this.setResistance(10.0f); //��ʡ��
		this.setLightValue(0.625f); //��ʡ��
		this.setStepSound(Block.soundStoneFootstep); //��ʡ��
		this.setCreativeTab(Gimmickery.gct); //��ʡ��
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.PrecisionWorkBenchIconTop : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.PrecisionWorkBenchIconFront));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName() + "_side");
        this.PrecisionWorkBenchIconTop = par1IconRegister.registerIcon(this.getTextureName() + "_top");
        this.PrecisionWorkBenchIconFront = par1IconRegister.registerIcon(this.getTextureName() + "_front");
    }
}
