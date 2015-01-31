package net.frostcraftsman.gimmickery.EntityAI;

import net.minecraft.entity.player.EntityPlayer;

public class EntityGetUserAI {

	public EntityPlayer player;
	public EntityGetUserAI()
	{
		
	}
	
	public EntityPlayer entitySetUser(EntityPlayer entityplayer)
	{
		 player=entityplayer;
		 return player;
	}
	
	public EntityPlayer entityGetUser()
	{
		return player;
	}
}
