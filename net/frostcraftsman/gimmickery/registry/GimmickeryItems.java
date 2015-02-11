package net.frostcraftsman.gimmickery.registry;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.GimmickerysPartsCatalog.*;
import net.frostcraftsman.gimmickery.item.*;
import net.frostcraftsman.gimmickery.itemintelligencecores.*;
import net.frostcraftsman.gimmickery.souls.*;

/**
 * 注册物品的类
 */
public class GimmickeryItems 
{
	public static ItemWoodKarakuriNingyG WoodKarakuriNingy;
	public static ItemWoodWheelGearG WoodWheelGear;
	public static ItemWoodSkeletonFrameG WoodSkeletonFrame;
	public static ItemWoodMagicSkinG WoodMagicSkin;
	public static ItemStoneWheelGearG StoneWheelGear;
	public static ItemStoneSkeletonFrameG StoneSkeletonFrame;
	public static ItemStoneMagicSkinG StoneMagicSkin;
	public static ItemIronWheelGearG IronWheelGear;
	public static ItemIronSkeletonFrameG IronSkeletonFrame;
	public static ItemIronMagicSkinG IronMagicSkin;
	public static ItemGoldWheelGearG GoldWheelGear;
	public static ItemGoldSkeletonFrameG GoldSkeletonFrame;
	public static ItemGoldMagicSkinG GoldMagicSkin;
	public static ItemDiamondWheelGearG DiamondWheelGear;
	public static ItemDiamondSkeletonFrameG DiamondSkeletonFrame;
	public static ItemDiamondMagicSkinG DiamondMagicSkin;
	public static ItemEmptyIntelligenceCoreG EmptyIntelligenceCore;
	public static ItemIntelligenceCoreAttackG IntelligenceCoreAttack;
	public static ItemElementaryMagicLubeOilG ElementaryMagicLubeOil;
	public static SoulAttackG SoulAttack;
	public static ItemPrinnyBlue PrinnyBlue;
	
	public static void init() 
	{
		WoodWheelGear = new ItemWoodWheelGearG(Gimmickery.CORE_CONFIG.GetItemID("WoodWheelGear", 7000));
		WoodSkeletonFrame = new ItemWoodSkeletonFrameG(Gimmickery.CORE_CONFIG.GetItemID("WoodWheelGear",7001));
		WoodMagicSkin = new ItemWoodMagicSkinG(Gimmickery.CORE_CONFIG.GetItemID("WoodMagicSkin",7002));
		StoneWheelGear = new ItemStoneWheelGearG(Gimmickery.CORE_CONFIG.GetItemID("StoneWheelGear",7003));
		StoneSkeletonFrame = new ItemStoneSkeletonFrameG(Gimmickery.CORE_CONFIG.GetItemID("StoneSkeletonFrame",7004));
		StoneMagicSkin = new ItemStoneMagicSkinG(Gimmickery.CORE_CONFIG.GetItemID("StoneMagicSkin",7005));
		IronWheelGear = new ItemIronWheelGearG(Gimmickery.CORE_CONFIG.GetItemID("IronWheelGear", 7006));
		IronSkeletonFrame = new ItemIronSkeletonFrameG(Gimmickery.CORE_CONFIG.GetItemID("IronSkeletonFrame",7007));
		IronMagicSkin = new ItemIronMagicSkinG(Gimmickery.CORE_CONFIG.GetItemID("IronMagicSkin",7008));
		GoldWheelGear = new ItemGoldWheelGearG(Gimmickery.CORE_CONFIG.GetItemID("GoldWheelGear", 7009));
		GoldSkeletonFrame = new ItemGoldSkeletonFrameG(Gimmickery.CORE_CONFIG.GetItemID("GoldSkeletonFrame",7010));
		GoldMagicSkin = new ItemGoldMagicSkinG(Gimmickery.CORE_CONFIG.GetItemID("GoldMagicSkin",7011));
		DiamondWheelGear = new ItemDiamondWheelGearG(Gimmickery.CORE_CONFIG.GetItemID("DiamondWheelGear", 7012));
		DiamondSkeletonFrame = new ItemDiamondSkeletonFrameG(Gimmickery.CORE_CONFIG.GetItemID("DiamondSkeletonFrame",7013));
		DiamondMagicSkin = new ItemDiamondMagicSkinG(Gimmickery.CORE_CONFIG.GetItemID("DiamondMagicSkin",7014));
		EmptyIntelligenceCore = new ItemEmptyIntelligenceCoreG(Gimmickery.CORE_CONFIG.GetItemID("EmptyIntelligenceCore",7015));
		IntelligenceCoreAttack = new ItemIntelligenceCoreAttackG(Gimmickery.CORE_CONFIG.GetItemID("IntelligenceCoreAttack",7016));
		SoulAttack = new SoulAttackG(Gimmickery.CORE_CONFIG.GetItemID("SoulAttack",7017));
		ElementaryMagicLubeOil = new ItemElementaryMagicLubeOilG(Gimmickery.CORE_CONFIG.GetItemID("ElementaryMagicLubeOil",7018));
		WoodKarakuriNingy = new ItemWoodKarakuriNingyG(Gimmickery.CORE_CONFIG.GetItemID("WoodKarakuriNingy",7019));
		PrinnyBlue = new ItemPrinnyBlue(Gimmickery.CORE_CONFIG.GetItemID("PrinnyBlue",7020));
    }
}
