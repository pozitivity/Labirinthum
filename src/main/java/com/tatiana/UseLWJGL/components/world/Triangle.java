package com.tatiana.UseLWJGL.components.world;

public class Triangle {
	public Vertex vertex[];
	
	public Triangle() {
		vertex = new Vertex[3];
		for (int i = 0; i < 3; i++) {
			vertex[i] = new Vertex();
		}
	}
}
