package com.tatiana.UseLWJGL.components.mainmenu;

import java.io.IOException;
import java.util.logging.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.components.Light;
import com.tatiana.UseLWJGL.components.entities.Entity;
import com.tatiana.UseLWJGL.components.laby.Laby;
import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.Util;
import com.tatiana.UseLWJGL.util.texture.Textures;

import static org.lwjgl.opengl.GL11.*;

public class Menu implements Entity {

	private Texture labyrinthum;
	private Texture play;
	private Texture intro;
	private Texture about;
	
	private static boolean onFocusPlay = false;
	private static boolean onFocusIntro = false;
	private static boolean onFocusAbout = false;
	
	private int coordX, coordY;
	
	LoaderTexture loadtexture = new LoaderTexture();
	Laby laby = new Laby();
	Light light = new Light();
	Util util = new Util();
	
	Logger logger = Logger.getLogger(Menu.class.getName());
	
	public void init() {
		
		// загружаем текстуры
		initTextures();
		// размерность - 2d
		util.make2D();
		// 
		laby.init();
		
		light.disablebluelamp();
		light.disablegreenlamp();
		light.disableredlamp();
		
		glDisable(GL_LIGHTING);
	}

	public void draw() {
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		// координаты текстур
		coordX = (Display.getDisplayMode().getWidth() - labyrinthum.getImageWidth()) / 2;
		coordY = 550;
		
		labyrinthum.bind();
		
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2i(coordX - 5, coordY); // top left
			GL11.glTexCoord2f(0, 0); GL11.glVertex2i(coordX - 5, coordY + labyrinthum.getImageHeight()); // bottom left
			GL11.glTexCoord2f(1, 0); GL11.glVertex2i(coordX + labyrinthum.getImageWidth() - 5, coordY + labyrinthum.getImageHeight()); // bottom right
			GL11.glTexCoord2f(1, 1); GL11.glVertex2i(coordX + labyrinthum.getImageWidth() - 5, coordY); // top right
		GL11.glEnd();
		
		coordY -= labyrinthum.getImageHeight();
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
			GL11.glTexCoord2f(1, 0); GL11.glVertex2i(coordX + about.getImageWidth(), coordY + about.getImageHeight()); // bottom right
			GL11.glTexCoord2f(1, 1); GL11.glVertex2i(coordX + about.getImageWidth(), coordY); // top right
		GL11.glEnd();
		
		laby.draw();
		laby.render();
		
	}

	public void render() {
		
		
	}

	public void destroy() {
		
		labyrinthum.release();
		intro.release();
		about.release();
		play.release();
	}
	
	public void initTextures() {
		try {
			labyrinthum = loadtexture.readTexturePNG(Textures.LABYRINTHUM.getName());
			intro = loadtexture.readTexturePNG(Textures.INTRO.getName());
			about = loadtexture.readTexturePNG(Textures.ABOUT.getName());
			play = loadtexture.readTexturePNG(Textures.PLAYGAME.getName());
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
