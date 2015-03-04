package net.frostcraftsman.gimmickery.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.frostcraftsman.gimmickery.entity.throwble.EntityIce;
import net.frostcraftsman.gimmickery.model.ModelIce;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderIce extends Render{
	private static final ResourceLocation ICE_Texture = new ResourceLocation("gimmickery:textures/entity/ice.png");
	
	 private float field_77002_a;

	    public RenderIce( float par2)
	    {
	    	
	        this.field_77002_a = par2;
	    }

	    public void doRenderIce(EntityIce ice, double par2, double par4, double par6, float par8, float par9)
	    {
	    	
	        GL11.glPushMatrix();
	        this.bindEntityTexture(ice);
	        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        float f2 = this.field_77002_a;
	        GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
	        Icon icon = Item.fireballCharge.getIconFromDamage(0);
	        Tessellator tessellator = Tessellator.instance;
	        float f3 = icon.getMinU();
	        float f4 = icon.getMaxU();
	        float f5 = icon.getMinV();
	        float f6 = icon.getMaxV();
	        float f7 = 1.0F;
	        float f8 = 0.5F;
	        float f9 = 0.25F;
	        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        tessellator.startDrawingQuads();
	        tessellator.setNormal(0.0F, 1.0F, 0.0F);
	        tessellator.addVertexWithUV((double)(0.0F - f8), (double)(0.0F - f9), 0.0D, (double)f3, (double)f6);
	        tessellator.addVertexWithUV((double)(f7 - f8), (double)(0.0F - f9), 0.0D, (double)f4, (double)f6);
	        tessellator.addVertexWithUV((double)(f7 - f8), (double)(1.0F - f9), 0.0D, (double)f4, (double)f5);
	        tessellator.addVertexWithUV((double)(0.0F - f8), (double)(1.0F - f9), 0.0D, (double)f3, (double)f5);
	        tessellator.draw();
	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        GL11.glPopMatrix();
	    }



	 protected ResourceLocation getArrowTextures(EntityArrow par1EntityArrow)
	    {
	        return ICE_Texture;
	    }

	 
	 private ResourceLocation getArrowTextures(Entity par1Entity) {
		// TODO Auto-generated method stub
		 return this.getArrowTextures((EntityArrow)par1Entity);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	    {
	        this.doRenderIce((EntityIce)par1Entity, par2, par4, par6, par8, par9);
	    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
