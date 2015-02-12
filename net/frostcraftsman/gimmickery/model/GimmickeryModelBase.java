package net.frostcraftsman.gimmickery.model;

import org.lwjgl.opengl.GL11;

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
	public void renderAtSize(){
		GL11.glScalef(GlScaleX, GlScaleY, GlScaleZ);
	}
}
