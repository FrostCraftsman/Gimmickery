package net.frostcraftsman.gimmickery.proxy;

import java.util.HashSet;
import java.util.Set;

import net.frostcraftsman.gimmickery.network.Gimmickery250Packet;
import net.frostcraftsman.gimmickery.tileentity.CristalTileEntity;
import net.frostcraftsman.gimmickery.worlddatasaver.GimmickeryWorldDataSaver;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.LanguageRegistry;


/**
* ���ش��?Server�ˣ�
*/
public class GimmickeryCommonProxy {

	/**
	 * ִ�е�1�׶εļ�����Ϊ��
	 */
	public void preInit() {
	    	
	}
	    
	public static Set<String> languages = new HashSet(); 
	  
 	static { 
 		languages.add("zh_CN"); 
 		languages.add("en_US"); 
 	} 
 	 
 	public void init() { 
 		for (String lang : languages) { 
 			LanguageRegistry.instance().loadLocalization( 
 					"/assets/gimmickery/lang/" + lang + ".properties", lang, false); 
 		} 
 	} 
	    
	/**
	 *注释等待修复
	 */
	public void postInit() {
		
	}
	
	 public void registerRenderThings() {
     }
     
     public void registerSound() {
     }
     
     public static void handlePacketFromClient(Gimmickery250Packet packet, EntityPlayerMP player)
 	{
 	    switch(packet.packetType){
 	    case 0:
 	    	TileEntity t=player.worldObj.getBlockTileEntity(packet.dataInt[0], packet.dataInt[1], packet.dataInt[2]);
 	    	boolean bool=packet.dataBoolean[0];
 	    	if(t instanceof CristalTileEntity){
 	    		CristalTileEntity tile=(CristalTileEntity) t;
 	    		tile.isActive=bool;
 	    	}
 	    	if(bool){
 	    		GimmickeryWorldDataSaver.get(player.worldObj).CristalNumplu();
 	    	}else{
 	    		GimmickeryWorldDataSaver.get(player.worldObj).CristalNummin();
 	    	}
 	    	break;
 	    }
 	}

}

