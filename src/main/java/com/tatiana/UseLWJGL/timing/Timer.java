package com.tatiana.UseLWJGL.timing;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

public class Timer {

	
	private static long lastFrame;
	
	private int fps;
	public static long lastFPS;
	
	public void setLastFPS(long lastFPS) {
		Timer.lastFPS = lastFPS;
	}
	
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
	}
	
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
}
