package net.frostcraftsman.gimmickery.proxy;

import net.frostcraftsman.gimmickery.RenderTickHandler;
import net.frostcraftsman.gimmickery.entity.EntityPrinnyBlue;
import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.frostcraftsman.gimmickery.event.KarakuriNingySoundEvent;
import net.frostcraftsman.gimmickery.event.PrinnyBlueSoundEvent;
import net.frostcraftsman.gimmickery.model.*;
import net.frostcraftsman.gimmickery.network.Gimmickery250Packet;
import net.frostcraftsman.gimmickery.render.*;
import net.frostcraftsman.gimmickery.tileentity.CristalTileEntity;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class GimmickeryClientProxy extends GimmickeryCommonProxy{

	public void preInit() {
        super.preInit();
    }
    
	public void init() 
	{
        super.init();
        RenderingRegistry.registerBlockHandler(new MuiltyFaceBlockInHandRenderer(new ModelCristal()));
        GameRegistry.registerTileEntity(CristalTileEntity.class, "TileEntityCristal");
    }
    
    public void postInit() {
        super.postInit();
    }
    
    @Override
    public void registerRenderThings() 
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityWoodKarakuriNingyG.class, new RenderWoodKarakuriNingyG(new ModelKarakuriNingyG(), 0.5F));//the 0.5F is the shadowsize            
    	RenderingRegistry.registerEntityRenderingHandler(EntityPrinnyBlue.class, new RenderPrinnyBlue(new ModelPrinnyBlue(), 0.5F));//the 0.5F is the shadowsize                    
    	ClientRegistry.bindTileEntitySpecialRenderer(CristalTileEntity.class, new CristalTileEntityRenderer());
    	//TickRegistry.registerTickHandler(new RenderTickHandler(), Side.CLIENT);
    }
    
    @Override
    public void registerSound() {
           MinecraftForge.EVENT_BUS.register(new KarakuriNingySoundEvent());//register the sound event handling class
           MinecraftForge.EVENT_BUS.register(new PrinnyBlueSoundEvent());//register the sound event handling class
    }
    
    public static void handlePacketFromServer(Gimmickery250Packet pkt){}
}
