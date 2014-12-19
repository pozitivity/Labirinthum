package com.tatiana.UseLWJGL.sound;

public enum Sounds {
	TRY_WAV {
		public String getName() { return "try.ogg"; }
	};
	public abstract String getName();
}
