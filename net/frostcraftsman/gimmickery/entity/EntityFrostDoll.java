package net.frostcraftsman.gimmickery.entity;

import java.util.List;

import net.frostcraftsman.gimmickery.entity.throwble.EntityIce;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFrostDoll extends EntityMob{

	public EntityFrostDoll(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	//暂时懒得注册和render还有model了

	@Override
	protected Entity findPlayerToAttack()
    {
     double i = this.posX;
     double j = this.posY;
     double k = this.posZ;
     List list = worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox((double)i - 16, (double)j - 4, (double)k - 16, (double)i + 16, (double)j + 4, (double)k + 16));
        for (int a=0;a<list.size();a++)
        {
         if(list.get(a) instanceof EntityFireDoll == false)
         {
         return (Entity)list.get(a);
         }
        }
        return null;
}
	 public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	    {
	        EntityIce ice = new EntityIce(this.worldObj);
	        double d0 = par1EntityLivingBase.posX - this.posX;
	        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - ice.posY;
	        double d2 = par1EntityLivingBase.posZ - this.posZ;
	        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
	        ice.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
	        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	        this.worldObj.spawnEntityInWorld(ice);
	    }
}
