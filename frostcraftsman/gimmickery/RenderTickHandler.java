package net.frostcraftsman.gimmickery;

import java.util.EnumSet;

import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProps;
import net.minecraft.world.World;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class RenderTickHandler implements ITickHandler {
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		GimmickeryClientProps.renderTick++;
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Gimmickery_Ticker";
	}


}