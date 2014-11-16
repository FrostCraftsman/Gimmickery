package net.frostcraftsman.gimmickery.worlddatasaver;

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
		this.markDirty();
		this.CristalNum++;
	}
	
	public void CristalNummin(){
		this.markDirty();
		if(this.CristalNum>0)this.CristalNum--;
	}
	
	public static GimmickeryWorldDataSaver get(World world) {
		GimmickeryWorldDataSaver data = (GimmickeryWorldDataSaver)world.loadItemData(GimmickeryWorldDataSaver.class, "Gimmickery");
		if (data == null) {
			data = new GimmickeryWorldDataSaver();
			world.setItemData("Gimmickery", data);
		}
		return data;
	}
}
