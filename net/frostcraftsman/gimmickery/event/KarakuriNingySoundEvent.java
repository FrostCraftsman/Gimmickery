package net.frostcraftsman.gimmickery.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class KarakuriNingySoundEvent {
	 @ForgeSubscribe
     public void onSoundLoad(SoundLoadEvent event) {
             event.manager.addSound("gimmickery:KarakuriNingySound.ogg");//refers to: gimmickery/sound/KarakuriNingySound.ogg
             event.manager.addSound("gimmickery:optionalFile/KarakuriNingySound.ogg");
             event.manager.addSound("gimmickery:optionalFile/optionalFile2/KarakuriNingySound.ogg");
     }
}
