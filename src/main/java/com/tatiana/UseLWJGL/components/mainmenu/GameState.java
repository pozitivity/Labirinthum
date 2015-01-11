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
	StateEvent eventState = new StateEvent();
	
	public void checkState() {
		if (state != oldState && oldState != null) {
			destroy(oldState);
		}
		switch(state) {
		case INTRO_INIT:
			eventState.initIntro();
			state = State.INTRO;
			break;
		case INTRO:
			break;
		case GAME_INIT: 
			eventState.initGame();
			state = State.GAME;
			break;
		case GAME:
			eventState.drawGame();
			break;
		case MAIN_MENU_INIT:
			eventState.initMain();
			state = State.MAIN_MENU;
			break;
		case MAIN_MENU:
			eventState.drawMain();
			break;
		case ABOUT_INIT:
			eventState.initAbout();
			state = State.ABOUT;
			break;
		case ABOUT:
			eventState.drawAbout();
			break;
		default:
			break;
		}
		// запоминаем предыдущее состояние
		if (state != State.MAIN_MENU_INIT && state != State.GAME_INIT
				&& state != State.ABOUT_INIT && state != State.INTRO_INIT)
			oldState = state;
	}
	
	public void destroy(State oldState) {
		switch(oldState) {
		case MAIN_MENU:
			eventState.destroyMain();
			break;
		case GAME:
			eventState.destroyGame();
			break;
		case INTRO:
			break;
		case ABOUT:
			eventState.destroyAbout();
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
