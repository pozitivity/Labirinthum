package com.tatiana.UseLWJGL.components;

import com.tatiana.UseLWJGL.util.Util;

import static org.lwjgl.opengl.GL11.*;

public class Light {
	Util util = new Util();
	
	float light0_ambient[] = { 1.0f, 1.0f, 1.0f, 1.0f }; // Ambient Light Values
	float light0_diffuse[] = { 1.5f, 1.5f, 1.5f, 1.0f }; // Diffuse Light Values
    float light0_position[] = { 10.0f, 00.0f, -10.0f, 1.0f }; // Light Position
    
    float light2_ambient[] = { 0.2f, 0.8f, 0.2f, 1.0f };
    float light2_diffuse[] = {0.5f, 0.5f, 0.5f, 1.0f};
    float light2_position[] = {0.0f, 10.0f, -100.0f, 1.0f};
    float light2_specular[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    
    float light3_ambient[] = { 0.48f, 0.4f, 0.93f, 1.0f };
    float light3_diffuse[] = {0.8f, 0.8f, 0.8f, 1.0f};
    float light3_position[] = {-30.0f, 0.0f, -125.0f, 1.0f};
    float light3_specular[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    
    float light4_ambient[] = { 0.8f, 0.2f, 0.2f, 1.0f };
    float light4_diffuse[] = {1.5f, 1.5f, 1.5f, 1.0f};
    float light4_position[] = {30.0f, 0.0f, -115.0f, 1.0f};
    float light4_specular[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    
    float light6_ambient[] = { 0.2f, 0.5f, 0.2f, 1.0f };
    float light6_diffuse[] = {0.5f, 0.5f, 0.5f, 1.0f};
    float light6_position[] = {0.0f, 10.0f, -155.0f, 1.0f};
    float light6_specular[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    
    float light7_ambient[] = { 0.2f, 0.2f, 0.5f, 1.0f };
    float light7_diffuse[] = {0.8f, 0.8f, 0.8f, 1.0f};
    float light7_position[] = {-30.0f, 0.0f, -135.0f, 1.0f};
    float light7_specular[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    
    float light1_ambient[] = { 0.5f, 0.2f, 0.2f, 1.0f };
    float light1_diffuse[] = {1.5f, 1.5f, 1.5f, 1.0f};
    float light1_position[] = {30.0f, 0.0f, -145.0f, 1.0f};
    float light1_specular[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    
    
    private static int filter;
    private static boolean light;


	public int getFilter() {
		return filter;
	}

	public void setFilter(int filter) {
		Light.filter = filter;
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		Light.light = light;
	}
	
	public void disable() {
		glDisable(GL_LIGHTING);
		glDisable(GL_LIGHT0);
	}
	
	public void enable() {
		glEnable(GL_LIGHTING);
		glEnable(GL_LIGHT0);
	}
	
	public void setUpLight() {
		glEnable(GL_LIGHTING);
		glColorMaterial(GL_FRONT, GL_DIFFUSE);
		
		glLight(GL_LIGHT0, GL_AMBIENT, util.asFloatBuffer(light0_ambient));
		glLight(GL_LIGHT0, GL_DIFFUSE, util.asFloatBuffer(light0_diffuse));
		glLight(GL_LIGHT0, GL_POSITION, util.asFloatBuffer(light0_position));
		glLight(GL_LIGHT0, GL_SPECULAR, util.asFloatBuffer(light2_specular));
		
		glLight(GL_LIGHT2, GL_AMBIENT, util.asFloatBuffer(light2_ambient));
		glLight(GL_LIGHT2, GL_DIFFUSE, util.asFloatBuffer(light2_diffuse));
		glLight(GL_LIGHT2, GL_POSITION, util.asFloatBuffer(light2_position));
		glLight(GL_LIGHT2, GL_SPECULAR, util.asFloatBuffer(light2_specular));
		
		glLight(GL_LIGHT3, GL_AMBIENT, util.asFloatBuffer(light3_ambient));
		glLight(GL_LIGHT3, GL_DIFFUSE, util.asFloatBuffer(light3_diffuse));
		glLight(GL_LIGHT3, GL_POSITION, util.asFloatBuffer(light3_position));
		glLight(GL_LIGHT3, GL_SPECULAR, util.asFloatBuffer(light2_specular));
		
		glLight(GL_LIGHT4, GL_AMBIENT, util.asFloatBuffer(light4_ambient));
		glLight(GL_LIGHT4, GL_DIFFUSE, util.asFloatBuffer(light4_diffuse));
		glLight(GL_LIGHT4, GL_POSITION, util.asFloatBuffer(light4_position));
		glLight(GL_LIGHT4, GL_SPECULAR, util.asFloatBuffer(light2_specular));
	}
	
	public void setUpLightMirror() {
		glEnable(GL_LIGHTING);
		glColorMaterial(GL_FRONT, GL_DIFFUSE);
		
		glLight(GL_LIGHT6, GL_AMBIENT, util.asFloatBuffer(light6_ambient));
		glLight(GL_LIGHT6, GL_DIFFUSE, util.asFloatBuffer(light6_diffuse));
		glLight(GL_LIGHT6, GL_POSITION, util.asFloatBuffer(light6_position));
		glLight(GL_LIGHT6, GL_SPECULAR, util.asFloatBuffer(light6_specular));
		
		glLight(GL_LIGHT7, GL_AMBIENT, util.asFloatBuffer(light7_ambient));
		glLight(GL_LIGHT7, GL_DIFFUSE, util.asFloatBuffer(light7_diffuse));
		glLight(GL_LIGHT7, GL_POSITION, util.asFloatBuffer(light7_position));
		glLight(GL_LIGHT7, GL_SPECULAR, util.asFloatBuffer(light7_specular));
		
		glLight(GL_LIGHT1, GL_AMBIENT, util.asFloatBuffer(light1_ambient));
		glLight(GL_LIGHT1, GL_DIFFUSE, util.asFloatBuffer(light1_diffuse));
		glLight(GL_LIGHT1, GL_POSITION, util.asFloatBuffer(light1_position));
		glLight(GL_LIGHT1, GL_SPECULAR, util.asFloatBuffer(light1_specular));
	}
	
	public void disablegreenlamp() {
		glDisable(GL_LIGHT2);
		glDisable(GL_LIGHT6);
	}
	
	public void enablegreenlamp() {
		glEnable(GL_LIGHT2);
		glEnable(GL_LIGHT6);
	}
	
	public void disablebluelamp() {
		glDisable(GL_LIGHT3);
		glDisable(GL_LIGHT7);
	}
	
	public void enablebluelamp() {
		glEnable(GL_LIGHT3);
		glEnable(GL_LIGHT7);
	}
	
	public void disableredlamp() {
		glDisable(GL_LIGHT4);
		glDisable(GL_LIGHT1);
	}
	
	public void enableredlamp() {
		glEnable(GL_LIGHT4);
		glEnable(GL_LIGHT1);
	}
}
