package net.frostcraftsman.gimmickery.configration;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;

public class GimmickeryConfiger {
	private Configuration config;
	public GimmickeryConfiger(File configFile)
    {
        config = new Configuration(configFile);
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
	public void SaveConfig()
    {
        this.config.save();
    }
	public String GetGeneralProperties(String PropertyName, String DefaultValue)
    {
        return this.config.get("general", PropertyName, DefaultValue).getString();
    }
	public int GetItemID(String ItemName, int DefaultValue)
    {
        return this.config.getItem("item", "ID." + ItemName, DefaultValue).getInt();
    }
    public int GetBlockID(String BlockName, int DefaultID)
    {
        return this.config.getBlock("ID." + BlockName, DefaultID).getInt();
    }
    public  int GetRandomNameLength()
    {
        return this.config.get(Configuration.CATEGORY_GENERAL, "DEFAULT_RANDOM_NAME_LENGTH",8).getInt();
    }
    public  int GetCristalNameColor()
    {
        return this.config.get(Configuration.CATEGORY_GENERAL, "DEFAULT_CRISTAL_NAME_COLOR",0xFF0099FF).getInt();
    }
    
}
