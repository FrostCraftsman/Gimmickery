package net.frostcraftsman.gimmickery.block;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.network.Gimmickery250Packet;
import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProps;
import net.frostcraftsman.gimmickery.registry.GimmickeryBlocks;
import net.frostcraftsman.gimmickery.tileentity.CristalTileEntity;
import net.frostcraftsman.gimmickery.worlddatasaver.GimmickeryWorldDataSaver;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPowerSourceG extends GimmickeryBlockContainerBase{

	public BlockPowerSourceG(int id, Material par2Material) {
		super(id, par2Material);
		this.stb("PowerSourceBlock", "能量魔方");
		this.setCreativeTab(Gimmickery.gct);
		this.setTextureName("gimmickery:cristal");
		this.setBlockBounds(0F, 0F, 0F, 1F, 2F, 1F);
		this.setLightOpacity(0);
		this.setLightValue(1.0F);
	}
	
	public void onBlockAdded(World par1, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1, par2, par3, par4);
    }

	public void breakBlock(World par1, int par2, int par3, int par4, int par5, int par6)
    {
		super.breakBlock(par1, par2, par3, par4, par5, par6);
    }
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
			CristalTileEntity t = (CristalTileEntity) par1World.getBlockTileEntity(par2, par3, par4);
			if(!par1World.isRemote){
				sendDiscribePacket(par2, par3, par4,t.getCristalNum(), par5EntityPlayer);
			}
		return true;
	}
	
	private void sendDiscribePacket(int blockx,int blocky,int blockz,int meta,EntityPlayer player){
		Gimmickery250Packet pkt=new Gimmickery250Packet();
		pkt.packetType=0;
		pkt.dataInt=new int[4];
		pkt.dataInt[0]=blockx;
		pkt.dataInt[1]=blocky;
		pkt.dataInt[2]=blockz;
		pkt.dataInt[3]=meta;
		PacketDispatcher.sendPacketToPlayer(pkt.toPacket(), (Player) player);
	}
	
	
	
	@Override
	public TileEntity createNewTileEntity(World world){
		return new CristalTileEntity();
	}
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	@Override
	public int getRenderType()
    {
        return GimmickeryClientProps.RENDER_MUILTY_FACE_BLOCK;
    }
	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
        return false;
    }
}