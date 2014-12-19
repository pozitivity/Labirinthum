package com.tatiana.UseLWJGL.components.mainmenu;

import com.tatiana.UseLWJGL.sound.Sounds;
import com.tatiana.UseLWJGL.sound.impl.SoundLoader;
import com.tatiana.UseLWJGL.sound.impl.SoundManager;

public class InitState {
	
	Menu menu = new Menu();
	SoundLoader soundLoader = new SoundLoader();
	SoundManager soundManager = new SoundManager();
	
	public void initMain() {
		soundLoader.loadOggStreaming(Sounds.STARS_OGG.getName());
		soundManager.playOgg(true);
		menu.init();
	}
	
	public void drawMain() {
		menu.draw();
	}
	
	public void initIntro() {
		
	}
	
	public void initAbout() {
		
	}
	
	public void initGame() {
		
	}
}
