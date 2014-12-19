package com.tatiana.UseLWJGL.components;

import org.lwjgl.opengl.GL11;

public class Light {

	
	private float lightAmbient[] = { 0.5f, 0.5f, 0.5f, 1.0f }; // Ambient Light Values
	private float lightDiffuse[] = { 1.0f, 1.0f, 1.0f, 1.0f }; // Diffuse Light Values
    private float lightPosition[] = { 0.0f, 0.0f, 2.0f, 1.0f }; // Light Position
    
    private static int filter;
    private static boolean light;
    private static boolean blend;

	public float[] getLightAmbient() {
		return lightAmbient;
	}

	public void setLightAmbient(float[] lightAmbient) {
		this.lightAmbient = lightAmbient;
	}

	public float[] getLightDiffuse() {
		return lightDiffuse;
	}

	public void setLightDiffuse(float[] lightDiffuse) {
		this.lightDiffuse = lightDiffuse;
	}

	public float[] getLightPosition() {
		return lightPosition;
	}

	public void setLightPosition(float[] lightPosition) {
		this.lightPosition = lightPosition;
	}

	public int getFilter() {
		return filter;
	}

	public void setFilter(int filter) {
		this.filter = filter;
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
	
	public boolean isBlend() {
		return blend;
	}

	public void setBlend(boolean blend) {
		this.blend = blend;
	}

	public void disable() {
		GL11.glDisable(GL11.GL_LIGHTING);
	}
	
	public void enable() {
		GL11.glEnable(GL11.GL_LIGHTING);
	}
}
