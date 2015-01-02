package net.frostcraftsman.gimmickery.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderPrinnyBlue extends GimmickeryRenderLivingBase{

	private static final ResourceLocation PrinnyBlue_Texture = new ResourceLocation("gimmickery:textures/entity/PrinnyBlue.png");
	
	public RenderPrinnyBlue(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return PrinnyBlue_Texture;
    }
}

