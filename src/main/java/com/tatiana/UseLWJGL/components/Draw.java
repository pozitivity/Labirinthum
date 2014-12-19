package com.tatiana.UseLWJGL.components;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.texture.Textures;

public class Draw {
	
	private float xrot, yrot; // rotation x, y, z
	
	private ParamsDisplay paramsDisplay = new ParamsDisplay();
	private LoaderTexture loadtexture = new LoaderTexture();
	private Light light = new Light();
	
	private float pos = 0.75f;
	private static float xspeed, yspeed;
	private static float z = -5.0f;
	
	private Texture texture;
	
	public void initQuad() throws IOException {
		texture = loadtexture.readTexture(Textures.WOOD.getName());
	}
	
	public void renderQuad() {
		GL11.glViewport(0, 0, paramsDisplay.getDisplayWidth(), paramsDisplay.getDisplayHeight());
		//Clear the screen and depth buffer
		//GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		//GL11.glLoadIdentity();
		
		GL11.glTranslatef(0.0f, 0.0f, z);
		GL11.glRotatef(xrot, 1.0f, 0.0f, 0.0f);
		GL11.glRotatef(yrot, 0.0f, 1.0f, 0.0f);
		
		texture.bind();
		texture.setTextureFilter(light.getFilter());
		
		GL11.glBegin(GL11.GL_QUADS);
			
			// front face
			GL11.glNormal3f(0.0f, 0.0f, 1.0f);
			GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(pos, pos, pos); // Top Right Of The Quad (Front)
			GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-pos, pos, pos); // Top Left Of The Quad (Front)
			GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-pos, -pos, pos); // Bottom Left Of The Quad (Front)
			GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(pos, -pos, pos); // Bottom Right Of The Quad (Front)
					
			// back face
			GL11.glNormal3f(0.0f, 0.0f, -1.0f);
			GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f( pos, -pos, -pos); // Bottom Left Of The Quad (Back)
			GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-pos, -pos, -pos); // Bottom Right Of The Quad (Back)
			GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-pos, pos, -pos); // Top Right Of The Quad (Back)
			GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(pos, pos, -pos); // Top Left Of The Quad (Back)
					
			// top face
			GL11.glNormal3f(0.0f, 1.0f, 1.0f);
			GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f( pos, pos,-pos); // Top Right Of The Quad (Top)
			GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-pos, pos, -pos); // Top Left Of The Quad (Top)
			GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-pos, pos, pos); // Bottom Left Of The Quad (Top)
			GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f( pos, pos, pos); // Bottom Right Of The Quad (Top)
			
			// bottom face
			GL11.glNormal3f(0.0f, -1.0f, 0.0f);
			GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(pos,-pos, pos); // Top Right Of The Quad (Bottom)
			GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-pos,-pos, pos); // Top Left Of The Quad (Bottom)
			GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-pos, -pos, -pos); // Bottom Left Of The Quad (Bottom)
			GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(pos, -pos, -pos); // Bottom Right Of The Quad (Bottom)
			
			// left face
			GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
			GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-pos, pos, pos); // Top Right Of The Quad (Left)
			GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-pos, pos, -pos); // Top Left Of The Quad (Left)
			GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-pos, -pos, -pos); // Bottom Left Of The Quad (Left)
			GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-pos, -pos, pos); // Bottom Right Of The Quad (Left)
			
			// right face
			GL11.glNormal3f(1.0f, 0.0f, 0.0f);
			GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(pos, pos, -pos); // Top Right Of The Quad (Right)
			GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(pos, pos, pos); // Top Left Of The Quad (Right)
			GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(pos, -pos, pos); // Bottom Left Of The Quad (Right)
			GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(pos, -pos, -pos); // Bottom Right Of The Quad (Right)
		
		GL11.glEnd();                                     // Done Drawing The Quad

		xrot += xspeed;
		yrot += yspeed;
                                       
	}
	
	public void updateQuad() {
		
	}

	public float getXspeed() {
		return xspeed;
	}

	public void setXspeed(float xspeed) {
		this.xspeed = xspeed;
	}

	public float getYspeed() {
		return yspeed;
	}

	public void setYspeed(float yspeed) {
		this.yspeed = yspeed;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
}
