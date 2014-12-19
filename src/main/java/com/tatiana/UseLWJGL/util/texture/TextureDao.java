package com.tatiana.UseLWJGL.util.texture;

import java.util.List;

import org.newdawn.slick.opengl.Texture;

public interface TextureDao {
	public void addTexture(Texture texture, String name, int id);
	public List<TextureCore> getAllTexture();
	public TextureCore getTextureById(int id);
	public TextureCore getTextureByName(String name);
}
