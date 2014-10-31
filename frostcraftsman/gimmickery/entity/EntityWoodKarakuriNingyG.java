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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIDefendVillage;
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
import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDummyContainer;
import net.frostcraftsman.gimmickery.EntityAI.EntityKarakuriNingyAIManager;
import net.frostcraftsman.gimmickery.block.*;
import net.frostcraftsman.gimmickery.item.ItemWoodKarakuriNingyG;


public class EntityWoodKarakuriNingyG extends EntityTameable{	
	
    private EntityPlayer player;
    private EntityPlayer player1;

	public EntityWoodKarakuriNingyG(World par1World) {
		super(par1World);
        this.setSize(1.4F, 2.9F);     
        experienceValue = 5;
        
            this.getNavigator().setAvoidsWater(true);
            this.getNavigator().tryMoveToEntityLiving(player, 2);
            this.tasks.addTask(1, new EntityAISwimming(this));
            this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMob.class, 1.0D, true));
            this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
            this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.3F));
            this.tasks.addTask(5, new EntityAIWander(this, 1.25F));
            this.tasks.addTask(6, new EntityAIWatchClosest(this,EntityPlayer.class, 8.0F));
            // ר��AI��manager
            this.tasks.addTask(7, new EntityKarakuriNingyAIManager(this, 1.25F));
            
            this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
            this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
            this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
            this.setTamed(false);
            
        
       
        if(this.FindEntityPlayerNow() instanceof EntityPlayer)
        { 	
            System.out.println("�ҵ��������~��������ǣ�"+player1.getEntityName());
        }
	    

        
	}

	public EntityWoodKarakuriNingyG(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase)
    {
        super(par1World);
        this.setPosition(par2, par4, par6);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D-0.5F;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().tryMoveToEntityLiving(player, 2);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMob.class, 1.0D, true));
        this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(5, new EntityAIWander(this, 1.25F));
        this.tasks.addTask(6, new EntityAIWatchClosest(this,EntityPlayer.class, 8.0F));
        // ר��AI��manager
        this.tasks.addTask(7, new EntityKarakuriNingyAIManager(this, 1.25F));
        
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.setTamed(false);
        
        if(this.findPowerSource() == true)
        {    
            System.out.println("�ɹ����������");
        }
        else
        {
            System.out.println("�������㡤�˶������ܡ�����");
        }
    }

	
	/** ���ַ���Ѱ��ħ���ĳ��� */
	int distance=10;
	int id;
	int kposX;
	int jposY;
	int iposZ;

	public boolean findPowerSource()
	{
		for(int i=1; i<distance; i++)
		{        
		    for(int j=1; j<distance; j++)
		    {
		        for(int k=1; k<distance; k++)
		    	{
		        	 kposX=(int)(this.posX+k);
		        	 jposY=(int)(this.posY+j);
		        	 iposZ=(int)(this.posZ+i);
		        	 
		    			 id = this.worldObj.getBlockId(kposX, jposY, iposZ);
		    				 
		 				 System.out.println("������x�᷽��,��"+k*i*k+"��̽������x���"+kposX+",��y���"+jposY+",��z���"+iposZ+",��id��"+id);
		 					
		 				 if (id == GimmickeryBlocks.PowerSourceBlock.blockID)
		    				{
		    				     System.out.println("�Ѷ�λ��ħ��X�����:"+kposX);
		    				     return true;
		    				}
		 			     else
		 					{
		 						
		 						 System.out.println("x�᷽��δ���֡�");
		 						      
		 					}			
		    	}
		        
		     System.out.println("������y�᷽��,��"+j*i+"��̽������x���"+kposX+",��y���"+jposY+",��z���"+iposZ+",��id��"+id);
					
		     if (id == GimmickeryBlocks.PowerSourceBlock.blockID)
			    {
		    	
				     System.out.println("�Ѷ�λ��ħ��Y�����:"+jposY);
				     return true;
				    
			    }
		     else
			    {
				
				     System.out.println("Y�᷽��δ���֡�");
					
			    }
		    
	        }
	       System.out.println("������z�᷽��,��"+i+"��̽������x���"+kposX+",��y���"+jposY+",��z���"+iposZ+",��id��"+id);
			
	       if (id == GimmickeryBlocks.PowerSourceBlock.blockID)
			  {
				
		           System.out.println("�Ѷ�λ��ħ��Z�����:"+iposZ);
		           return true;
		        
			  }
		   else
			  {
				
				   System.out.println("Z�᷽��δ���֡�");
				
			  }
	   }
		
		return false;
		
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
    
    
	
	/**
	 *  ���ַ���Ѱ��player�ĳ�����
	 */
	float f = 8.0F;
    List list;
    int i;
    
	public EntityPlayer FindEntityPlayerNow()
	{
		list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand((double)f, (double)f, (double)f));

        for (i = 0; i < list.size(); ++i)
        {
            EntityPlayer entityplayer = (EntityPlayer)list.get(i);

            if (entityplayer.getCurrentEquippedItem() != null && this.isBreedingItem(entityplayer.getCurrentEquippedItem()))
            {
                player1=entityplayer;
                return entityplayer;
            }
            else
            {
            	this.FindEntityPlayerNow();
            	System.out.println("��û�ҵ�������Ѱ��~");
            }
        }
        return null;
	}

	/**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0)
        {
            this.setDead();
        }
        
        if(player != null) 
        {
            this.getNavigator().tryMoveToEntityLiving(player, 2);
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
        

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);

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
