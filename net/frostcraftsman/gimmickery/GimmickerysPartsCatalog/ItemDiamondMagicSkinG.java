package net.frostcraftsman.gimmickery.GimmickerysPartsCatalog;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.entity.EntityPrinnyBlue;
import net.frostcraftsman.gimmickery.item.GimmickeryItemBase;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDiamondMagicSkinG extends GimmickeryItemBase
{

	public ItemDiamondMagicSkinG(int id) 
	{
		super(id);
		this.st("DiamondMagicSkin");
		this.setCreativeTab(Gimmickery.gct);
		this.setMaxStackSize(64);//璁剧疆鏈�ぇ鍫嗗彔鏁颁负64
		// TODO Auto-generated constructor stub
	}

	
	double posX1;
	double posY1;
	double posZ1;
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		// TODO 自动生成的方法存根
	
        posX1=MathHelper.floor_double(par3EntityPlayer.posX);
        posY1=MathHelper.floor_double(par3EntityPlayer.posY);
        posZ1=MathHelper.floor_double(par3EntityPlayer.posZ);

           System.out.println("rotationYaw Head:"+par3EntityPlayer.rotationYawHead);
           System.out.println("rotation Yaw:"+par3EntityPlayer.rotationYaw);  
           System.out.println("rotation  Pitch:"+par3EntityPlayer.rotationPitch);

        if(par3EntityPlayer.rotationYawHead==90)
        {
    		if(!par2World.isRemote)
    		{
    		EntityPrinnyBlue entity = new EntityPrinnyBlue(par2World, par3EntityPlayer.posX + 3f, par3EntityPlayer.posY , par3EntityPlayer.posZ, par3EntityPlayer);
    		par2World.spawnEntityInWorld(entity);
    		}
        }			
        return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	
	}

	
}
