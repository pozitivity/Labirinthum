package com.tatiana.UseLWJGL.event;

import org.lwjgl.input.Keyboard;

import com.tatiana.UseLWJGL.components.Light;
import com.tatiana.UseLWJGL.components.camera.Camera;
import com.tatiana.UseLWJGL.components.mainmenu.GameState;
import com.tatiana.UseLWJGL.sound.impl.SoundManager;
import com.tatiana.UseLWJGL.util.ParamsDisplay;

public class KeyboardEvent {

	int stateMusic = 0; // 1 - музыка играет, 0 - стоп
	boolean pressedLight = false;
	boolean pressedLightgreenLamp = false;
	boolean pressedLightblueLamp = false;
	boolean pressedLightredLamp = false;
	
	SoundManager soundManager = new SoundManager();
	ParamsDisplay paramsDisplay = new ParamsDisplay();
	Light light = new Light();
	
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
				if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
					if (GameState.getState() == GameState.State.MAIN_MENU) {
						paramsDisplay.setDone(true);
					} else {
						GameState.setState(GameState.State.MAIN_MENU_INIT);
					}
				}
				if (GameState.getState() == GameState.State.GAME) {
					if (Keyboard.getEventKey() == Keyboard.KEY_L) {
						if (pressedLight == true) {
							pressedLight = false;
							light.disable();
						} else {
							pressedLight = true;
							light.enable();
						}
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_G) {
						if (pressedLightgreenLamp == true) {
							pressedLightgreenLamp = false;
							light.disablegreenlamp();
						} else {
							pressedLightgreenLamp = true;
							light.enablegreenlamp();
						}
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_B) {
						if (pressedLightblueLamp == true) {
							pressedLightblueLamp = false;
							light.disablebluelamp();
						} else {
							pressedLightblueLamp = true;
							light.enablebluelamp();
						}
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_R) {
						if (pressedLightredLamp == true) {
							pressedLightredLamp = false;
							light.disableredlamp();
						} else {
							pressedLightredLamp = true;
							light.enableredlamp();
						}
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_Q) {
						Camera.setKeyfast(true);
					}
					if (Keyboard.getEventKey() == Keyboard.KEY_E) {
						Camera.setKeyslow(true);
					}
				}
			}
		}
		
		if (GameState.getState() == GameState.State.GAME) {
			if (Keyboard.isKeyDown(Keyboard.KEY_W) || 
					Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				Camera.setKeyup(true);
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_S) 
					|| Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
				Camera.setKeydown(true);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_A) 
					|| Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
				Camera.setKeyleft(true);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D) 
					|| Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
				Camera.setKeyright(true);
				
			}
		}
	}
}
