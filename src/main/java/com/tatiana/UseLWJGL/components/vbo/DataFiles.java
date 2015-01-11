package com.tatiana.UseLWJGL.components.vbo;

public enum DataFiles {

	TRIANGLE_CORRIDOR {
		public String getName() { return "triangle_corridor.txt"; }
	},
	BIG_ROOM {
		public String getName() { return "big_room.txt"; }
	};
	public abstract String getName();
}
