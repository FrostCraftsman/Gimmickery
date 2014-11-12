package net.frostcraftsman.gimmickery.registry;

import net.frostcraftsman.gimmickery.GimmickerysPartsCatalog.*;
import net.frostcraftsman.gimmickery.GimmickerysPartsCatalog.ItemWoodWheelGearG;
import net.frostcraftsman.gimmickery.configration.GimmickeryConfiger;
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
		WoodWheelGear = new ItemWoodWheelGearG(GimmickeryConfiger.GetItemID("WoodWheelGear", 7000));
		WoodSkeletonFrame = new ItemWoodSkeletonFrameG(GimmickeryConfiger.GetItemID("WoodWheelGear",7001));
		WoodMagicSkin = new ItemWoodMagicSkinG(GimmickeryConfiger.GetItemID("WoodMagicSkin",7002));
		StoneWheelGear = new ItemStoneWheelGearG(GimmickeryConfiger.GetItemID("StoneWheelGear",7003));
		StoneSkeletonFrame = new ItemStoneSkeletonFrameG(GimmickeryConfiger.GetItemID("StoneSkeletonFrame",7004));
		StoneMagicSkin = new ItemStoneMagicSkinG(GimmickeryConfiger.GetItemID("StoneMagicSkin",7005));
		IronWheelGear = new ItemIronWheelGearG(GimmickeryConfiger.GetItemID("IronWheelGear", 7006));
		IronSkeletonFrame = new ItemIronSkeletonFrameG(GimmickeryConfiger.GetItemID("IronSkeletonFrame",7007));
		IronMagicSkin = new ItemIronMagicSkinG(GimmickeryConfiger.GetItemID("IronMagicSkin",7008));
		GoldWheelGear = new ItemGoldWheelGearG(GimmickeryConfiger.GetItemID("GoldWheelGear", 7009));
		GoldSkeletonFrame = new ItemGoldSkeletonFrameG(GimmickeryConfiger.GetItemID("GoldSkeletonFrame",7010));
		GoldMagicSkin = new ItemGoldMagicSkinG(GimmickeryConfiger.GetItemID("GoldMagicSkin",7011));
		DiamondWheelGear = new ItemDiamondWheelGearG(GimmickeryConfiger.GetItemID("DiamondWheelGear", 7012));
		DiamondSkeletonFrame = new ItemDiamondSkeletonFrameG(GimmickeryConfiger.GetItemID("DiamondSkeletonFrame",7013));
		DiamondMagicSkin = new ItemDiamondMagicSkinG(GimmickeryConfiger.GetItemID("DiamondMagicSkin",7014));
		EmptyIntelligenceCore = new ItemEmptyIntelligenceCoreG(GimmickeryConfiger.GetItemID("EmptyIntelligenceCore",7015));
		IntelligenceCoreAttack = new ItemIntelligenceCoreAttackG(GimmickeryConfiger.GetItemID("IntelligenceCoreAttack",7016));
		SoulAttack = new SoulAttackG(GimmickeryConfiger.GetItemID("SoulAttack",7017));
		ElementaryMagicLubeOil = new ItemElementaryMagicLubeOilG(GimmickeryConfiger.GetItemID("ElementaryMagicLubeOil",7018));
		WoodKarakuriNingy = new ItemWoodKarakuriNingyG(GimmickeryConfiger.GetItemID("WoodKarakuriNingy",7019));
		PrinnyBlue = new ItemPrinnyBlue(GimmickeryConfiger.GetItemID("PrinnyBlue",7020));
    }
}
