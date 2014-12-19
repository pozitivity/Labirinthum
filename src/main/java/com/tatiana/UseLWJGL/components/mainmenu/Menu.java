package com.tatiana.UseLWJGL.components.mainmenu;

import java.io.IOException;
import java.util.logging.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.components.entities.Entity;
import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.texture.Textures;

public class Menu implements Entity {

	private Texture labirinthum;
	private Texture play;
	private Texture intro;
	private Texture about;
	
	private static boolean onFocusPlay = false;
	private static boolean onFocusIntro = false;
	private static boolean onFocusAbout = false;
	
	private int coordX, coordY;
	
	LoaderTexture loadtexture = new LoaderTexture();
	
	Logger logger = Logger.getLogger(Menu.class.getName());
	
	public void init() {
		
		// загружаем текстуры
		initTextures();
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		// 2D режим
		GL11.glOrtho(0, 1366, 0, 768, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		// включение текстур
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public void draw() {
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		// координаты текстур
		coordX = (Display.getDisplayMode().getWidth() - labirinthum.getImageWidth()) / 2;
		coordY = 550;
		
		labirinthum.bind();
		
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2i(coordX, coordY); // top left
			GL11.glTexCoord2f(0, 0); GL11.glVertex2i(coordX, coordY + labirinthum.getImageHeight()); // bottom left
			GL11.glTexCoord2f(1, 0); GL11.glVertex2i(coordX + labirinthum.getImageWidth(), coordY + labirinthum.getImageHeight()); // bottom right
			GL11.glTexCoord2f(1, 1); GL11.glVertex2i(coordX + labirinthum.getImageWidth(), coordY); // top right
		GL11.glEnd();
		
		coordY -= labirinthum.getImageHeight();
		coordY -= 100;
		
		play.bind();
		
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		if (onFocusPlay) { GL11.glColor3f(0.2f, 0.9f, 0.8f); }
		else { GL11.glColor3f(1.0f, 1.0f, 1.0f); }
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2i(coordX, coordY); // top left
			GL11.glTexCoord2f(0, 0); GL11.glVertex2i(coordX, coordY + play.getImageHeight()); // bottom left
			GL11.glTexCoord2f(1, 0); GL11.glVertex2i(coordX + play.getImageWidth(), coordY + play.getImageHeight()); // bottom right
			GL11.glTexCoord2f(1, 1); GL11.glVertex2i(coordX + play.getImageWidth(), coordY); // top right
		GL11.glEnd();
		
		coordY -= play.getImageHeight();
		
		intro.bind();
		
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		if (onFocusIntro) { GL11.glColor3f(0.2f, 0.9f, 0.8f); }
		else { GL11.glColor3f(1.0f, 1.0f, 1.0f); }
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2i(coordX, coordY); // top left
			GL11.glTexCoord2f(0, 0); GL11.glVertex2i(coordX, coordY + intro.getImageHeight()); // bottom left
			GL11.glTexCoord2f(1, 0); GL11.glVertex2i(coordX + intro.getImageWidth(), coordY + intro.getImageHeight()); // bottom right
			GL11.glTexCoord2f(1, 1); GL11.glVertex2i(coordX + intro.getImageWidth(), coordY); // top right
		GL11.glEnd();
		
		coordY -= intro.getImageHeight();
		
		about.bind();
		
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		if (onFocusAbout) { GL11.glColor3f(0.2f, 0.9f, 0.8f); }
		else { GL11.glColor3f(1.0f, 1.0f, 1.0f); }
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2i(coordX, coordY); // top left
			GL11.glTexCoord2f(0, 0); GL11.glVertex2i(coordX, coordY + about.getImageHeight()); // bottom left
			GL11.glTexCoord2f(1, 0); GL11.glVertex2i(coordX + about.getImageWidth(), coordY + labirinthum.getImageHeight()); // bottom right
			GL11.glTexCoord2f(1, 1); GL11.glVertex2i(coordX + about.getImageWidth(), coordY); // top right
		GL11.glEnd();
		
	}

	public void render() {
		
		
	}

	public void destroy() {
		labirinthum.release();
		intro.release();
		about.release();
		play.release();
	}
	
	public void initTextures() {
		try {
			labirinthum = loadtexture.readTexture(Textures.LABIRINTHUM.getName());
			intro = loadtexture.readTexture(Textures.INTRO.getName());
			about = loadtexture.readTexture(Textures.ABOUT.getName());
			play = loadtexture.readTexture(Textures.PLAYGAME.getName());
		} catch (IOException e) {
			
			logger.log(Level.SEVERE, "Failed to load textures", e);
		}
	}

	public static boolean isOnFocusPlay() {
		return onFocusPlay;
	}

	public static void setOnFocusPlay(boolean onFocusPlay) {
		Menu.onFocusPlay = onFocusPlay;
	}

	public static boolean isOnFocusIntro() {
		return onFocusIntro;
	}

	public static void setOnFocusIntro(boolean onFocusIntro) {
		Menu.onFocusIntro = onFocusIntro;
	}

	public static boolean isOnFocusAbout() {
		return onFocusAbout;
	}

	public static void setOnFocusAbout(boolean onFocusAbout) {
		Menu.onFocusAbout = onFocusAbout;
	}

}
