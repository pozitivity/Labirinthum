package com.tatiana.UseLWJGL.components.mainmenu;

public class GameState {
	
	// состояния игры
	public static enum State {
		INTRO,
		GAME,
		MAIN_MENU,
		ABOUT,
		MAIN_MENU_INIT,
		INTRO_INIT,
		GAME_INIT,
		ABOUT_INIT
	}
	
	static State state;
	static State oldState;
	InitState initState = new InitState();
	
	public void checkState() {
		switch(state) {
		case INTRO_INIT:
			initState.initIntro();
			state = State.INTRO;
			break;
		case INTRO:
			break;
		case GAME_INIT: 
			initState.initGame();
			state = State.GAME;
			break;
		case GAME:
			break;
		case MAIN_MENU_INIT:
			initState.initMain();
			state = State.MAIN_MENU;
			break;
		case MAIN_MENU:
			initState.drawMain();
			break;
		case ABOUT_INIT:
			initState.initAbout();
			state = State.ABOUT;
			break;
		case ABOUT:
			break;
		default:
			break;
		}
		// запоминаем предыдущее состояние
		oldState = state;
	}

	public static State getState() {
		return state;
	}

	public static void setState(State state) {
		GameState.state = state;
	}

	
}
