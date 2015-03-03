package net.frostcraftsman.gimmickery.entity.throwble;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIce extends EntityThrowable{

	public EntityIce(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onImpact(MovingObjectPosition me) {
		// TODO Auto-generated method stub
		if(me.entityHit != null){
			((EntityLivingBase) me.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
			if(me.entityHit instanceof EntityLiving && me.entityHit.height > me.entityHit.width ){
				me.entityHit.worldObj.setBlock((int)me.entityHit.posX, (int)me.entityHit.posY, (int)me.entityHit.posZ, Block.ice.blockID);
				me.entityHit.worldObj.setBlock((int)me.entityHit.posX, (int)me.entityHit.posY + 1, (int)me.entityHit.posZ, Block.ice.blockID);
			}
			else if(me.entityHit instanceof EntityLiving && me.entityHit.width > me.entityHit.height ){
				me.entityHit.worldObj.setBlock((int)me.entityHit.posX, (int)me.entityHit.posY, (int)me.entityHit.posZ, Block.ice.blockID);
				me.entityHit.worldObj.setBlock((int)me.entityHit.posX+1, (int)me.entityHit.posY, (int)me.entityHit.posZ+1, Block.ice.blockID);
			}
			byte b0 = 0;

            if (me.entityHit instanceof EntityBlaze)
            {
                b0 = 3;
            }

            me.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("snow", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
		
		
	}


