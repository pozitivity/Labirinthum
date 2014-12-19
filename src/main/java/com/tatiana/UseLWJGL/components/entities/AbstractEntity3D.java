package com.tatiana.UseLWJGL.components.entities;

public abstract class AbstractEntity3D implements Entity3D {
	protected float x;
	protected float y;
	protected float z;
	
	public float getX() { return x; }
	public float getY() { return y; }
	public float getZ() { return z; }
	
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }
	public void setZ(float z) { this.z = z; }
	
	public void setLocation(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public abstract void setUp();
	public abstract void destroy();
	public abstract void draw();
}
