package net.frostcraftsman.gimmickery.tileentity;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostcraftsman.gimmickery.configration.GimmickeryConfiger;
import net.frostcraftsman.gimmickery.model.ModelCristal;
import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProps;
import net.frostcraftsman.gimmickery.worlddatasaver.GimmickeryWorldDataSaver;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class CristalTileEntity extends TileEntity {
	private int cristalType=0;
	private String name = this.setName();
	private boolean isDefaultName=true;
	
	private String setName(){
		Random rnd = new Random();
		StringBuilder builder=new StringBuilder("");
		if(GimmickeryClientProps.RANDOM_NAME_LENGTH<=0){
			return ""+GimmickeryClientProps.RANDOM_NAME_LENGTH;
		}
		for(int i=0;i<GimmickeryClientProps.RANDOM_NAME_LENGTH;i++){
			char c;
			if(rnd.nextBoolean()||i==0){
				c=(char) (rnd.nextInt(26)+'A');
			}else{
				c=(char) (rnd.nextInt(26)+'a');
			}
			builder.append(c);
		}
		return builder.toString();
	}

	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("CristalType", (byte)(this.cristalType & 255));
        par1NBTTagCompound.setString("CristalName", this.name);
        par1NBTTagCompound.setBoolean("isDefaultName", this.isDefaultName);
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.cristalType = par1NBTTagCompound.getByte("CristalType");
        this.name=par1NBTTagCompound.getString("CristalName");
        this.isDefaultName=par1NBTTagCompound.getBoolean("isDefaultName");
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

    public int getCristalType()
    {
        return this.cristalType;
    }

    public String getName(){
    	return this.name;
    }
    
    public void setName(String name){
		this.name=name;
		this.isDefaultName=false;
	}
	
	public int getCristalNum(){
		return GimmickeryWorldDataSaver.get(this.getWorldObj()).CristalNum;
	}
	
}