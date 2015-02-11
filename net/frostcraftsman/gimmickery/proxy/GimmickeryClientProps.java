package net.frostcraftsman.gimmickery.proxy;

import net.frostcraftsman.gimmickery.Gimmickery;
import net.frostcraftsman.gimmickery.configration.GimmickeryConfiger;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class GimmickeryClientProps 
{
	public static int renderTick=0;
	public final static int RENDER_MUILTY_FACE_BLOCK = RenderingRegistry.getNextAvailableRenderId();
	public final static ResourceLocation TEX_DEFAULT = new ResourceLocation("gimmickery:textures/default.png");
	public final static ResourceLocation GUI_BACK_GROUND_PIC= new ResourceLocation("gimmickery:textures/GUIBackGround.png");
	public static int RANDOM_NAME_LENGTH=Gimmickery.CORE_CONFIG.GetRandomNameLength();
	public static int CRISTAL_NAME_COLOR=Gimmickery.CORE_CONFIG.GetCristalNameColor();
	public static void init(){}
}
