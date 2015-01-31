// Date: 2014-12-30 星期二 16:55:24
package net.frostcraftsman.gimmickery.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStoneSignal extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer base2;
    ModelRenderer pillar;
    ModelRenderer pillar2;
    ModelRenderer pillar3;
    ModelRenderer pillar4;
    ModelRenderer top;
    ModelRenderer top2;
    ModelRenderer magicCube;
  
  public ModelStoneSignal()
  {
	  textureWidth = 128;
    textureHeight = 64;
    
      base = new ModelRenderer(this, 49, 0);
      base.addBox(-8F, 7F, -8F, 16, 2, 16);
      base.setRotationPoint(0F, 15F, 0F);
      base.setTextureSize(128, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      base2 = new ModelRenderer(this, 50, 20);
      base2.addBox(-6F, 5F, -6F, 12, 2, 12);
      base2.setRotationPoint(0F, 15F, 0F);
      base2.setTextureSize(128, 64);
      base2.mirror = true;
      setRotation(base2, 0F, 0F, 0F);
      pillar = new ModelRenderer(this, 16, 42);
      pillar.addBox(-1F, 0F, -1F, 2, 9, 2);
      pillar.setRotationPoint(4F, 11F, -4F);
      pillar.setTextureSize(128, 64);
      pillar.mirror = true;
      setRotation(pillar, 0F, 0F, 0F);
      pillar2 = new ModelRenderer(this, 8, 42);
      pillar2.addBox(-1F, 0F, -1F, 2, 9, 2);
      pillar2.setRotationPoint(-4F, 11F, -4F);
      pillar2.setTextureSize(128, 64);
      pillar2.mirror = true;
      setRotation(pillar2, 0F, 0F, 0F);
      pillar3 = new ModelRenderer(this, 24, 42);
      pillar3.addBox(-1F, 0F, -1F, 2, 9, 2);
      pillar3.setRotationPoint(4F, 11F, 4F);
      pillar3.setTextureSize(128, 64);
      pillar3.mirror = true;
      setRotation(pillar3, 0F, 0F, 0F);
      pillar4 = new ModelRenderer(this, 0, 42);
      pillar4.addBox(-1F, 0F, -1F, 2, 9, 2);
      pillar4.setRotationPoint(-4F, 11F, 4F);
      pillar4.setTextureSize(128, 64);
      pillar4.mirror = true;
      setRotation(pillar4, 0F, 0F, 0F);
      top = new ModelRenderer(this, 0, 18);
      top.addBox(-4F, -8F, -4F, 8, 2, 8);
      top.setRotationPoint(0F, 15F, 0F);
      top.setTextureSize(128, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      top2 = new ModelRenderer(this, 0, 28);
      top2.addBox(-6F, -6F, -6F, 12, 2, 12);
      top2.setRotationPoint(0F, 15F, 0F);
      top2.setTextureSize(128, 64);
      top2.mirror = true;
      setRotation(top2, 0F, 0F, 0F);
      magicCube = new ModelRenderer(this, 0, 53);
      magicCube.addBox(-1F, -1F, -1F, 2, 2, 2);
      magicCube.setRotationPoint(0F, 15F, 0F);
      magicCube.setTextureSize(128, 64);
      magicCube.mirror = true;
      setRotation(magicCube, 1F, 1F, 1F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
	setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    base.render(f5);
    base2.render(f5);
    pillar.render(f5);
    pillar2.render(f5);
    pillar3.render(f5);
    pillar4.render(f5);
    top.render(f5);
    top2.render(f5);
    magicCube.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
	  super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
  }

}
