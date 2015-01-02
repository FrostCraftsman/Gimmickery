package net.frostcraftsman.gimmickery.worlddatasaver;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class GimmickeryWorldDataSaver extends WorldSavedData {
	public int CristalNum=0;

	public GimmickeryWorldDataSaver() {
		super("Gimmickery");
	}
	
	public GimmickeryWorldDataSaver(String name) {
		super(name);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.CristalNum=nbt.getInteger("CristalNum");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("CristalNum",this.CristalNum);
	}
	
	public int getCristalNum(){
		return this.CristalNum;
	}
	
	public void CristalNumplu(){
		this.CristalNum++;
		this.markDirty();
	}
	
	public void CristalNummin(){
		if(this.CristalNum>0)this.CristalNum--;
		this.markDirty();
	}
	@SideOnly(Side.CLIENT)
	public void setCristalNum(int num){
		this.CristalNum=num;
		this.markDirty();
	}
	
	public static GimmickeryWorldDataSaver get(World world) {
		GimmickeryWorldDataSaver data = (GimmickeryWorldDataSaver)world.perWorldStorage.loadData(GimmickeryWorldDataSaver.class, "Gimmickery");
		if (data == null) {
			data = new GimmickeryWorldDataSaver();
			world.perWorldStorage.setData("Gimmickery", data);
		}
		return data;
	}
}
