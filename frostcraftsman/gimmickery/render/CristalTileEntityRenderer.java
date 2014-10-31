package net.frostcraftsman.gimmickery.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.frostcraftsman.gimmickery.model.ModelCristal;
import net.frostcraftsman.gimmickery.tileentity.CristalTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class CristalTileEntityRenderer extends TileEntitySpecialRenderer {
    public static CristalTileEntityRenderer cristalRenderer;
    private ModelCristal cristalModel = new ModelCristal();
    private CristalTileEntity tileEntity;




	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8){
        this.renderTileEntityCristalAt((CristalTileEntity)par1TileEntity, par2, par4, par6, par8);
        this.tileEntity=(CristalTileEntity) par1TileEntity;
	}

    public void renderTileEntityCristalAt(CristalTileEntity par1TileEntityCristal, double par2, double par4, double par6, float par8)
    {
    	this.rendering((float)par2, (float)par4, (float)par6, 0,par1TileEntityCristal.getCristalType());
    }

    
    
    public void rendering(float par1, float par2, float par3, int par4, int par6){
    	GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glTranslatef(par1 + 0.5F, par2 + 0.5F, par3 + 0.5F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(1.0F, -1.0F, 1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        cristalModel.render((Entity)null, 0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0625F);
        FontRenderer fontrenderer = this.getFontRenderer();
        String s=this.tileEntity.name;
        GL11.glTranslatef(0F, -1.5F, 0F);
        GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-0.03F, 0.03F, 0.03F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        int j = fontrenderer.getStringWidth(s) / 2;
        int color = 0xFF0099FF;
        /*
        int color=0xFF000000;
        if(CristalTileEntity.cristalNum<=10){
            color = 0xFF0099FF;
        }else if(CristalTileEntity.cristalNum<25){
        	color = 0xFF00FF77;
        }else if(CristalTileEntity.cristalNum<50){
        	color = 0xFFFFFF00;
        }else{
        	color = 0xFFFF0000;
        }*/
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.2F);
        tessellator.addVertex((double)(-j -1), (double)(-3), 0.0D);
        tessellator.addVertex((double)(-j -1), (double)(6), 0.0D);
        tessellator.addVertex((double)(j), (double)(6), 0.0D);
        tessellator.addVertex((double)(j), (double)(-3), 0.0D);
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        fontrenderer.drawString(s, -j, -2, color);
        GL11.glPopMatrix();
    }

}
