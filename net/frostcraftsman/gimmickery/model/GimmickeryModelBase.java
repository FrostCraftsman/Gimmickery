package net.frostcraftsman.gimmickery.model;

import net.minecraft.client.model.ModelBase;

public abstract class GimmickeryModelBase extends ModelBase {
	public float GlScaleX;
	public float GlScaleY;
	public float GlScaleZ;
	public GimmickeryModelBase(){
		super();
	}
	public void setGlScale(float x,float y,float z){
		this.GlScaleX = x;
		this.GlScaleY = y;
		this.GlScaleZ = z;
	}
}
