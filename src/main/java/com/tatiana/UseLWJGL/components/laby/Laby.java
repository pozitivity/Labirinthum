package com.tatiana.UseLWJGL.components.laby;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.components.entities.Entity;
import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.Storage;
import com.tatiana.UseLWJGL.util.texture.Textures;

public class Laby implements Entity {

	LoaderTexture loaderTexture = new LoaderTexture();
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	Texture laby1;
	Texture laby2;
	Texture laby3;
	Texture laby4;
	Texture laby5;
	Texture laby6;
	
	
	int xLaby_1 = 200;
	float xLaby_2 = 100;
	int xLaby_3 = 1000;
	float xLaby_4 = 1150;
	int xLaby_5 = 1100;
	int xLaby_6 = 900;
	
	float yLaby_1 = 768;
	float yLaby_2 = 768;
	float yLaby_3 = 768;
	float yLaby_4 = 200;
	float yLaby_5 = 768;
	float yLaby_6 = 300;
	
	int size1 = 50;
	int size2 = 100;
	int size3 = 100;
	float size4 = 150;
	int size5 = 50;
	int size6 = 200;
	
	float x04 = xLaby_4 + size4 / 2;
	float y04 = yLaby_4 - size4 / 2;
	
	int r = 30;
	
	double pi_180 = 0.01745329251994;
	
	float delta  = 0.0f; // угол вращения 
	
	public void initTextures() throws IOException {
		laby1 = loaderTexture.readTexturePNG(Textures.LABY_1.getName());
		laby2 = loaderTexture.readTexturePNG(Textures.LABY_2.getName());
		laby3 = loaderTexture.readTexturePNG(Textures.LABY_3.getName());
		laby4 = loaderTexture.readTexturePNG(Textures.LABY_4.getName());
		laby5 = loaderTexture.readTexturePNG(Textures.LABY_5.getName());
		laby6 = loaderTexture.readTextureJPG(Textures.LABY_6.getName());
	}
	
	public void draw() {
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		
		laby1.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0); GL11.glVertex2f(xLaby_1, yLaby_1);
			GL11.glTexCoord2f(1, 0); GL11.glVertex2f(xLaby_1 + size1, yLaby_1);
			GL11.glTexCoord2f(1, 1); GL11.glVertex2f(xLaby_1 + size1, yLaby_1 - size1);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2f(xLaby_1, yLaby_1 - size1);
		GL11.glEnd();
		
		laby2.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0); GL11.glVertex2f(xLaby_2, yLaby_2);
			GL11.glTexCoord2f(1, 0); GL11.glVertex2f(xLaby_2 + size2, yLaby_2);
			GL11.glTexCoord2f(1, 1); GL11.glVertex2f(xLaby_2 + size2, yLaby_2 - size2);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2f(xLaby_2, yLaby_2 - size2);
		GL11.glEnd();
		
		laby3.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0); GL11.glVertex2f(xLaby_3, yLaby_3);
			GL11.glTexCoord2f(1, 0); GL11.glVertex2f(xLaby_3 + size3, yLaby_3);
			GL11.glTexCoord2f(1, 1); GL11.glVertex2f(xLaby_3 + size3, yLaby_3 - size3);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2f(xLaby_3, yLaby_3 - size3);
		GL11.glEnd();
		
		laby4.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0); GL11.glVertex2f(xLaby_4, yLaby_4);
			GL11.glTexCoord2f(1, 0); GL11.glVertex2f(xLaby_4 + size4, yLaby_4);
			GL11.glTexCoord2f(1, 1); GL11.glVertex2f(xLaby_4 + size4, yLaby_4 - size4);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2f(xLaby_4, yLaby_4 - size4);
		GL11.glEnd();
		
		laby5.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0); GL11.glVertex2f(xLaby_5, yLaby_5);
			GL11.glTexCoord2f(1, 0); GL11.glVertex2f(xLaby_5 + size5 * 2, yLaby_5);
			GL11.glTexCoord2f(1, 1); GL11.glVertex2f(xLaby_5 + size5 * 2, yLaby_5 - size5);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2f(xLaby_5, yLaby_5 - size5);
		GL11.glEnd();
		
		laby6.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0); GL11.glVertex2f(xLaby_6, yLaby_6);
			GL11.glTexCoord2f(1, 0); GL11.glVertex2f(xLaby_6 + size6, yLaby_6);
			GL11.glTexCoord2f(1, 1); GL11.glVertex2f(xLaby_6 + size6, yLaby_6 - size6);
			GL11.glTexCoord2f(0, 1); GL11.glVertex2f(xLaby_6, yLaby_6 - size6);
		GL11.glEnd();
		
		
	}

	public void init() {
		try {
			initTextures();
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		
	}

	public void render() {
		if(yLaby_2 > 0 &&  xLaby_4 > 0) {
			yLaby_2 -= 0.1f;
			xLaby_2 -= 0.03f;
		} else { 
			yLaby_2 = 768; 
			xLaby_2 = 100;
		}
		
		if (yLaby_5 > 0 && xLaby_5 < Storage.WINDOW_WIDTH.val()) {
			yLaby_5 -= 0.08f;
			xLaby_5 += 0.3f;
		} else {
			yLaby_5 = Storage.WINDOW_WIDTH.val();
			xLaby_5 = 1100;
		}
		
		if(yLaby_1 > 0) {
			yLaby_1 -= 00.2f;
		} else { 
			yLaby_1 = 768; 
		}
		
		if (delta < 360.0f) {
			xLaby_4 = (float) (x04 + r * (Math.cos((delta + 45) * pi_180)));
			yLaby_4 = (float) (y04 - r * (Math.sin((delta + 45) * pi_180)));
			delta += 0.5f;
		} else { delta = 0.0f; }
	}

	public void destroy() {
		laby1.release();
		laby2.release();
		laby3.release();
		laby4.release();
		laby5.release();
		laby6.release();
	}
}
