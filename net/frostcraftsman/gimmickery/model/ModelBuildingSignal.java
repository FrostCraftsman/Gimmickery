// Date: 2014-12-31 鏄熸湡涓�9:00:57
package net.frostcraftsman.gimmickery.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBuildingSignal extends ModelBase
{
  //fields
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer hammer;
    ModelRenderer handle;
    ModelRenderer nail1;
    ModelRenderer nail2;
    ModelRenderer nail3;
    ModelRenderer nail4;
    ModelRenderer wood1;
    ModelRenderer wood2;
    ModelRenderer wood3;
    ModelRenderer map;
  
  public ModelBuildingSignal()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      base1 = new ModelRenderer(this, 0, 34);
      base1.addBox(-6F, 6F, -6F, 12, 1, 12);
      base1.setRotationPoint(0F, 16F, 0F);
      base1.setTextureSize(128, 64);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      base2 = new ModelRenderer(this, 0, 47);
      base2.addBox(-8F, 8F, -8F, 16, 1, 16);
      base2.setRotationPoint(0F, 15F, 0F);
      base2.setTextureSize(128, 64);
      base2.mirror = true;
      setRotation(base2, 0F, 0F, 0F);
      hammer = new ModelRenderer(this, 0, 27);
      hammer.addBox(-3F, -4F, -2F, 6, 3, 3);
      hammer.setRotationPoint(-1F, 18F, -2F);
      hammer.setTextureSize(128, 64);
      hammer.mirror = true;
      setRotation(hammer, 0F, 0F, 2.5F);
      handle = new ModelRenderer(this, 0, 17);
      handle.addBox(-1F, 0F, -1F, 1, 8, 1);
      handle.setRotationPoint(0F, 20F, -2F);
      handle.setTextureSize(128, 64);
      handle.mirror = true;
      setRotation(handle, 0F, 0F, 2.5F);
      nail1 = new ModelRenderer(this, 20, 27);
      nail1.addBox(-1F, 0F, -1F, 2, 1, 2);
      nail1.setRotationPoint(7F, 22.5F, -7F);
      nail1.setTextureSize(128, 64);
      nail1.mirror = false;
      setRotation(nail1, 0F, 0F, 0F);
      nail2 = new ModelRenderer(this, 20, 27);
      nail2.addBox(-1F, 0F, -1F, 2, 1, 2);
      nail2.setRotationPoint(7F, 22.5F, 7F);
      nail2.setTextureSize(128, 64);
      nail2.mirror = false;
      setRotation(nail2, 0F, 0F, 0F);
      nail3 = new ModelRenderer(this, 20, 27);
      nail3.addBox(-1F, 0F, -1F, 2, 1, 2);
      nail3.setRotationPoint(-7F, 22.5F, 7F);
      nail3.setTextureSize(128, 64);
      nail3.mirror = false;
      setRotation(nail3, 0F, 0F, 0F);
      nail4 = new ModelRenderer(this, 20, 27);
      nail4.addBox(-1F, 0F, -1F, 2, 1, 2);
      nail4.setRotationPoint(-7F, 22.5F, -7F);
      nail4.setTextureSize(128, 64);
      nail4.mirror = false;
      setRotation(nail4, 0F, 0F, 0F);
      wood1 = new ModelRenderer(this, 0, 6);
      wood1.addBox(-6F, 1F, 2F, 9, 1, 1);
      wood1.setRotationPoint(3F, 20F, 0F);
      wood1.setTextureSize(128, 64);
      wood1.mirror = true;
      setRotation(wood1, 0F, 0.5F, 0F);
      wood2 = new ModelRenderer(this, 0, 0);
      wood2.addBox(-5F, 1F, 4F, 9, 1, 1);
      wood2.setRotationPoint(0F, 20F, -2F);
      wood2.setTextureSize(128, 64);
      wood2.mirror = true;
      setRotation(wood2, 0F, 0.5F, 0F);
      wood3 = new ModelRenderer(this, 0, 3);
      wood3.addBox(-5F, 0F, 3F, 9, 1, 1);
      wood3.setRotationPoint(0.5F, 20F, -0.5F);
      wood3.setTextureSize(128, 64);
      wood3.mirror = true;
      setRotation(wood3, 0F, 0.5F, 0F);
      map = new ModelRenderer(this, 22, 0);
      map.addBox(-2F, 0F, -4F, 4, 0, 8);
      map.setRotationPoint(-6F, 22F, 0F);
      map.setTextureSize(128, 64);
      map.mirror = true;
      setRotation(map, 0F, 0F, -0.5F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    base1.render(f5);
    base2.render(f5);
    hammer.render(f5);
    handle.render(f5);
    nail1.render(f5);
    nail2.render(f5);
    nail3.render(f5);
    nail4.render(f5);
    wood1.render(f5);
    wood2.render(f5);
    wood3.render(f5);
    map.render(f5);
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
