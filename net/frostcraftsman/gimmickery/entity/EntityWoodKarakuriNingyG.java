package net.frostcraftsman.gimmickery.entity;

import java.util.List;
import java.util.UUID;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostcraftsman.gimmickery.registry.GimmickeryBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIDefendVillage;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookAtVillager;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDummyContainer;
import net.frostcraftsman.gimmickery.EntityAI.*;
import net.frostcraftsman.gimmickery.block.*;
import net.frostcraftsman.gimmickery.item.ItemWoodKarakuriNingyG;

public class EntityWoodKarakuriNingyG extends EntityTameable{	
	
	private EntityTameable theEntity;
    private static EntityPlayer player;
	public int entityposX=0;
	public int entityposY=0;
	public int entityposZ=0;
	public boolean EnergyTrigger=false;
	/** 搜索能量魔方的方法以及变量 */
	int distance=6;
	int id;
    
	public EntityWoodKarakuriNingyG(World par1World) 
	{
		super(par1World);
        this.setSize(1.4F, 2.9F);     
        experienceValue = 5;  

	}	
	

	public EntityWoodKarakuriNingyG(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase)
    {
        super(par1World);
        
        EntityFindPowerSourceAI EntityFindPowerSourceAI = new EntityFindPowerSourceAI();
        EntityGetUserAI EntityGetUserAI = new EntityGetUserAI();
        
        player=EntityGetUserAI.entityGetUser();
        this.setPosition(par2, par4, par6);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D-0.5F;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
        this.getNavigator().setAvoidsWater(false);
        this.getNavigator().tryMoveToEntityLiving(player, 2);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMob.class, 1.0D, true));
        this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(5, new EntityAIWander(this, 1.25F));
        this.tasks.addTask(6, new EntityAIWatchClosest(this,EntityPlayer.class, 8.0F));
        // AI manager
        this.tasks.addTask(7, new EntityKarakuriNingyAIManager(this, 1.25F));
        
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.setTamed(false);
        
        entityposX=MathHelper.floor_double(this.posX);
        entityposY=MathHelper.floor_double(this.posY);
        entityposZ=MathHelper.floor_double(this.posZ); 

    }

	
	/**
     * Play the taming effect, will either be hearts or smoke depending on status
     */
    protected void playTameEffect(boolean par1)
    {
        String s = "witchMagic";

        for (int i = 0; i < 7; ++i)
        {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(s, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
        }
    }

	public boolean isStillWorking(EntityPlayer entityplayer,EntityWoodKarakuriNingyG EntityWoodKarakuriNingyG)
	{
		if(EntityWoodKarakuriNingyG.EnergyTrigger=true)
		{
			entityplayer.addChatMessage("人偶已获得能量,将会有10秒钟的维持时间。");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
      if(!this.worldObj.isRemote)
      {
        
        if (this.worldObj.difficultySetting == 0)
        {
            this.setDead();
        }
        
        if(player != null) 
        {
            this.getNavigator().tryMoveToEntityLiving(player, 2);
        }           
        
    	/**
         * 从能量魔方得到的能量有10秒钟的维持时间。
         */
        if (this.worldObj.getTotalWorldTime() % 200 == 0)
        {
        	this.EnergyTrigger=false;
        }
        
    	/** 获得能量后进行对应的功能。 */
        if(this.worldObj.getTotalWorldTime() % 80 == 0 && this.EnergyTrigger==true && !this.worldObj.isRemote)
        {
            EntityFindAndBuildTheTilledFieldAI EntityFindAndBuildTheTilledFieldAI = new EntityFindAndBuildTheTilledFieldAI();
        	System.out.println("Trigger："+this.EnergyTrigger);
        	System.out.println("获得玩家，玩家名为："+player.getEntityName());
        	EntityFindAndBuildTheTilledFieldAI.findAndBuildTheTilledField(distance,this);
        }
      }  
    }

    
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
        if (this.isTamed())
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
        }
    }
    
    
    protected void entityInit()
    {
        super.entityInit();

    }

    
    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    
    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        super.updateAITick();
    }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Tamed", this.isTamed());
        par1NBTTagCompound.setString("Owner",this.getOwnerName());

    }
    

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setTamed(par1NBTTagCompound.getBoolean("Tamed"));
        this.setOwner(par1NBTTagCompound.getString("Owner"));

    }
    

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        this.worldObj.setEntityState(this, (byte)4);
        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));

        if (flag)
        {
            par1Entity.motionY += 0.4000000059604645D;
        }
        return flag;
    }
    
    
    /**
     * 与人偶互动让人偶能够得到对应的玩家信息。
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        player = par1EntityPlayer;
    	
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

        if (itemstack != null && itemstack.itemID == Item.ingotGold.itemID)
        {
            if (!par1EntityPlayer.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityMob)null);
                    this.setHealth(20.0F);
                    this.setOwner(par1EntityPlayer.getCommandSenderName());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }  
    

    /**
     * 死后掉落的物品。
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Block.plantRed.blockID, 1);
        }

        k = 3 + this.rand.nextInt(3);

        for (int l = 0; l < k; ++l)
        {
            this.dropItem(Item.ingotIron.itemID, 1);
        }
    }
    
    
    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);
    }

    
    @Override
    protected String getLivingSound()
    {
        return "gimmickery:KarakuriNingySound";//this refers to:gimmickery/sound/KarakuriNingySound
    }

    
    @Override
    protected String getHurtSound()
    {
        return "gimmickery:optionalFile.KarakuriNingySound";//this refers to:gimmickery/sound/optionalFile/KarakuriNingySound
    }

    
    @Override
    protected String getDeathSound()
    {
        return "gimmickery:optionalFile.optionalFile2.KarakuriNingySound";//etc.
    }

    
    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }


	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return null;
    }
	
	
	/**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
	public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!this.worldObj.isRemote && !this.hasPath() && this.onGround)
        {;
            this.worldObj.setEntityState(this, (byte)8);
        }
    }

}
