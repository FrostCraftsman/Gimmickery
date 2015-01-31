package net.frostcraftsman.gimmickery.EntityAI;

import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.frostcraftsman.gimmickery.registry.GimmickeryBlocks;
import net.minecraft.util.MathHelper;

public class EntityFindPowerSourceAI {

	public static int id=0;
	public static boolean trigger=false;
	public static int outRangeX=0;
	public static int outRangeY=0;
	public static int outRangeZ=0;
	public static int powerposX=0;
	public static int powerposY=0;
	public static int powerposZ=0;
	public static int entityposX=0;
	public static int entityposY=0;
	public static int entityposZ=0;
	
	public EntityFindPowerSourceAI()
	{
		
	}
	/** 判断是否找到能量魔方的方法。
	 *  par1为搜索能量魔方的范围；
	 *  par2为传入人偶的entity。
	 *  par3为人偶的X坐标。
	 *  par4为人偶的Y坐标。
	 *  par5为人偶的Z坐标。
	 */
	public static boolean findPowerSource(int distance, EntityWoodKarakuriNingyG par2entity, int posX, int posY, int posZ)
	{
		
  	  id = par2entity.worldObj.getBlockId(posX, posY, posZ);
  	  
	  if (id == GimmickeryBlocks.PowerSourceBlock.blockID)
  		{
		  powerposX=posX;
		  powerposY=posY;
		  powerposZ=posZ;
  		  System.out.println("已找到能量魔方，魔方的X坐标为："+posX+"，Y坐标为："+posY+"，Z坐标为："+posZ);
  		  return true;
  		}
	  else
	    {
		  for(int i=1; i<distance; i++)
		   {        
		     for(int j=1; j<distance; j++)
		      {
		        for(int k=1; k<distance; k++)
		    	 {
		           posX=MathHelper.floor_double(par2entity.posX+k-(distance/2));
		           posY=MathHelper.floor_double(par2entity.posY+i-(distance-1));
		           posZ=MathHelper.floor_double(par2entity.posZ+j-(distance/2)); 
		          
		           entityposX=posX;
		           entityposY=posY;
		           entityposZ=posZ;
		          
		    	   id = par2entity.worldObj.getBlockId(posX, posY, posZ);
		 					
		 		   if (id == GimmickeryBlocks.PowerSourceBlock.blockID)
		    		 {
		 			   powerposX=posX;
		 			   powerposY=posY;
		 			   powerposZ=posZ;
		    		   System.out.println("已找到能量魔方。魔方的X坐标为："+posX+"，Y坐标为："+posY+"，Z坐标为："+posZ);
		    		   return true;
		    		 }			
		    	  }
		      }
	       }
	   }
		 return false;	
	}
	
	
	public static int getXDistanceFromThePowerSource(int posX)
	{
		entityposX=Math.abs(posX);
		powerposX=Math.abs(powerposX);
		outRangeX=powerposX-entityposX;
		outRangeX=Math.abs(outRangeX);
		return outRangeX;
	}
	
	public static int getYDistanceFromThePowerSource(int posY)
	{
		entityposY=Math.abs(posY);
		powerposY=Math.abs(powerposY);
		outRangeY=powerposY-entityposY;
		outRangeY=Math.abs(outRangeY);
		return outRangeY;
	}
	
	public static int getZDistanceFromThePowerSource(int posZ)
	{
		entityposZ=Math.abs(posZ);
		powerposZ=Math.abs(powerposZ);
		outRangeZ=powerposZ-entityposZ;
		outRangeZ=Math.abs(outRangeZ);
        return outRangeZ;
	}
	
	public static boolean isOutOfRange(int posX, int posY, int posZ)
	{
		if(getXDistanceFromThePowerSource(posX)>3||getYDistanceFromThePowerSource(posY)>3||getZDistanceFromThePowerSource(posZ)>3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
