package com.tatiana.UseLWJGL.components.world;

public class WorldObjects {
	public int numTriangles;
	public Triangle triangle[];
	public String type;
	public WorldObjects(int num) {
		numTriangles = num;
		triangle = new Triangle[numTriangles];
		for (int i = 0; i < numTriangles; i++) {
			triangle[i] = new Triangle();
		}
	}
}

