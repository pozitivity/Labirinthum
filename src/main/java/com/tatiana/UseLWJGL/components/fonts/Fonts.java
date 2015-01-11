package com.tatiana.UseLWJGL.components.fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import com.tatiana.UseLWJGL.util.Storage;

public class Fonts {
	private TrueTypeFont font;
	private static Font awtFont;
	private boolean antiAlias = false;
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void init() {
		awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, antiAlias);
	}
	
	public void loadFont(String fontName, float size) {
		InputStream in = ResourceLoader.getResourceAsStream(Storage.PATH_PROJECTS_TO_FONTS.getString() 
						+ fontName);
		try {
			awtFont = Font.createFont(Font.TRUETYPE_FONT, in);
		} catch (FontFormatException e) {
			logger.log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		awtFont = awtFont.deriveFont(size);// font size
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void draw(String text, Color color, float x, float y, boolean clear) {
		if (clear) {
			// очистка экрана
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		}
		Color.white.bind();
		font.drawString(x, y, text, color);
	}

	public TrueTypeFont getFont() {
		return font;
	}

	public void setFont(TrueTypeFont font) {
		this.font = font;
	}
	
	
	public void setSize(float size) {
		awtFont = awtFont.deriveFont(size);
		font = new TrueTypeFont(awtFont, false);
	}
	
}
