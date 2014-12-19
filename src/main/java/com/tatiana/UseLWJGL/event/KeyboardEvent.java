package com.tatiana.UseLWJGL.event;

import org.lwjgl.input.Keyboard;

import com.tatiana.UseLWJGL.sound.impl.SoundManager;

public class KeyboardEvent {

	int stateMusic = 0; // 1 - музыка играет, 0 - стоп
	
	SoundManager soundManager = new SoundManager();
	
	public void commonCheckKey() {
		while(Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_2) {
					switch (stateMusic) {
					// stop music
					case 0:
						soundManager.stopOgg();
						stateMusic = 1;
						break;
					// play music
					case 1: 
						soundManager.playOgg(true);
						stateMusic = 0;
						break;
					}
				}
			}
		}
	}
}
