package net.frostcraftsman.gimmickery.block;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
	}

}
