package net.frostcraftsman.gimmickery.biome;

import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.frostcraftsman.gimmickery.registry.GimmickeryBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Biometest extends BiomeGenBase
{

    public Biometest(int par1) {
		super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWoodKarakuriNingyG.class, 5, 2, 6));
        this.topBlock = (byte)GimmickeryBlocks.PowerSourceBlock.blockID;
        this.fillerBlock = (byte)GimmickeryBlocks.PowerSourceBlock.blockID;
	}

}
