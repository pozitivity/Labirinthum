package com.tatiana.UseLWJGL.timing;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

public class Timer {
	
	static int fps;
	
	static long lastFPS;
	
	static long lastFrame;
	
	public static void syncUpdateApp() {
		fps = 0;
		lastFPS = 0;
	}
	
	public static void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	
	public static void setLastFPS(long time) {
		lastFPS = time;
	}
	
	public static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	// вычисление сколько миллисекунд прошло
	public static int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
	}
}
