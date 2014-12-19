package com.tatiana.UseLWJGL.components.stars;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.texture.Textures;

public class Stars {

	private ParamsDisplay paramsDisplay = new ParamsDisplay();
	private LoaderTexture loadtexture = new LoaderTexture();
	
	private static boolean twinkle; // twinkling stars
	private final int num = 50; // number of stars
	private StarCore[] star = new StarCore[num]; // need to keep trackof 'num' stars
	private static float zoom = -15.0f; // distance away from stars
	private float spin; // spin stars
	private static float tilt = 90.0f; // tilt the view
	
	private Texture texture;
	
	public void initStars() throws IOException {
		for (int i = 0; i < num; i++) {
			star[i] = new StarCore();
			star[i].setAngle(0.0f);
			star[i].setDist(((float) i / (float) num) * 5.0f);
			star[i].setR((byte) (Math.random() * 256.0));
			star[i].setG((byte) (Math.random() * 256.0));
			star[i].setB((byte) (Math.random() * 256.0));
		}
		
		texture = loadtexture.readTexture(Textures.STAR.getName());
	}
	
	public void renderStars() {
		GL11.glViewport(0, 0, paramsDisplay.getDisplayWidth(), paramsDisplay.getDisplayHeight());
		//Clear the screen and depth buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
		
		texture.bind();
		
		for (int i = 0; i < num; i++) // Loop Through All The Stars
        {
			GL11.glLoadIdentity(); // Reset The View Before We Draw Each Star
			GL11.glTranslatef(0.0f, 0.0f, zoom); // Zoom Into The Screen (Using The Value In 'zoom')
			GL11.glRotatef(tilt, 1.0f, 0.0f, 0.0f); // Tilt The View (Using The Value In 'tilt')
			GL11.glRotatef(star[i].getAngle(), 0.0f, 1.0f, 0.0f); // Rotate To The Current Stars Angle
			GL11.glTranslatef(star[i].getDist(), 0.0f, 0.0f); // Move Forward On The X Plane
			GL11.glRotatef(-star[i].getAngle(), 0.0f, 1.0f, 0.0f); // Cancel The Current Stars Angle
			GL11.glRotatef(-tilt, 1.0f, 0.0f, 0.0f); // Cancel The Screen Tilt

			if (twinkle) {
				GL11.glColor4ub(star[(num - i) - 1].getR(), star[(num - i) - 1].getG(), star[(num - i) - 1].getB(), (byte) 255);
				GL11.glBegin(GL11.GL_QUADS);
				GL11.glTexCoord2f(0.0f, 0.0f);
				GL11.glVertex3f(-1.0f, -1.0f, 0.0f);
				GL11.glTexCoord2f(1.0f, 0.0f);
				GL11.glVertex3f(1.0f, -1.0f, 0.0f);
            	GL11.glTexCoord2f(1.0f, 1.0f);
            	GL11.glVertex3f(1.0f, 1.0f, 0.0f);
            	GL11.glTexCoord2f(0.0f, 1.0f);
            	GL11.glVertex3f(-1.0f, 1.0f, 0.0f);
            	GL11.glEnd();
			}

			GL11.glRotatef(spin, 0.0f, 0.0f, 1.0f);
			GL11.glColor4ub(star[i].getR(), star[i].getG(), star[i].getB(), (byte) 255);
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex3f(-1.0f, -1.0f, 0.0f);
			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex3f(1.0f, -1.0f, 0.0f);
			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex3f(1.0f, 1.0f, 0.0f);
			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex3f(-1.0f, 1.0f, 0.0f);
			GL11.glEnd();

			spin += 0.01f;
			star[i].setAngle(star[i].getAngle() + (float) i / (float) num);
			star[i].setDist(star[i].getDist() - 0.01f);
			if (star[i].getDist() < 0.0f) {
				star[i].setDist(star[i].getDist() + 5.0f);
				star[i].setR((byte) (Math.random() * 256.0));
				star[i].setG((byte) (Math.random() * 256.0));
				star[i].setB((byte) (Math.random() * 256.0));
			}
        }
	}

	public boolean isTwinkle() {
		return twinkle;
	}

	public void setTwinkle(boolean twinkle) {
		this.twinkle = twinkle;
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
	}

	public float getTilt() {
		return tilt;
	}

	public void setTilt(float tilt) {
		this.tilt = tilt;
	}
}
