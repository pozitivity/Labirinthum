package com.tatiana.UseLWJGL.components.stars;

public class StarCore {
	private byte r, g, b; // stars color
	private float dist;  // stars disatnce from center
	private float angle; // stars current angle
	public byte getR() {
		return r;
	}
	public void setR(byte r) {
		this.r = r;
	}
	public byte getG() {
		return g;
	}
	public void setG(byte g) {
		this.g = g;
	}
	public byte getB() {
		return b;
	}
	public void setB(byte b) {
		this.b = b;
	}
	public float getDist() {
		return dist;
	}
	public void setDist(float dist) {
		this.dist = dist;
	}
	public float getAngle() {
		return angle;
	}
	public void setAngle(float angle) {
		this.angle = angle;
	}
}
