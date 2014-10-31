package net.frostcraftsman.gimmickery.item;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.entity.EntityPrinnyBlue;
import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPrinnyBlue extends GimmickeryItemBase{

	public ItemPrinnyBlue(int id) {
		super(id);
		this.st("PrinnyBlue");
		this.setCreativeTab(Gimmickery.gct);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer)
	{
		if(!par2World.isRemote)
		{
		EntityPrinnyBlue entity = new EntityPrinnyBlue(par2World, par3EntityPlayer.posX + 3f, par3EntityPlayer.posY , par3EntityPlayer.posZ, par3EntityPlayer);
		par2World.spawnEntityInWorld(entity);
		}
		return par1ItemStack;
    }
}
