package com.tatiana.UseLWJGL.components.world.util;

import com.tatiana.UseLWJGL.components.WorldObject;

public class Vertex {
	public float x, y, z;
	public float u, v;
	
	public Vertex calculate(int i, WorldObject sour, WorldObject dest, int steps) {
		Vertex a = new Vertex();                                           // Temporary Vertex Called a

        a.x=(sour.points[i].x - dest.points[i].x) / steps;    // a.x Value Equals Source x - Destination x Divided By Steps
        a.y=(sour.points[i].y - dest.points[i].y) / steps;    // a.y Value Equals Source y - Destination y Divided By Steps
        a.z=(sour.points[i].z - dest.points[i].z) / steps;    // a.z Value Equals Source z - Destination z Divided By Steps

        return a;                  
	}
}
