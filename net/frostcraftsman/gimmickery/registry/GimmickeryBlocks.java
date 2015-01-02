package net.frostcraftsman.gimmickery.registry;

import net.frostcraftsman.gimmickery.block.*;
import net.frostcraftsman.gimmickery.configration.GimmickeryConfiger;
import net.minecraft.block.material.Material;


/**
 * 注册方块的类
 */
public class GimmickeryBlocks 
{

	public static BlockPowerSourceG PowerSourceBlock;

	public static void init() {
		int id = 3500;
		try {
			id=GimmickeryConfiger.GetBlockID("Block_Cristal", 3500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PowerSourceBlock = new BlockPowerSourceG(id, Material.glass);
	}
}