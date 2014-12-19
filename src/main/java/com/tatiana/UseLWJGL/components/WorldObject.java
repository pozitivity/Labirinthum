package com.tatiana.UseLWJGL.components;

import com.tatiana.UseLWJGL.components.world.util.Vertex;

public class WorldObject {
	int verts;
	public Vertex points[];
	
	public void objallocate(WorldObject k, int n) {
		k.verts = n;
		k.points = new Vertex[n];
		for (int i = 0; i < n; i++) {
			k.points[i] = new Vertex();
		}
	}
}
