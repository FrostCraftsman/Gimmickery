package net.frostcraftsman.gimmickery.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFrostDoll extends RenderLiving{
	private static final ResourceLocation Frost_Texture = new ResourceLocation("gimmickery:textures/entity/frost.png");
	public RenderFrostDoll(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return Frost_Texture;
	}

}
