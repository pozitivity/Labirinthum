package com.tatiana.UseLWJGL.event;

import org.lwjgl.input.Mouse;

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
				GameState.setState(GameState.State.GAME);
			}
			
		} else { Menu.setOnFocusPlay(false); }
		
		// intro
		if ((Mouse.getX() > Storage.INTRO_LEFT_X.val() && Mouse.getX() < Storage.INTRO_RIGHT_X.val()) &&
				(Mouse.getY() < Storage.INTRO_TOP_Y.val() && Mouse.getY() > Storage.INTRO_BOTTOM_Y.val())) {
			Menu.setOnFocusIntro(true);
			
			if (Mouse.isButtonDown(0)) {
				System.out.println("State INTRO choosen");
				GameState.setState(GameState.State.INTRO);
			}
			
		} else { Menu.setOnFocusIntro(false); }
		
		//about
		if ((Mouse.getX() > Storage.ABOUT_LEFT_X.val() && Mouse.getX() < Storage.ABOUT_RIGHT_X.val()) &&
				(Mouse.getY() < Storage.ABOUT_TOP_Y.val() && Mouse.getY() > Storage.ABOUT_BOTTOM_Y.val())) {
			Menu.setOnFocusAbout(true);
			
			if (Mouse.isButtonDown(0)) {
				System.out.println("State ABOUT choosen");
				GameState.setState(GameState.State.ABOUT);
			}
			
		} else { Menu.setOnFocusAbout(false); }
	}
	
}
