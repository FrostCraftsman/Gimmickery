package net.frostcraftsman.gimmickery.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Gentest extends WorldGenerator
{

	@Override
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) 
	{
		if (par4 <= 4)
		{
		int block = Block.ice.blockID;

	    int size = 5;

	    for (int i1 = 0; i1 < size; i1++)

	    {

	       for (int j1 = 0; j1 < size; j1++)

	       {

	          //墙

	       par1World.setBlock(par3+i1,par4+j1,par5,block);

	       par1World.setBlock(par3+i1,par4+j1,par5+(size-1),block);

	       par1World.setBlock(par3,par4+j1,par5+i1,block);

	       par1World.setBlock(par3+(size-1),par4+j1,par5+i1,block);

	          

	          //屋顶

	       par1World.setBlock(par3+i1,par4+(size-1),par5+j1,block);



	          //地板

	       par1World.setBlock(par3+i1,par4,par5+j1,block);

	       }

	    }

	    //门

	    par1World.setBlock(par3+1,par4+2,par5,0);

	    par1World.setBlock(par3+1,par4+1,par5,0);



	    //内部设置

	    par1World.setBlock(par3+1,par4+1,par5+(size-2),Block.chest.blockID);

	    par1World.setBlock(par3+(size-2),par4+1,par5+1,Block.workbench.blockID);

	    par1World.setBlock(par3+(size-2),par4+1,par5+(size-2),Block.furnaceIdle.blockID);
	    
	    return true;
		}
		else
		{
		return false;
		}
	}

}
