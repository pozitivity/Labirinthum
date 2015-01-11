package com.tatiana.UseLWJGL.util;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Util {

	ParamsDisplay paramsDisplay = new ParamsDisplay();
	
	public FloatBuffer asFloatBuffer(float[] values) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(values.length);
		buffer.put(values);
		buffer.flip();
		return buffer;
	}
	
	public void make2D() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		// 2D режим
		glOrtho(0, 1366, 0, 768, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		// включение текстур
		glEnable(GL_TEXTURE_2D);
	}
	
	public void make3D() {
		//glEnable(GL_BLEND);
		
		glMatrixMode(GL_PROJECTION); // select the projection matrix
		glLoadIdentity(); // reset the projection matrix
		
		//calculate the aspect ratio of the window
		GLU.gluPerspective(
				45.0f, 
				(float) paramsDisplay.getDisplayWidth() / paramsDisplay.getDisplayHeight(), 
				0.1f, 
				100.0f);
		glMatrixMode(GL_MODELVIEW); // select the modelview matrix
		glLoadIdentity();
		
		glEnable(GL_TEXTURE_2D); // enable texture mapping
		glShadeModel(GL_SMOOTH); // enable smooth shading
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // black background
		glClearDepth(1.0); // Depth buffer setup
		glEnable(GL_DEPTH_TEST); // enables depth testing
		glDepthFunc(GL_LEQUAL); // the type of depth testing
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		
		glEnable(GL_NORMALIZE);

	}
}
