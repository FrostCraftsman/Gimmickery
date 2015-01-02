package net.frostcraftsman.gimmickery.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class PrinnyBlueSoundEvent 
{
	 @ForgeSubscribe
     public void onSoundLoad(SoundLoadEvent event) {
             event.manager.addSound("gimmickery:PrinnyBlueSound.ogg");//refers to: gimmickery/sound/KarakuriNingySound.ogg
             event.manager.addSound("gimmickery:optionalFile/PrinnyBlueSound.ogg");
             event.manager.addSound("gimmickery:optionalFile/optionalFile2/PrinnyBlueSound.ogg");
     }

}
