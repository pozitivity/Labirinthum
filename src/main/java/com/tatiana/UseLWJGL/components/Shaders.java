package com.tatiana.UseLWJGL.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL11.*;

import com.tatiana.UseLWJGL.util.Storage;

public class Shaders {
	
	Logger logger = Logger.getLogger(this.getClass().getName());

	private static int shaderProgram, vertexShader, fragmentShader;
	
	public void setUpShaders() {
		
		shaderProgram = glCreateProgram();
		
		vertexShader = glCreateShader(GL_VERTEX_SHADER);
		fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
		
		StringBuilder vertexShaderSource = new StringBuilder();
		StringBuilder fragmentShaderSource = new StringBuilder();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					Storage.PATH_PROJECTS_TO_SHADERS.getString() + "light.vert"));
			String line;
			while((line = reader.readLine()) != null) {
				vertexShaderSource.append(line).append('\n');
			}
			reader.close();
		} 
		catch(IOException e) {
			logger.log(Level.SEVERE, "Vertex shader wasn`t loaded properly");
			System.err.println(e.getMessage());
			Display.destroy();
			System.exit(1);
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					Storage.PATH_PROJECTS_TO_SHADERS.getString() + "light.frag"));
			String line;
			while((line = reader.readLine()) != null) {
				fragmentShaderSource.append(line).append('\n');
			}
			reader.close();
		} 
		catch(IOException e) {
			logger.log(Level.SEVERE, "Fragment shader wasn`t loaded properly");
			System.err.println(e.getMessage());
			Display.destroy();
			System.exit(1);
		}
		
		glShaderSource(vertexShader, vertexShaderSource);
		glCompileShader(vertexShader);
		if (glGetShader(vertexShader, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Vertex shader wasn`t able to be compiled correctly");
		}
		glShaderSource(fragmentShader, fragmentShaderSource);
		glCompileShader(fragmentShader);
		
		if (glGetShader(fragmentShader, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Fragment shader wasn`t able to be compiled correctly");
		}
		
		glAttachShader(shaderProgram, vertexShader);
		glAttachShader(shaderProgram, fragmentShader);
		
		glLinkProgram(shaderProgram);
		glValidateProgram(shaderProgram);
		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);
	}
}
