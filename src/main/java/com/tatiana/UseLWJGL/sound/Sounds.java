package com.tatiana.UseLWJGL.sound;

public enum Sounds {
	TRY_OGG {
		public String getName() { return "try.ogg"; }
	},
	STARS_OGG {
		public String getName() { return "stars.ogg"; }
	};
	public abstract String getName();
}
