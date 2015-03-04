package net.frostcraftsman.gimmickery.item;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.entity.EntityFrostDoll;
import net.frostcraftsman.gimmickery.entity.EntityPrinnyBlue;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFrostDoll extends Item{

	public ItemFrostDoll(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(Gimmickery.gct);
		// TODO Auto-generated constructor stub
	}
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		if(!par3World.isRemote){
			EntityFrostDoll frostdoll = new EntityFrostDoll(par3World, (float)par4, (float)par5 ,(float)par6, par2EntityPlayer);
			 par3World.spawnEntityInWorld(frostdoll);
		}
		return true;
		
		
	}
	}


