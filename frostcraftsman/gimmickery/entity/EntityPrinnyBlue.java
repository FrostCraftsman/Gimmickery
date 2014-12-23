package net.frostcraftsman.gimmickery.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityPrinnyBlue extends EntityAnimal{

	public EntityPrinnyBlue(World par1World) {
		super(par1World);
		this.setSize(0.9F, 1.3F);
        this.tasks.addTask(1, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		// TODO Auto-generated constructor stub
	}

	public EntityPrinnyBlue(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase)
    {
        this(par1World);
        this.setPosition(par2, par4, par6);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }
	
	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		// TODO Auto-generated method stub
		return entityageable = this.createChild(this);

	}

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.20000000298023224D);
    }

    @Override
    protected String getLivingSound()
    {
        return "gimmickery:PrinnyBlueSound";//this refers to:gimmickery/sound/PrinnyBlueSound
    }

    @Override
    protected String getHurtSound()
    {
        return "gimmickery:optionalFile.PrinnyBlueSound";//this refers to:gimmickery/sound/optionalFile/PrinnyBlueSound
    }

    @Override
    protected String getDeathSound()
    {
        return "gimmickery:optionalFile.optionalFile2.PrinnyBlueSound";//etc.
    }

    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }
}
