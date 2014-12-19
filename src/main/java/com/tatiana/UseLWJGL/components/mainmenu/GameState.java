package com.tatiana.UseLWJGL.components.mainmenu;

public class GameState {
	
	// состояния игры
	public static enum State {
		INTRO,
		GAME,
		MAIN_MENU,
		ABOUT
	}
	
	static State state;
	
	public void checkState() {
		switch(state) {
		case INTRO:
			System.out.println("INTRO state");
			break;
		case GAME:
			System.out.println("GAME state");
			break;
		case MAIN_MENU:
			System.out.println("MAIN_MENU state");
			break;
		case ABOUT:
			System.out.println("ABOUT state");
			break;
		default:
			break;
		}
	}

	public static State getState() {
		return state;
	}

	public static void setState(State state) {
		GameState.state = state;
	}

	
}
