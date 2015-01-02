package net.frostcraftsman.gimmickery.render;

import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProps;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BeamRenderer {
	private float x;
	private float y;
	private float z;
	private float targetx;
	private float targety;
	private float targetz;
	private ResourceLocation texture=GimmickeryClientProps.TEX_DEFAULT;
	public void doRender(){
		float d_x=targetx-x;
		float d_y=targety-y;
		float d_z=targetz-z;
		float distance=(float)Math.sqrt(d_x*d_x+d_y*d_y+d_z*d_z);
		GL11.glTranslatef(x, y, z);
		if(d_x<0){
			GL11.glRotatef(180, 0, 1, 0);
			d_x=-d_x;
			d_z=-d_z;
		}
		GL11.glRotatef((float)(Math.atan2(d_z,d_x)*180/Math.PI), 0, 1, 0);
		GL11.glRotatef((float)(Math.atan2(d_y,Math.sqrt(d_x*d_x+d_z*d_z))*180/Math.PI), 1, 0, 0);
		GL11.glPushMatrix();
		renderModelBeam(distance);
		GL11.glPopMatrix();
	}
	public void renderModelBeam(float distance){
		//unfinished
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	}
	public void setTexture(ResourceLocation texture){
		this.texture=texture;
	}

}
