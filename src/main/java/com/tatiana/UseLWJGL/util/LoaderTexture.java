package com.tatiana.UseLWJGL.util;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.tatiana.UseLWJGL.util.texture.TextureCore;
import com.tatiana.UseLWJGL.util.texture.TextureDaoImpl;



public class LoaderTexture {

	private Texture texture;
	private TextureDaoImpl textureDaoImpl = new TextureDaoImpl();
	
	public Texture readTexture(String textureName) throws IOException {
		texture = TextureLoader.getTexture("PNG", 
				ResourceLoader.getResourceAsStream(Storage.PATH_PROJECTS_TO_TEXTURE.getString() + textureName));
	
		textureDaoImpl.addTexture(texture, textureName, texture.getTextureID());
		
		return texture;
	}
	
}
