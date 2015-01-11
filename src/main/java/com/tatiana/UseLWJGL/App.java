package com.tatiana.UseLWJGL;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;


import org.lwjgl.openal.AL;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.LWJGLException;
import org.newdawn.slick.openal.SoundStore;

import com.tatiana.UseLWJGL.components.Light;
import com.tatiana.UseLWJGL.components.Room;
import com.tatiana.UseLWJGL.components.mainmenu.GameState;
import com.tatiana.UseLWJGL.components.mainmenu.Menu;
import com.tatiana.UseLWJGL.event.EventMouse;
import com.tatiana.UseLWJGL.event.KeyboardEvent;
import com.tatiana.UseLWJGL.sound.impl.SoundLoader;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.Storage;
import com.tatiana.UseLWJGL.util.Util;

public class App {

	ParamsDisplay paramsDisplay = new ParamsDisplay();
	KeyboardEvent keyboard = new KeyboardEvent();
	EventMouse mouse = new EventMouse();
	Light light = new Light();
	SoundLoader soundLoader = new SoundLoader();
	Room room = new Room();
	Menu menu = new Menu();
	Util util = new Util();
	GameState state = new GameState();
	DisplayMode displayMode;
	
	
	static Logger logger = Logger.getLogger(App.class.getName());
	
	
	public void start() throws IOException {
		try {
			init(true);
		} catch(LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		while(!paramsDisplay.isDone()) {
			gameloop();
			SoundStore.get().poll(1);
			
			Display.update();
			Display.sync(60);
		}
		AL.destroy();
		Display.destroy();
	}
	
	public void gameloop() {
		if (Display.isCloseRequested()) {
			paramsDisplay.setDone(true);
		}
		keyboard.commonCheckKey();
		state.checkState();
	}
	
	public void init(boolean fullScreen) throws LWJGLException {
		paramsDisplay.setDisplayHeight(Storage.WINDOW_HEIGHT.val());
		paramsDisplay.setDisplayWidth(Storage.WINDOW_WIDTH.val());
		paramsDisplay.setFullScreen(fullScreen);
		
		Display.setFullscreen(fullScreen);
		DisplayMode d[] = Display.getAvailableDisplayModes();
		for (int i = 0; i < d.length; i++) {
			if (d[i].getWidth() == paramsDisplay.getDisplayWidth() && 
					d[i].getHeight() == paramsDisplay.getDisplayHeight() &&
					d[i].getBitsPerPixel() == 32) {
				displayMode = d[i];
				break;
			}
		}
		
		Display.setDisplayMode(displayMode);
		
		Display.setVSyncEnabled(true);
		Display.setTitle("Shader Example");
		
		// set up OpenGL to run in forward-compatible mode
		// so that using deprecated functionality will
		// throw an error.
		PixelFormat pixelFormat = new PixelFormat();
		ContextAttribs contextAtrributes = new ContextAttribs(3, 2);
		contextAtrributes.withForwardCompatible(true);
		contextAtrributes.withProfileCore(true);
		
		Display.create(pixelFormat, contextAtrributes);
		// при первом запуске игры начальное состояние - инициализация меню
		GameState.setState(GameState.State.MAIN_MENU_INIT);
	}
	
    public static void main( String[] args ) throws IOException
    {
    	logger.log(Level.INFO, "init log");
        App displayApp = new App();
        displayApp.start();
    }
}
