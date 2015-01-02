package net.frostcraftsman.gimmickery.EntityAI;

import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;

public class EntityKarakuriNingyDoNothing extends EntityKarakuriNingyAIChild{

	
	public EntityKarakuriNingyDoNothing(EntityWoodKarakuriNingyG entityWoodKarakuriNingyG) {
    }

    @Override
    public boolean shouldExecute() {
        return false;
    }
}
