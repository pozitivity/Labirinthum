package com.tatiana.UseLWJGL.util.shader;

public enum Shaders {
	SCREEN_VERT {
		public String getName() { return "screen.vert"; }
	},
	SCREEN_FRAG {
		public String getName() { return "screen.frag"; }
	};
	public abstract String getName();
}
