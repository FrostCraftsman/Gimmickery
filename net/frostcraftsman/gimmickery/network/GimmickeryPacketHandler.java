package net.frostcraftsman.gimmickery.network;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProxy;
import net.frostcraftsman.gimmickery.proxy.GimmickeryCommonProxy;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class GimmickeryPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
	    try
	    {
	        //首先装换Packet250CustomPayload到我们自己的封包
	        Gimmickery250Packet pkt = Gimmickery250Packet.parse(packet.data);
	        if(player instanceof EntityPlayerMP)
	        {
	            //如果player参数是EntityPlayerMP的实例，那么调用handlePacketFromClient方法
	            GimmickeryCommonProxy.handlePacketFromClient(pkt, (EntityPlayerMP)player);
	        }
	        else
	        {
	            //反之调用handlePacketFromServer方法
	            GimmickeryClientProxy.handlePacketFromServer(pkt);
	        }
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}

}
