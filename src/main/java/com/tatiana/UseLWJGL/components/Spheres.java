package com.tatiana.UseLWJGL.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import com.tatiana.UseLWJGL.components.world.util.Vertex;
import com.tatiana.UseLWJGL.util.ParamsDisplay;
import com.tatiana.UseLWJGL.util.Storage;

public class Spheres {
	
	ParamsDisplay paramsDisplay = new ParamsDisplay();
	
	static WorldObject sphere = new WorldObject();
	static WorldObject sour = new WorldObject();
	static WorldObject dest = new WorldObject();
	static int maxver = 0;
	static int steps = 200;
	
	static boolean morph;
	static float xrot, yrot, zrot,
			xspeed, yspeed, zspeed,
			cx, cy, cz = -15;
	int step = 0;
	
	public void load() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(Storage.PATH_PROJECTS_TO_DATA.getString() + WorldObjects.SPHERE.getName()));
			String line  = in.readLine();
			int index = line.indexOf("Vertices:") + 9;
			sphere.objallocate(sphere, Integer.parseInt(line.substring(index).trim()));
			
			for (int i = 0; i < sphere.verts; i++) {
				line = in.readLine();
				StringTokenizer st = new StringTokenizer(line," ");
				while (st.hasMoreElements()) {
					sphere.points[i].x = Float.parseFloat((String)st.nextElement());
                    sphere.points[i].y = Float.parseFloat((String)st.nextElement());
                    sphere.points[i].z = Float.parseFloat((String)st.nextElement()); 
				}
			}
			
			in.close();
			
			if (sphere.verts > maxver) {
				maxver = sphere.verts;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void render() {
		GL11.glViewport(0, 0, paramsDisplay.getDisplayWidth(), paramsDisplay.getDisplayHeight());
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // Clear The Screen And The Depth Buffer
        GL11.glLoadIdentity();                                   // Reset The View
        GL11.glTranslatef(cx, cy, cz);                             // Translate The The Current Position To Start Drawing
        GL11.glRotatef(xrot, 1, 0, 0);                              // Rotate On The X Axis By xrot
        GL11.glRotatef(yrot, 0, 1, 0);                              // Rotate On The Y Axis By yrot
        GL11.glRotatef(zrot, 0, 0, 1);                              // Rotate On The Z Axis By zrot

        xrot += xspeed; yrot += yspeed; zrot += zspeed;           // Increase xrot,yrot & zrot by xspeed, yspeed & zspeed

        float tx, ty, tz;                                   // Temp X, Y & Z Variables
        Vertex q = new Vertex();                                           // Holds Returned Calculated Values For One Vertex

        GL11.glBegin(GL11.GL_POINTS);                                 // Begin Drawing Points
            for(int i=0; i < sphere.verts; i++)                 // Loop Through All The Verts Of morph1 (All Objects Have
            {                                               // The Same Amount Of Verts For Simplicity, Could Use maxver Also)
                if (morph) q = q.calculate(i, sour, dest, steps); 
                else q.x = q.y = q.z = 0;   // If morph Is True Calculate Movement Otherwise Movement=0
                sphere.points[i].x -= q.x;                    // Subtract q.x Units From helper.points[i].x (Move On X Axis)
                sphere.points[i].y -= q.y;                    // Subtract q.y Units From helper.points[i].y (Move On Y Axis)
                sphere.points[i].z -= q.z;                    // Subtract q.z Units From helper.points[i].z (Move On Z Axis)
                tx = sphere.points[i].x;                      // Make Temp X Variable Equal To Helper's X Variable
                ty = sphere.points[i].y;                      // Make Temp Y Variable Equal To Helper's Y Variable
                tz = sphere.points[i].z;                      // Make Temp Z Variable Equal To Helper's Z Variable

                GL11.glColor3f(0, 1, 1);                           // Set Color To A Bright Shade Of Off Blue
                GL11.glVertex3f(tx, ty, tz);                       // Draw A Point At The Current Temp Values (Vertex)
                GL11.glColor3f(1.0f, 1.0f, 1.0f);                        // Darken Color A Bit
                tx -= 2 * q.x; 
                ty -= 2 * q.y; 
                ty -= 2 * q.y;            // Calculate Two Positions Ahead
                GL11.glVertex3f(tx, ty, tz);                       // Draw A Second Point At The Newly Calculate Position
                GL11.glColor3f(1.0f, 1.0f, 1.0f);                           // Set Color To A Very Dark Blue
                tx -= 2 * q.x; 
                ty -= 2 * q.y; 
                ty -= 2 * q.y;            // Calculate Two More Positions Ahead
                GL11.glVertex3f(tx, ty, tz);                       // Draw A Third Point At The Second New Position
            }                                               // This Creates A Ghostly Tail As Points Move
        GL11.glEnd();                                            // Done Drawing Points

        // If We're Morphing And We Haven't Gone Through All 200 Steps Increase Our Step Counter
        // Otherwise Set Morphing To False, Make Source=Destination And Set The Step Counter Back To Zero.
        if(morph && step <= steps) {
            step++;
        }
        else {
            morph = false;
            sour = dest;
            step = 0;
        }
	}

	public WorldObject getDest() {
		return dest;
	}

	public void setDest(WorldObject dest) {
		this.dest = dest;
	}

	public boolean isMorph() {
		return morph;
	}

	public void setMorph(boolean morph) {
		this.morph = morph;
	}

	public float getXrot() {
		return xrot;
	}

	public void setXrot(float xrot) {
		this.xrot = xrot;
	}

	public float getYrot() {
		return yrot;
	}

	public void setYrot(float yrot) {
		this.yrot = yrot;
	}

	public float getZrot() {
		return zrot;
	}

	public void setZrot(float zrot) {
		this.zrot = zrot;
	}

	public float getXspeed() {
		return xspeed;
	}

	public void setXspeed(float xspeed) {
		this.xspeed = xspeed;
	}

	public float getYspeed() {
		return yspeed;
	}

	public void setYspeed(float yspeed) {
		this.yspeed = yspeed;
	}

	public float getZspeed() {
		return zspeed;
	}

	public void setZspeed(float zspeed) {
		this.zspeed = zspeed;
	}

	public float getCx() {
		return cx;
	}

	public void setCx(float cx) {
		this.cx = cx;
	}

	public float getCy() {
		return cy;
	}

	public void setCy(float cy) {
		this.cy = cy;
	}

	public float getCz() {
		return cz;
	}

	public void setCz(float cz) {
		this.cz = cz;
	}

	public static WorldObject getSphere() {
		return sphere;
	}

	public static void setSphere(WorldObject sphere) {
		Spheres.sphere = sphere;
	}
}
