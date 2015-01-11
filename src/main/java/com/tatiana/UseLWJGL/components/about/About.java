package com.tatiana.UseLWJGL.components.about;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import com.tatiana.UseLWJGL.components.entities.Entity;
import com.tatiana.UseLWJGL.components.fonts.Fonts;
import com.tatiana.UseLWJGL.util.Storage;
import com.tatiana.UseLWJGL.util.Util;

public class About implements Entity {

	String fontName = "1979.ttf";
	Fonts fonts = new Fonts();
	TrueTypeFont font;
	
	Util util = new Util();
	
	Logger logger  = Logger.getLogger(this.getClass().getName());
	
	public void init() {
		try {
			fonts.loadFont(fontName, 30f);
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		// 2D режим
		GL11.glOrtho(0, Storage.WINDOW_WIDTH.val(), Storage.WINDOW_HEIGHT.val(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);  
		
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
	}

	public void draw() {
		fonts.draw("Hello, Gamer :)", Color.white, Storage.WINDOW_WIDTH.val() / 2 - 200, 50, true);
		fonts.draw("Here is a quick guide", Color.white, Storage.WINDOW_WIDTH.val() / 2 - 270, 100, false);
		fonts.draw("Sound off/on", Color.white, 50, 150, false);
		fonts.draw("Control 2", Color.white, 400, 150, false);
		fonts.draw("Light off/on", Color.white, 50, 200, false);
		fonts.draw("L", Color.white, 400, 200, false);
		fonts.draw("Exit", Color.white, 50, 250, false);
		fonts.draw("Escape", Color.white, 400, 250, false);
	}

	public void render() {
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
