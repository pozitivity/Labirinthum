package com.tatiana.UseLWJGL.util;

public enum Storage {
	WINDOW_WIDTH {
		public int val() { return 1366; }
		public String getString() { return null; }
	},
	WINDOW_HEIGHT {
		public int val() { return 768; }
		public String getString() { return null; }
	},
	FULL_WINDOW_WIDTH {
		public int val() { return 1920; }
		public String getString() { return null; }
	},
	FULL_WINDOW_HEIGHT {
		public int val() { return 1080; }
		public String getString() { return null; }
	},
	
	PATH_PROJECTS_TO_TEXTURE {
		public int val() { return 0; }
		public String getString() { return "target/texture/"; }
	},
	PATH_PROJECTS_TO_SOUND {
		public int val() { return 0; }
		public String getString() { return "target/sound/"; }
	},
	PATH_PROJECTS_TO_DATA {
		public int val() { return 0; }
		public String getString() { return "target/data/"; }
	},
	PATH_PROJECTS_TO_FONTS {
		public int val() { return 0; }
		public String getString() { return "target/texture/util/fonts/"; }
	},
	PATH_PROJECTS_TO_SHADERS {
		public int val() { return 0; }
		public String getString() { return "target/shaders/"; }
	},
	PLAY_LEFT_X {
		public int val() { return 550; }
		public String getString() { return null; }
	},
	PLAY_RIGHT_X {
		public int val() { return 810; }
		public String getString() { return null; }
	},
	PLAY_TOP_Y {
		public int val() { return 410; }
		public String getString() { return null; }
	},
	PLAY_BOTTOM_Y {
		public int val() { return 360; }
		public String getString() { return null; }
	},
	INTRO_LEFT_X {
		public int val() { return 600; }
		public String getString() { return null; }
	},
	INTRO_RIGHT_X {
		public int val() { return 755; }
		public String getString() { return null; }
	},
	INTRO_TOP_Y {
		public int val() { return 280; }
		public String getString() { return null; }
	},
	INTRO_BOTTOM_Y {
		public int val() { return 235; }
		public String getString() { return null; }
	},
	ABOUT_LEFT_X {
		public int val() { return 595; }
		public String getString() { return null; }
	},
	ABOUT_RIGHT_X {
		public int val() { return 765; }
		public String getString() { return null; }
	},
	ABOUT_TOP_Y {
		public int val() { return 155; }
		public String getString() { return null; }
	},
	ABOUT_BOTTOM_Y {
		public int val() { return 105; }
		public String getString() { return null; }
	};
	public abstract int val();
	public abstract String getString();
}
