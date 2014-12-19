package com.tatiana.UseLWJGL.util.texture;

public enum Textures {
	STAR {
		public String getName() { return "star.png"; }
	},
	WOOD {
		public String getName() { return "wood.jpg"; }
	},
	BRICK {
		public String getName() { return "brick.jpg"; } 
	},
	CELL {
		public String getName() { return "cell.jpg"; } 
	},
	GRUNGE {
		public String getName() { return "grunge.jpg"; } 
	},
	SKIN {
		public String getName() { return "skin.jpg"; } 
	},
	GALAXY {
		public String getName() { return "galaxy5.png"; }
	},
	SPACE {
		public String getName() { return "space.jpg"; }
	},
	LABIRINTHUM {
		public String getName() { return "labirinthum.png"; }
	},
	INTRO {
		public String getName() { return "intro.png"; }
	},
	ABOUT {
		public String getName() { return "about.png"; }
	},
	PLAYGAME {
		public String getName() { return "play_game.png"; }
	};
	public abstract String getName();
}
