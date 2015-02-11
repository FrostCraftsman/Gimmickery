package net.frostcraftsman.gimmickery.registry;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.block.*;
import net.frostcraftsman.gimmickery.configration.GimmickeryConfiger;
import net.minecraft.block.material.Material;


/**
 * 注册方块的类
 */
public class GimmickeryBlocks 
{

	public static BlockPowerSourceG PowerSourceBlock;
	public static BlockBuildingSignal BuildingSignal;

	public static void init() {
		PowerSourceBlock = new BlockPowerSourceG(Gimmickery.CORE_CONFIG.GetBlockID("Block_Cristal", 3500), Material.glass);
		BuildingSignal = new BlockBuildingSignal(Gimmickery.CORE_CONFIG.GetBlockID("Block_Cristal", 3501), Material.glass);
	}
}