package net.frostcraftsman.gimmickery;

import java.util.Map;
import java.util.logging.Logger;

import net.frostcraftsman.gimmickery.block.BlockPowerSourceG;
import net.frostcraftsman.gimmickery.entity.EntityPrinnyBlue;
import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.frostcraftsman.gimmickery.proxy.GimmickeryCommonProxy;
import net.frostcraftsman.gimmickery.registry.GimmickeryBlocks;
import net.frostcraftsman.gimmickery.registry.GimmickeryItems;
import net.frostcraftsman.gimmickery.render.RenderWoodKarakuriNingyG;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelPig;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="gimmickery", name="Gimmickery", version=Gimmickery.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Gimmickery {
	
	public static final String VERSION = "0.0.1";
	public static Logger log = Logger.getLogger("gimmickery");
	public static CreativeTabs gct = new GimmickeryCreativeTabs("Gimmickery");
	
	@Instance("gimmickery")
    public static Gimmickery instance;
	
	@SidedProxy(
            clientSide = "net.frostcraftsman.gimmickery.proxy.GimmickeryClientProxy",
            serverSide = "net.frostcraftsman.gimmickery.proxy.GimmickeryCommonProxy"
    )
    public static GimmickeryCommonProxy proxy;
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		 log.setParent(FMLLog.getLogger());
	     log.info("Starting Gimmickery " + Gimmickery.VERSION);
	     
	     GimmickeryItems.init();
	     GimmickeryBlocks.init();
	     proxy.preInit();
	}
	 
	@EventHandler
	public void load(FMLInitializationEvent event)
	{	
		 int id = 0;
	     EntityRegistry.registerModEntity(EntityWoodKarakuriNingyG.class, "WoodKarakuriNingy", id, this, 80, 1, true);//id is an internal mob id, you can start at 0 and continue adding them up.
	     id++;
	     EntityRegistry.registerModEntity(EntityPrinnyBlue.class, "PrinnyBlue", id, this, 80, 1, true);//id is an internal mob id, you can start at 0 and continue adding them up.
		 id++;
	     //EntityRegistry.addSpawn(EntityWoodKarakuriNingyG.class, 10, 4, 4, EnumCreatureType.monster);
		 proxy.init();
		 proxy.registerRenderThings();//calls the methods in our proxy, which will do things on client side
	     proxy.registerSound();
	     GameRegistry.addRecipe(new ItemStack(GimmickeryBlocks.PowerSourceBlock, 1), new Object[]{"XYX",Character.valueOf('X'),Item.ingotGold,Character.valueOf('Y'),Block.blockDiamond});
	     GameRegistry.addRecipe(new ItemStack(GimmickeryItems.WoodKarakuriNingy, 1), new Object[]{"ABA", "CDC","CCC",'A',Item.redstone,'B',GimmickeryItems.ElementaryMagicLubeOil, 'C',GimmickeryItems.WoodMagicSkin, 'D',GimmickeryItems.WoodSkeletonFrame });
	     GameRegistry.addRecipe(new ItemStack(GimmickeryItems.WoodSkeletonFrame, 1), new Object[]{"ABA", "BCB","ABA",'A',GimmickeryItems.ElementaryMagicLubeOil ,'B',GimmickeryItems.WoodWheelGear ,'C', Item.redstone});
	     GameRegistry.addRecipe(new ItemStack(GimmickeryItems.EmptyIntelligenceCore,1), new Object[]{" A ", "A A", " A ",'A',Block.glass});
	     GameRegistry.addRecipe(new ItemStack(GimmickeryItems.IntelligenceCoreAttack,1), new Object[]{" A ", "ABA", " A ",'A',Block.glass,'B',GimmickeryItems.SoulAttack}); 
	}
	 
	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		 proxy.postInit();
	}
}
