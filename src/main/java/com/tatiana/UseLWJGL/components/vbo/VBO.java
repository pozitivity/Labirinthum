package com.tatiana.UseLWJGL.components.vbo;

import static org.lwjgl.opengl.ARBBufferObject.GL_STATIC_DRAW_ARB;
import static org.lwjgl.opengl.ARBBufferObject.glBindBufferARB;
import static org.lwjgl.opengl.ARBBufferObject.glBufferDataARB;
import static org.lwjgl.opengl.ARBBufferObject.glDeleteBuffersARB;
import static org.lwjgl.opengl.ARBBufferObject.glGenBuffersARB;
import static org.lwjgl.opengl.ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB;
import static org.lwjgl.opengl.GL11.GL_COLOR_ARRAY;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_COORD_ARRAY;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glDisableClientState;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glEnableClientState;
import static org.lwjgl.opengl.GL11.glTexCoordPointer;
import static org.lwjgl.opengl.GL11.glVertexPointer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.StringTokenizer;

import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.components.world.WorldObjects;
import com.tatiana.UseLWJGL.util.Storage;

public class VBO {
	static WorldObjects sector;
	static FloatBuffer textureBuffer;
	static FloatBuffer vertexBuffer;
	static int vertexHandle;
	static int textureHandle;
	static IntBuffer vboId;
	static int vertexSize = 3;
	static int textureSize = 2;
	static int numVertex = 3;

	public static void loadVertex(String fileName) {
		int numTriangles;
    	
    	try {
    		String line;
    		BufferedReader dis = new BufferedReader(new FileReader(Storage.PATH_PROJECTS_TO_DATA.getString() 
    				+ fileName));
    		
    		while((line = dis.readLine()) != null) {
    			if (line.startsWith("NUMPOLLIES")) {
    				numTriangles = Integer.parseInt(line.substring(line.indexOf("NUMPOLLIES") 
    						+ "NUMPOLLIES".length() + 1));
    				sector = new WorldObjects(numTriangles);
    				break;
    			}
    		}
    		
    		for (int i = 0; i < sector.numTriangles; i++) {
    			for (int vert = 0; vert < 3; vert++) {
    				while((line = dis.readLine()) != null) {
    					if (line.trim().length() == 0 || line.trim().startsWith("//")) {
    						continue;
    					}
    					break;
    				}
    				
    				if (line != null) {
    					StringTokenizer st = new StringTokenizer(line, " ");
    					sector.triangle[i].vertex[vert].s = Float.valueOf(st.nextToken()).floatValue();
    					sector.triangle[i].vertex[vert].t = Float.valueOf(st.nextToken()).floatValue();
    					sector.triangle[i].vertex[vert].x = Float.valueOf(st.nextToken()).floatValue();
						sector.triangle[i].vertex[vert].y = Float.valueOf(st.nextToken()).floatValue();
						sector.triangle[i].vertex[vert].z = Float.valueOf(st.nextToken()).floatValue();
    				}
    			}
    		}
    		
    		dis.close();
    	} catch(IOException e) {
    		System.err.println(e.getMessage());
    	}
	}
	
	public static void createVertexBuffer(int start, int end) {
		int size = end - start;
		textureBuffer = BufferUtils.createFloatBuffer(size * textureSize * numVertex);
		vertexBuffer = BufferUtils.createFloatBuffer(size * vertexSize * numVertex);
		
		for (int loop_m = start; loop_m < end; loop_m++) {
			for (int vert = 0; vert < 3; vert++) {
    		   vertexBuffer.put((float)sector.triangle[loop_m].vertex[vert].x).
    		   put((float)sector.triangle[loop_m].vertex[vert].y).
    		   put((float)sector.triangle[loop_m].vertex[vert].z);
    		   
    		   textureBuffer.put((float)sector.triangle[loop_m].vertex[vert].s).
    		   put((float)sector.triangle[loop_m].vertex[vert].t);
    	   }
		}
		textureBuffer.flip();
		vertexBuffer.flip();
	}
	
	public static void drawVertexBufferOject(String fileName, int startNumTriangles, 
			int endNumTriangles, Texture texture) {
       //loadVertex(fileName);
	   createVertexBuffer(startNumTriangles, endNumTriangles);
		
	   vboId = BufferUtils.createIntBuffer(2);

       glGenBuffersARB(vboId);

       glEnableClientState(GL_VERTEX_ARRAY);
       glEnableClientState(GL_TEXTURE_COORD_ARRAY);
       
       texture.bind();
       
       vertexHandle = vboId.get(0);
       glBindBufferARB(GL_ARRAY_BUFFER_ARB, vertexHandle);
       glBufferDataARB(GL_ARRAY_BUFFER_ARB, vertexBuffer, GL_STATIC_DRAW_ARB);
       glVertexPointer(3, GL_FLOAT, 0, 0L);
       
       textureHandle = vboId.get(1);
       glBindBufferARB(GL_ARRAY_BUFFER_ARB, textureHandle);
       glBufferDataARB(GL_ARRAY_BUFFER_ARB, textureBuffer, GL_STATIC_DRAW_ARB);
       glTexCoordPointer(2, GL_FLOAT, 0, 0L);

       glDrawArrays(GL_TRIANGLES, 0, 3 * (endNumTriangles - startNumTriangles));

       glBindBufferARB(GL_ARRAY_BUFFER_ARB, 0);
       
       glDisableClientState(GL_TEXTURE_COORD_ARRAY);
       glDisableClientState(GL_VERTEX_ARRAY);

       // cleanup VBO handles
       vboId.put(0, vertexHandle);
       vboId.put(1, textureHandle);
       glDeleteBuffersARB(vboId);
	}
}
