package com.tatiana.UseLWJGL.components.fonts;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class Fonts {
	private TrueTypeFont font;
	private static Font awtFont;
	private boolean antiAlias = false;
	
	public void initFont() {
		awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, antiAlias);
	}
	
	public void draw(String text, Color color, float x, float y) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		Color.white.bind();
		font.drawString(x, y, text, color);
	}

	public TrueTypeFont getFont() {
		return font;
	}

	public void setFont(TrueTypeFont font) {
		this.font = font;
	}
	
}
