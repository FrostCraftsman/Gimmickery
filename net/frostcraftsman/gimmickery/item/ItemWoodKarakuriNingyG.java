package net.frostcraftsman.gimmickery.item;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.EntityAI.EntityGetUserAI;
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
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {

		if(!par3World.isRemote)
		{
		  EntityGetUserAI EntityGetUserAI = new EntityGetUserAI();	
		  EntityWoodKarakuriNingyG entity = new EntityWoodKarakuriNingyG(par3World, par4, par5+1, par6, par2EntityPlayer);
		  EntityGetUserAI.entitySetUser(par2EntityPlayer);
		  par3World.spawnEntityInWorld(entity);
		}		
		
		return true;
	}
}
