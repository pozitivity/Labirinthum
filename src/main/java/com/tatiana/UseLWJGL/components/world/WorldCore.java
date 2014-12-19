package com.tatiana.UseLWJGL.components.world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.tatiana.UseLWJGL.components.world.util.Sector;
import com.tatiana.UseLWJGL.util.LoaderTexture;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.texture.Textures;

public class WorldCore {

	private Sector sector1;
	private static float xpos;
	private static float zpos;
	private static float yrot;
	private static float walkbias = 0;
	private static float walkbiasangle = 0;
	private static float lookupdown = 0.0f;
	private static float zoom = 0.0f;
	private static float heading;
	private final float piover180 = 0.0174532925f;
	
	private Texture texture;
	
	private LoaderTexture loadtexture = new LoaderTexture();
	private ParamsDisplay paramsDisplay = new ParamsDisplay();
	
	public float getXpos() {
		return xpos;
	}
	
	public void setXpos(float xpos) {
		WorldCore.xpos = xpos;
	}
	
	public float getZpos() {
		return zpos;
	}
	
	public void setZpos(float zpos) {
		WorldCore.zpos = zpos;
	}
	
	public float getYrot() {
		return yrot;
	}
	
	public void setYrot(float yrot) {
		WorldCore.yrot = yrot;
	}
	
	public float getWalkbias() {
		return walkbias;
	}
	
	public void setWalkbias(float walkbias) {
		WorldCore.walkbias = walkbias;
	}
	
	public float getWalkabisangle() {
		return walkbiasangle;
	}
	
	public void setWalkbiasangle(float walkbiasangle) {
		WorldCore.walkbiasangle = walkbiasangle;
	}
	
	public float getLookupdown() {
		return lookupdown;
	}
	
	public void setLookupdown(float lookupdown) {
		WorldCore.lookupdown = lookupdown;
	}
	
	public float getZoom() {
		return zoom;
	}
	
	public void setZoom(float zoom) {
		WorldCore.zoom = zoom;
	}
	
	public float getHeading() {
		return heading;
	}

	public void setHeading(float heading) {
		WorldCore.heading = heading;
	}

	public float getPiover180() {
		return piover180;
	}

	public void setupWorld() {
		
		try {
			String line;
			BufferedReader dis = new BufferedReader(new FileReader("target/classes/data/world.txt"));
			
			while((line = dis.readLine()) != null) {
				if (line.trim().length() == 0 || line.trim().startsWith("//"))
					continue;
				
				if (line.startsWith("NUMPOLLIES")) {
					int numTriangles;
					
					numTriangles = Integer.parseInt(line.substring(line.indexOf("NUMPOLLIES") + 
							"NUMPOLLIES".length() + 1));
					sector1 = new Sector(numTriangles);
					
					break;
				}
			}
			
			for (int i = 0; i < sector1.numTriangles; i++) {
				for (int vert = 0; vert < 3; vert++) {
					while ((line = dis.readLine()) != null) {
						if (line.trim().length() == 0 || line.trim().startsWith("//"))
                            continue;

                        break;
					}
					
					if (line != null) {
						StringTokenizer st = new StringTokenizer(line, " ");
						sector1.triangle[i].vertex[vert].x = Float.valueOf(st.nextToken()).floatValue();
                        sector1.triangle[i].vertex[vert].y = Float.valueOf(st.nextToken()).floatValue();
                        sector1.triangle[i].vertex[vert].z = Float.valueOf(st.nextToken()).floatValue();
                        sector1.triangle[i].vertex[vert].u = Float.valueOf(st.nextToken()).floatValue();
                        sector1.triangle[i].vertex[vert].v = Float.valueOf(st.nextToken()).floatValue();
					}
				}
			}
			
			dis.close();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void initWorld() throws IOException {
		texture = loadtexture.readTexture(Textures.WOOD.getName());
	}
	
	public void renderWorld() {
		GL11.glViewport(0, 0, paramsDisplay.getDisplayWidth(), paramsDisplay.getDisplayHeight());
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
		
		float x_m, y_m, z_m, u_m, v_m;
		float xtrans = -xpos;
		float ztrans = -zpos;
		float ytrans = -walkbias - 0.25f;
		float sceneroty = 360.0f - yrot;
		
		int numTriangles;
		
		GL11.glRotatef(lookupdown, 1.0f, 0, 0);
		GL11.glRotatef(sceneroty, 0, 1.0f, 0);
		
		GL11.glTranslatef(xtrans, ytrans, ztrans);
		texture.bind();
		
		numTriangles = sector1.numTriangles;
		
		// process each triangle
		for (int loop_m = 0; loop_m < numTriangles; loop_m++) {
			GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
				x_m = sector1.triangle[loop_m].vertex[0].x;
				y_m = sector1.triangle[loop_m].vertex[0].y;
				z_m = sector1.triangle[loop_m].vertex[0].z;
				u_m = sector1.triangle[loop_m].vertex[0].u;
				v_m = sector1.triangle[loop_m].vertex[0].v;
				GL11.glTexCoord2f(u_m,v_m); GL11.glVertex3f(x_m,y_m,z_m);

				x_m = sector1.triangle[loop_m].vertex[1].x;
				y_m = sector1.triangle[loop_m].vertex[1].y;
				z_m = sector1.triangle[loop_m].vertex[1].z;
				u_m = sector1.triangle[loop_m].vertex[1].u;
				v_m = sector1.triangle[loop_m].vertex[1].v;
				GL11.glTexCoord2f(u_m,v_m); GL11.glVertex3f(x_m,y_m,z_m);

				x_m = sector1.triangle[loop_m].vertex[2].x;
				y_m = sector1.triangle[loop_m].vertex[2].y;
				z_m = sector1.triangle[loop_m].vertex[2].z;
				u_m = sector1.triangle[loop_m].vertex[2].u;
				v_m = sector1.triangle[loop_m].vertex[2].v;
				GL11.glTexCoord2f(u_m,v_m); GL11.glVertex3f(x_m,y_m,z_m);
            GL11.glEnd();
		}
	}
}
