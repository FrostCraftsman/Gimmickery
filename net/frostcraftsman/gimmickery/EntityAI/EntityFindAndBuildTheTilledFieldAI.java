package net.frostcraftsman.gimmickery.EntityAI;

import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/** 判断是否能够进行种地的变量以及种地的方法。
 *  par1为搜索种地地标的范围；
 *  par2为传入人偶的entity。
 */
public class EntityFindAndBuildTheTilledFieldAI 
{
	public boolean trigger=false;
	public int numWater=0;
	public int numDirt=0;
	public int posX=0;
	public int posY=0;
	public int posZ=0;
	
	public EntityFindAndBuildTheTilledFieldAI()
	{
		
	}
	
	public void findAndBuildTheTilledField (int distance, EntityWoodKarakuriNingyG par2entity)
	{  
	  for(int i=1; i<distance; i++)
		{        
		  for(int j=1; j<distance; j++)
		    {
		      for(int k=1; k<distance; k++)
		    	{	
		          posX=MathHelper.floor_double(par2entity.posX+k-3);
		          posY=MathHelper.floor_double(par2entity.posY+i-4);
		          posZ=MathHelper.floor_double(par2entity.posZ+j-3);
		    	  
		          par2entity.worldObj.setBlock(posX, posY, posZ, Block.waterMoving.blockID, 0, 2);
	              System.out.println("设置流动水流。");
	              numWater++;
	              System.out.println("搜索计步器："+numWater);
	  
                  if(numWater>31&&numWater<35)
	               {
                	 par2entity.worldObj.setBlock(posX, posY, posZ, Block.tilledField.blockID, 0, 2);
		             System.out.println("设置耕地。");
		             numDirt++;
		           }
		     
	              if(numWater>36&&numWater<40)
		           {
	            	 par2entity.worldObj.setBlock(posX, posY, posZ, Block.tilledField.blockID, 0, 2);
		             System.out.println("设置耕地。");
		             numDirt++;
		           }
		     
	              if(numWater>41&&numWater<45)
		           {
	            	 par2entity.worldObj.setBlock(posX, posY, posZ, Block.tilledField.blockID, 0, 2);
		             System.out.println("设置耕地。");
		             numDirt++;
		           }
		     
	              if(numWater>50)
		           {
	            	 par2entity.worldObj.setBlock(posX, posY, posZ, 0, 0, 2);
		             System.out.println("设置空气。"); 
		           }
		    	}
		    }
	   }	
	}
}
