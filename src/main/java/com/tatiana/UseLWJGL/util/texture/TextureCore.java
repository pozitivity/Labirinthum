package com.tatiana.UseLWJGL.util.texture;

import org.newdawn.slick.opengl.Texture;


public class TextureCore {
	
	private String name;
	private Texture texture;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public  Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
