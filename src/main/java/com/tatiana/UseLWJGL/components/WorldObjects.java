package com.tatiana.UseLWJGL.components;

public enum WorldObjects {
	WORLD {
		public String getName() { return "World.txt"; }
	},
	SPHERE {
		public String getName() { return "Sphere.txt"; }
	};
	public abstract String getName();
}
