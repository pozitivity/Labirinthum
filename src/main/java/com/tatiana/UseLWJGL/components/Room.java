package com.tatiana.UseLWJGL.components;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;


import com.tatiana.UseLWJGL.components.camera.CameraControl;
import com.tatiana.UseLWJGL.components.entities.Entity;
import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.Util;
import com.tatiana.UseLWJGL.util.texture.Textures;
import com.tatiana.UseLWJGL.components.vbo.DataFiles;
import com.tatiana.UseLWJGL.components.vbo.VBO;
import com.tatiana.UseLWJGL.components.world.WorldObjects;

import static org.lwjgl.opengl.GL11.*;

public class Room implements Entity {
	
	private ParamsDisplay paramsDisplay = new ParamsDisplay();
	LoaderTexture loadtexture = new LoaderTexture();
	Light light = new Light();
	static Texture texture, floor, brick, aqua1, aqua2, aqua3, 
	aqua4, water, wood, wall, vintage, mirror, ball, lamp;
	Util util = new Util();
	Shaders shader = new Shaders();
	CameraControl camera = new CameraControl();
	static WorldObjects sector;
	Sphere sphere;
	float height = 10.0f;
    ByteBuffer lightBuffer;
    ByteBuffer reflectBuffer;
	
	float[] position = { 0.0f, 0.0f, -10.0f, 1 };
	
	public void init() {
		try {
			texture = loadtexture.readTextureJPG(Textures.BRICK_13.getName());
			brick = loadtexture.readTextureJPG(Textures.BRICK_3.getName());
			floor = loadtexture.readTextureJPG(Textures.MARBLE_1.getName());
			aqua1 = loadtexture.readTextureJPG(Textures.AQUA_1.getName());
			aqua2 = loadtexture.readTextureJPG(Textures.AQUA_2.getName());
			aqua3 = loadtexture.readTextureJPG(Textures.AQUA_3.getName());
			aqua4 = loadtexture.readTextureJPG(Textures.AQUA_4.getName());
			water = loadtexture.readTextureJPG(Textures.WATER.getName());
			wood = loadtexture.readTextureJPG(Textures.FLOOR_79.getName());
			wall = loadtexture.readTextureJPG(Textures.WALL.getName());
			vintage = loadtexture.readTextureJPG(Textures.CEIL.getName());
			mirror = loadtexture.readTextureJPG(Textures.MIRROR_1.getName());
			ball = loadtexture.readTextureJPG("ball_2.jpg");
			lamp = loadtexture.readTextureJPG("light.jpg");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.make3D();
		VBO.loadVertex(DataFiles.TRIANGLE_CORRIDOR.getName());
		
		
		sphere = new Sphere();
        sphere.setNormals(GL11.GL_SMOOTH);
        sphere.setTextureFlag(true);
	}

	public void render() {
		glClearColor(1, 1, 1, 1);
		
		glViewport(0, 0, paramsDisplay.getDisplayWidth(), paramsDisplay.getDisplayHeight());
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
		glLoadIdentity();
		camera.rotation();
		
		light.setUpLight();
		
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				0, 2, floor);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				2, 6, brick);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				6, 8, wood);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				8, 24, wall);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				26, 28, vintage);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				28, 30, wall);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				30, 32, floor);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				32, 36, brick);
		
		aquarium();
		
		mirror();
	      
	}
	
	public void sphere(float size, Vector3f position, Texture texture) {
		glTranslatef(position.x, position.y, position.z);
		sphere.setDrawStyle(GLU.GLU_FILL);

		texture.bind();
		sphere.draw(size, 32, 16);
		glTranslatef(-position.x, -position.y, -position.z);
	}
	
	public void aquarium() {
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				36, 38, aqua1);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				38, 40, aqua2);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				40, 42, aqua3);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				42, 44, aqua4);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				44, 48, water);
	}
	
	public void mirroraquarium() {
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				76, 78, aqua4);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				78, 80, aqua2);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				80, 82, aqua3);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				82, 84, aqua1);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				84, 88, water);
	}
	
	
	public void mirror() {
		
		glClear(GL_STENCIL_BUFFER_BIT);
		glPushMatrix();
		sphere(3.0f, new Vector3f(25.0f, -7.0f, -115.0f), ball);
		
		sphere(1.0f, new Vector3f(0.0f, 10.0f, -100.0f), lamp);
		sphere(1.0f, new Vector3f(-30.0f, 0.0f, -125.0f), lamp);
		sphere(1.0f, new Vector3f(30.0f, 0.0f, -115.0f), lamp);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				48, 50, wood);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				50, 58, wall);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				58, 60, floor);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				60, 64, brick);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				64, 70, wall);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				70, 72, floor);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				72, 76, brick);
		mirroraquarium();
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				88, 90, vintage);
		glPopMatrix();
		
		glEnable(GL_STENCIL_TEST);
		glColorMask(false, false, false, false);
		glDisable(GL_DEPTH_TEST);
		glStencilFunc(GL_ALWAYS, 1, 1);
		
		glStencilOp(GL_KEEP, GL_KEEP, GL_REPLACE);
		
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				24, 26, mirror);
		
		glColorMask(true, true, true, true);
		glEnable(GL_DEPTH_TEST);
		glStencilFunc(GL_EQUAL, 1, 1);
		glStencilOp(GL_KEEP, GL_KEEP, GL_KEEP);
		
		glPushMatrix();
		glScalef(1.0f, 1.0f, 1.0f);
		sphere(3.0f, new Vector3f(25.0f, -7.0f, -145.0f), ball);
		
		sphere(1.0f, new Vector3f(0.0f, 10.0f, -150.0f), lamp);
		sphere(1.0f, new Vector3f(-30.0f, 0.0f, -135.0f), lamp);
		sphere(1.0f, new Vector3f(30.0f, 0.0f, -145.0f), lamp);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				48, 50, wood);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				50, 58, wall);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				58, 60, floor);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				60, 64, brick);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				64, 70, wall);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				70, 72, floor);
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				72, 76, brick);
		mirroraquarium();
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				88, 90, vintage);
		glPopMatrix();
		
		glDisable(GL_STENCIL_TEST);
		light.setUpLightMirror();
		glEnable(GL_BLEND);
		glDisable(GL_LIGHTING);
		
		glColor4f(1.0f, 1.0f, 1.0f, 0.7f);
		
		VBO.drawVertexBufferOject(DataFiles.TRIANGLE_CORRIDOR.getName(), 
				24, 26, mirror);
		glEnable(GL_LIGHTING);
		glDisable(GL_BLEND);
	}
	
	public void snow() {
		
	}

	public void destroy() {
		texture.release();
	}

	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
}
