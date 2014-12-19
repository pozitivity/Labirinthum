package com.tatiana.UseLWJGL.util.texture;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.opengl.Texture;

public class TextureDaoImpl implements TextureDao{
	
	List<TextureCore> textures = new ArrayList<TextureCore>();

	public List<TextureCore> getAllTexture() {
		if (textures != null) return textures;
		return null;
	}

	public TextureCore getTextureById(int id) {
		for (TextureCore texture: textures) {
			if (texture.getId() == id) {
				return texture;
			}
		}
		return null;
	}

	public TextureCore getTextureByName(String name) {
		for (TextureCore texture: textures) {
			if (texture.getName() == name) {
				return texture;
			}
		}
		return null;
	}

	public void addTexture(Texture texture, String name, int id) {
		TextureCore newTexture = new TextureCore();
		newTexture.setId(id);
		newTexture.setTexture(texture);
		newTexture.setName(name);;
		
		textures.add(newTexture);
	}
}
