package com.tatiana.UseLWJGL.components.mainmenu;

import org.lwjgl.input.Mouse;

import com.tatiana.UseLWJGL.components.Room;
import com.tatiana.UseLWJGL.components.about.About;
import com.tatiana.UseLWJGL.components.camera.Camera;
import com.tatiana.UseLWJGL.components.camera.CameraControl;
import com.tatiana.UseLWJGL.event.EventMouse;
import com.tatiana.UseLWJGL.event.KeyboardEvent;
import com.tatiana.UseLWJGL.sound.Sounds;
import com.tatiana.UseLWJGL.sound.impl.SoundLoader;
import com.tatiana.UseLWJGL.sound.impl.SoundManager;
import com.tatiana.UseLWJGL.timing.Timer;

public class StateEvent {
	
	Menu menu = new Menu();
	Room room = new Room();
	About about = new About();
	EventMouse mouse = new EventMouse();
	KeyboardEvent keyboard = new KeyboardEvent();
	SoundLoader soundLoader = new SoundLoader();
	SoundManager soundManager = new SoundManager();
	
	public void initMain() {
		soundLoader.loadOggStreaming(Sounds.STARS_OGG.getName());
		soundManager.playOgg(true);
		menu.init();
	}
	
	public void drawMain() {
		mouse.menuCheckMouse();
		menu.draw();
	}
	
	public void destroyMain() {
		soundManager.stopOgg();
		menu.destroy();
	}
	
	public void initIntro() {
		
	}
	
	public void initAbout() {
		about.init();
	}
	
	public void drawAbout() {
		about.draw();
	}
	
	public void destroyAbout() {
		
	}
	
	public void initGame() {
		// initialize lastFrame
		Timer.getDelta();
		room.init();
		soundLoader.loadOggStreaming(Sounds.TRY_OGG.getName());
		soundManager.playOgg(true);
	}
	
	public void drawGame() {
		Timer.setLastFPS(Timer.getTime());
		mouse.gameCheckMouse();
		room.render();
		CameraControl.move(Camera.getSpeedCamera() * Timer.getDelta());
	}
	
	public void destroyGame() {
		soundManager.stopOgg();
		Mouse.setGrabbed(false);
		room.destroy();
	}
}
