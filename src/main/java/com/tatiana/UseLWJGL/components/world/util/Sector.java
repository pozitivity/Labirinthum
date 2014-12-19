package com.tatiana.UseLWJGL.components.world.util;


public class Sector {
	public int numTriangles;
	public Triangle triangle[];
	
	public Sector(int numTriangles) {
		this.numTriangles = numTriangles;
		
		triangle = new Triangle[numTriangles];
		
		for (int i = 0; i < numTriangles; i++) {
			triangle[i] = new Triangle();
		}
	}
}
