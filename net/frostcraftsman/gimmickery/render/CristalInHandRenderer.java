package net.frostcraftsman.gimmickery.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.model.ModelCristal;
import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProps;
import net.frostcraftsman.gimmickery.tileentity.CristalTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.WatchableObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

public class CristalInHandRenderer implements ISimpleBlockRenderingHandler{
	ModelCristal model = new ModelCristal();
	public CristalInHandRenderer() {
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		GL11.glTranslatef(0, 0.5F, 0);
		model.render((Entity)null, 0F, 0F, 0F, 0F, 0F, 0.05F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return GimmickeryClientProps.RENDER_MUILTY_FACE_BLOCK;
	}

}
