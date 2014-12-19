package com.tatiana.UseLWJGL;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Font;
import java.awt.font.*;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.LWJGLException;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.SoundStore;

import com.tatiana.UseLWJGL.components.Draw;
import com.tatiana.UseLWJGL.components.Light;
import com.tatiana.UseLWJGL.components.Room;
import com.tatiana.UseLWJGL.components.Spheres;
import com.tatiana.UseLWJGL.components.fonts.Fonts;
import com.tatiana.UseLWJGL.components.mainmenu.GameState;
import com.tatiana.UseLWJGL.components.mainmenu.Menu;
import com.tatiana.UseLWJGL.components.stars.Stars;
import com.tatiana.UseLWJGL.components.world.WorldCore;
import com.tatiana.UseLWJGL.event.EventKeyboard;
import com.tatiana.UseLWJGL.event.EventMouse;
import com.tatiana.UseLWJGL.sound.SoundManager;
import com.tatiana.UseLWJGL.sound.Sounds;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.Storage;


public class App {
	
	Draw draw = new Draw();
	ParamsDisplay paramsDisplay = new ParamsDisplay();
	EventKeyboard keyboard = new EventKeyboard();
	EventMouse mouse = new EventMouse();
	Light light = new Light();
	SoundManager soundManager = new SoundManager();
	Stars stars = new Stars();
	WorldCore world = new WorldCore();
	//private Fonts font = new Fonts();
	Room room = new Room();
	Spheres sphere = new Spheres();
	Menu menu = new Menu();
	GameState state = new GameState();
	DisplayMode displayMode;
	
	TrueTypeFont font;
	Font awtFont;
	
	static Logger logger = Logger.getLogger(App.class.getName());
	
	
	public void start() throws IOException {
		try {
			init(false);
		} catch(LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		//initGL();
		//draw.initQuad();
		//stars.initStars();
		//font.initFont();
		//sphere.load();
		//room.init();
		//world.setupWorld();
		//world.initWorld();
		
		menu.init();
		
		soundManager.loadOggStreaming(Sounds.TRY_WAV.getName());
		
		while(!paramsDisplay.isDone()) {
			mainloop();
			//draw.renderQuad();
			//stars.renderStars();
			//world.renderWorld();
			//font.draw("Hello", Color.yellow, 0.1f, 0.35f);
			//room.renderRoom();
			//sphere.render();
			//Color.white.bind();
			menu.draw();
			
			SoundStore.get().poll(1);
			
			
			Display.update();
			//Display.sync(100);
		}
		AL.destroy();
		//menu.destroy();
		Display.destroy();
	}
	
	public void mainloop() {
		if (Display.isCloseRequested()) {
			paramsDisplay.setDone(true);
		}
		keyboard.commonCheckKey();
		//keyboard.drawCheckKey();
		//keyboard.starsCheckKey();
		//keyboard.worldCheckKey();
		//keyboard.sphereCheckKey();
		//keyboard.roomCheckKey();
		//keyboard.stateCheckKey();
		//mouse.commonCheckMouse();
		mouse.menuCheckMouse();
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
		// дефолтное положение мыши
		//mouse.setCursorPos(400, 300); 
		
		Display.setDisplayMode(displayMode);
		Display.create();
		
		GameState.setState(GameState.State.MAIN_MENU);
	}
	
	public void initGL() {
		
		GL11.glMatrixMode(GL11.GL_PROJECTION); // select the projection matrix
		GL11.glLoadIdentity(); // reset the projection matrix
		
		//calculate the aspect ratio of the window
		GLU.gluPerspective(
				45.0f, 
				(float) paramsDisplay.getDisplayWidth() / paramsDisplay.getDisplayHeight(), 
				0.1f, 
				100.0f);
		//GL11.glOrtho(0, paramsDisplay.getDisplayWidth(), 0, paramsDisplay.getDisplayHeight(), -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW); // select the modelview matrix
		GL11.glLoadIdentity();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D); // enable texture mapping
		GL11.glShadeModel(GL11.GL_SMOOTH); // enable smooth shading
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // black background
		GL11.glClearDepth(1.0); // Depth buffer setup
		GL11.glEnable(GL11.GL_DEPTH_TEST); // enables depth testing
		GL11.glDepthFunc(GL11.GL_LEQUAL); // the type of depth testing
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		
		//GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
		
		/*ByteBuffer temp = ByteBuffer.allocateDirect(16);
		temp.order(ByteOrder.nativeOrder());
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, 
				(FloatBuffer)temp.asFloatBuffer().put(light.getLightAmbient()).flip());              // Setup The Ambient Light
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, 
        		(FloatBuffer)temp.asFloatBuffer().put(light.getLightDiffuse()).flip());              // Setup The Diffuse Light
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION,
        		(FloatBuffer)temp.asFloatBuffer().put(light.getLightPosition()).flip());         // Position The Light
        GL11.glEnable(GL11.GL_LIGHT1); // enable light one*/
	}
	
	
    public static void main( String[] args ) throws IOException
    {
    	logger.log(Level.INFO, "init log");
        App displayApp = new App();
        displayApp.start();
    }
}
