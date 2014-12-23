package net.frostcraftsman.gimmickery.item;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemWoodKarakuriNingyG extends GimmickeryItemBase{

	public ItemWoodKarakuriNingyG(int id) {
		super(id);
		this.st("WoodKarakuriNingy");
		this.setCreativeTab(Gimmickery.gct);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer)
	{		
		int EntityPosZ = MathHelper.floor_double(par3EntityPlayer.posZ);
		if(EntityPosZ<0)
		{	
			EntityPosZ+=4;
		}
		else
		{
			EntityPosZ+=-4;
		}
		
		if(!par2World.isRemote)
		{
		EntityWoodKarakuriNingyG entity = new EntityWoodKarakuriNingyG(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY+1, EntityPosZ, par3EntityPlayer);
		par2World.spawnEntityInWorld(entity);
		}		
		
		System.out.println("玩家坐标："+"X："+par3EntityPlayer.posX+"，Y："+par3EntityPlayer.posY+"，Z："+par3EntityPlayer.posZ);
		System.out.println("人偶坐标："+"X："+par3EntityPlayer.posX+"，Y："+par3EntityPlayer.posY+1+"，Z："+EntityPosZ);
		return par1ItemStack;
    }
}
