package net.frostcraftsman.gimmickery.tileentity;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostcraftsman.gimmickery.model.ModelCristal;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class CristalTileEntity extends TileEntity {
	private int cristalType=0;
	public static int ticker=0;
	public String name;
	public CristalTileEntity(){
		Random rnd = new Random();
		for(int i=0;i<8;i++){
			char c=(char)rnd.nextInt();
			name+=c;
		}
	}
	

	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("CristalType", (byte)(this.cristalType & 255));
        par1NBTTagCompound.setString("CristalName", this.name);
    }

	@Override
	public void updateEntity(){
		ticker++;
	}
    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.cristalType = par1NBTTagCompound.getByte("CristalType");
        this.name=par1NBTTagCompound.getString("CristalName");
    }


    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 4, nbttagcompound);
    }
    public void setCristalType(int par1)
    {
        this.cristalType = par1;
    }

    /**
     * Get the entity type for the cristal
     */
    public int getCristalType()
    {
        return this.cristalType;
    }

}
