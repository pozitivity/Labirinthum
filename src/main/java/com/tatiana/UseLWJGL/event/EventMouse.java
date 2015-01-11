package com.tatiana.UseLWJGL.event;

import org.lwjgl.input.Mouse;

import com.tatiana.UseLWJGL.components.camera.Camera;
import com.tatiana.UseLWJGL.components.mainmenu.GameState;
import com.tatiana.UseLWJGL.components.mainmenu.Menu;
import com.tatiana.UseLWJGL.util.Storage;

public class EventMouse {
	
	public void menuCheckMouse() {
		
		// play game
		if ((Mouse.getX() > Storage.PLAY_LEFT_X.val() && Mouse.getX() < Storage.PLAY_RIGHT_X.val()) &&
				(Mouse.getY() < Storage.PLAY_TOP_Y.val() && Mouse.getY() > Storage.PLAY_BOTTOM_Y.val())) {
			Menu.setOnFocusPlay(true);
			
			if (Mouse.isButtonDown(0)) {
				System.out.println("State GAME choosen");
				GameState.setState(GameState.State.GAME_INIT);
			}
			
		} else { Menu.setOnFocusPlay(false); }
		
		// intro
		if ((Mouse.getX() > Storage.INTRO_LEFT_X.val() && Mouse.getX() < Storage.INTRO_RIGHT_X.val()) &&
				(Mouse.getY() < Storage.INTRO_TOP_Y.val() && Mouse.getY() > Storage.INTRO_BOTTOM_Y.val())) {
			Menu.setOnFocusIntro(true);
			
			if (Mouse.isButtonDown(0)) {
				System.out.println("State INTRO choosen");
				GameState.setState(GameState.State.INTRO_INIT);
			}
			
		} else { Menu.setOnFocusIntro(false); }
		
		//about
		if ((Mouse.getX() > Storage.ABOUT_LEFT_X.val() && Mouse.getX() < Storage.ABOUT_RIGHT_X.val()) &&
				(Mouse.getY() < Storage.ABOUT_TOP_Y.val() && Mouse.getY() > Storage.ABOUT_BOTTOM_Y.val())) {
			Menu.setOnFocusAbout(true);
			
			if (Mouse.isButtonDown(0)) {
				System.out.println("State ABOUT choosen");
				GameState.setState(GameState.State.ABOUT_INIT);
			}
			
		} else { Menu.setOnFocusAbout(false); }
	}
	
	public void gameCheckMouse() {
		if (Mouse.isButtonDown(0)) {
			Mouse.setGrabbed(true);
		}
		if (Mouse.isButtonDown(1)) {
			Mouse.setGrabbed(false);
		}
		
		// управление мышкой
		if (Mouse.isGrabbed()) {
			float mouseDX = Mouse.getDX() * 0.8f * 0.16f;
			float mouseDY = Mouse.getDY() * 0.8f * 0.16f;
			
			if (Camera.getRotation().y + mouseDX >= 360) {
				Camera.setRotationY(Camera.getRotation().y + mouseDX - 360);
			} else if (Camera.getRotation().y + mouseDX < 0) {
				Camera.setRotationY(360 - Camera.getRotation().y + mouseDX);
			} else {
				Camera.setRotationY(Camera.getRotation().y + mouseDX);
			}
			
			if (Camera.getRotation().x - mouseDY >= -89 &&
					Camera.getRotation().x - mouseDY <= 89) {
				Camera.setRotationX(Camera.getRotation().x - mouseDY);
			} else if(Camera.getRotation().x - mouseDY < -89) {
				Camera.setRotationX(-89);
			} else if(Camera.getRotation().x - mouseDY > 89) {
				Camera.setRotationX(89);
			}
		}
	}
}
