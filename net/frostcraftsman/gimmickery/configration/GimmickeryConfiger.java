package net.frostcraftsman.gimmickery.configration;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;

public class GimmickeryConfiger {
	public static GimmickeryConfiger instance;
	private Configuration config;
	public static void InitliazeConfig(File ConfigFile)
    {
        if(instance != null)
        {
            return;
        }
        instance = new GimmickeryConfiger(ConfigFile);
    }
	private GimmickeryConfiger(File configFile)
    {
        config = new Configuration(configFile);
		System.out.println(configFile.getAbsolutePath());
        if(!configFile.exists())
        {
            try
            {
                configFile.createNewFile();
            }
            catch(IOException e)
            {
                System.out.println(e);
                return;
            }
        }
        config.load();
    }
	public static void SaveConfig()
    {
        GimmickeryConfiger.instance.config.save();
    }
	public static String GetGeneralProperties(String PropertyName, String DefaultValue)
    {
        return GimmickeryConfiger.instance.config.get("general", PropertyName, DefaultValue).getString();
    }
	public static int GetItemID(String ItemName, int DefaultValue)
    {
        return GimmickeryConfiger.instance.config.getItem("item", "ID." + ItemName, DefaultValue).getInt();
    }
    public static int GetBlockID(String BlockName, int DefaultID)
    {
        return GimmickeryConfiger.instance.config.getBlock("ID." + BlockName, DefaultID).getInt();
    }
    public static int GetRandomNameLength()
    {
        return GimmickeryConfiger.instance.config.get(Configuration.CATEGORY_GENERAL, "DEFAULT_RANDOM_NAME_LENGTH",8).getInt();
    }
    public static int GetCristalNameColor()
    {
        return GimmickeryConfiger.instance.config.get(Configuration.CATEGORY_GENERAL, "DEFAULT_CRISTAL_NAME_COLOR",0xFF0099FF).getInt();
    }
    
}
