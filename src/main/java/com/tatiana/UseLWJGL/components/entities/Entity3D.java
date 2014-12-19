package com.tatiana.UseLWJGL.components.entities;

public interface Entity3D {
	public float getX();
	public void setX(float x);
	
	public float getY();
	public void setY(float y);
	
	public float getZ();
	public void setZ(float z);
	
	public void setLocation(float x, float y, float z);
	
	public void setUp();
	
	public void destroy();
	public void draw();
} 
