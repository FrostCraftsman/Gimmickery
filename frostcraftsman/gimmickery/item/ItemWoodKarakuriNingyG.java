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
		if(!par2World.isRemote)
		{
		EntityWoodKarakuriNingyG entity = new EntityWoodKarakuriNingyG(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + par3EntityPlayer.getEyeHeight(), par3EntityPlayer.posZ+2, par3EntityPlayer);
		par2World.spawnEntityInWorld(entity);
		}		
		return par1ItemStack;
    }
}
