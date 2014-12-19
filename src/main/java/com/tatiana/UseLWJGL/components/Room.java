package com.tatiana.UseLWJGL.components;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.event.Move;
import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.texture.Textures;

public class Room {
	
	private ParamsDisplay paramsDisplay = new ParamsDisplay();
	LoaderTexture loadtexture = new LoaderTexture();
	Texture texture;
	Move move = new Move();
	
	public void init() {
		try {
			texture = loadtexture.readTexture(Textures.WOOD.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void renderRoom() {
		GL11.glViewport(0, 0, paramsDisplay.getDisplayWidth(), paramsDisplay.getDisplayHeight());
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);
		GL11.glLoadIdentity();
		
		float xtrans = -move.xpos;
		float ztrans = -move.zpos;
		float ytrans = -move.walkbias - 0.25f;
		float sceneroty = 360.0f - move.yrot;
		
		GL11.glRotatef(move.lookupdown, 1.0f, 0, 0);
		GL11.glRotatef(sceneroty, 0, 1.0f, 0);
		
		GL11.glTranslatef(xtrans, ytrans, ztrans);
        
		texture.bind();
		GL11.glBegin(GL11.GL_QUADS);                                  // Begin Drawing Quads
        	// Floor
        	GL11.glNormal3f(0.0f, 1.0f, 0.0f);                   // Normal Pointing Up
        	GL11.glTexCoord2f(1, 1); GL11.glVertex3f(-10.0f,-10.0f,-20.0f);               // Back Left
        	GL11.glTexCoord2f(1, 0); GL11.glVertex3f(-10.0f,-10.0f, 20.0f);               // Front Left
        	GL11.glTexCoord2f(0, 0); GL11.glVertex3f( 10.0f,-10.0f, 20.0f);               // Front Right
        	GL11.glTexCoord2f(0, 1); GL11.glVertex3f( 10.0f,-10.0f,-20.0f);               // Back Right
        	// Ceiling
        	GL11.glNormal3f(0.0f,-1.0f, 0.0f);                   // Normal Point Down
        	GL11.glTexCoord2f(0, 1); GL11.glVertex3f(-10.0f, 10.0f, 20.0f);               // Front Left
        	GL11.glTexCoord2f(0, 0); GL11.glVertex3f(-10.0f, 10.0f,-20.0f);               // Back Left
        	GL11.glTexCoord2f(1, 0); GL11.glVertex3f( 10.0f, 10.0f,-20.0f);               // Back Right
        	GL11.glTexCoord2f(1, 1); GL11.glVertex3f( 10.0f, 10.0f, 20.0f);               // Front Right
        	// Front Wall
        	GL11.glNormal3f(0.0f, 0.0f, 1.0f);                   // Normal Pointing Away From Viewer
        	GL11.glTexCoord2f(0, 1); GL11.glVertex3f(-10.0f, 10.0f,-20.0f);               // Top Left
        	GL11.glTexCoord2f(0, 0); GL11.glVertex3f(-10.0f,-10.0f,-20.0f);               // Bottom Left
        	GL11.glTexCoord2f(1, 0); GL11.glVertex3f( 10.0f,-10.0f,-20.0f);               // Bottom Right
        	GL11.glTexCoord2f(1, 1); GL11.glVertex3f( 10.0f, 10.0f,-20.0f);               // Top Right
        	// Back Wall
        	GL11.glNormal3f(0.0f, 0.0f,-1.0f);                   // Normal Pointing Towards Viewer
        	GL11.glVertex3f( 10.0f, 10.0f, 20.0f);               // Top Right
        	GL11.glVertex3f( 10.0f,-10.0f, 20.0f);               // Bottom Right
        	GL11.glVertex3f(-10.0f,-10.0f, 20.0f);               // Bottom Left
        	GL11.glVertex3f(-10.0f, 10.0f, 20.0f);               // Top Left
        	// Left Wall
        	GL11.glNormal3f(1.0f, 0.0f, 0.0f);                   // Normal Pointing Right
        	GL11.glTexCoord2f(0, 1); GL11.glVertex3f(-10.0f, 10.0f, 20.0f);               // Top Front
        	GL11.glTexCoord2f(0, 0); GL11.glVertex3f(-10.0f,-10.0f, 20.0f);               // Bottom Front
        	GL11.glTexCoord2f(1, 0); GL11.glVertex3f(-10.0f,-10.0f,-20.0f);               // Bottom Back
        	GL11.glTexCoord2f(1, 1); GL11.glVertex3f(-10.0f, 10.0f,-20.0f);               // Top Back
        	// Right Wall
        	GL11.glNormal3f(-1.0f, 0.0f, 0.0f);                  // Normal Pointing Left
        	GL11.glTexCoord2f(0, 1); GL11.glVertex3f( 10.0f, 10.0f,-20.0f);               // Top Back
        	GL11.glTexCoord2f(0, 0); GL11.glVertex3f( 10.0f,-10.0f,-20.0f);               // Bottom Back
        	GL11.glTexCoord2f(1, 0); GL11.glVertex3f( 10.0f,-10.0f, 20.0f);               // Bottom Front
        	GL11.glTexCoord2f(1, 1); GL11.glVertex3f( 10.0f, 10.0f, 20.0f);               // Top Front
        GL11.glEnd(); 
	}
}
