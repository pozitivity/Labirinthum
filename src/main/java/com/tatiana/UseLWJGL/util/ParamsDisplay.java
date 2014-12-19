package com.tatiana.UseLWJGL.util;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class ParamsDisplay {
	
	private static int width;
	private static int height;
	private static boolean fullScreen;
	private static boolean done = false;
	
	public int getDisplayWidth() {
		return ParamsDisplay.width;
	}
	
	public void setDisplayWidth(int width) {
		ParamsDisplay.width = width;
	}

	public int getDisplayHeight() {
		return height;
	}

	public void setDisplayHeight(int height) {
		ParamsDisplay.height = height;
	}

	public boolean isFullScreen() {
		return fullScreen;
	}

	public void setFullScreen(boolean fullScreen) {
		ParamsDisplay.fullScreen = fullScreen;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		ParamsDisplay.done = done;
	}
	
	public void setDisplayMode(int width, int height, boolean fullScreen) {
		this.setDisplayWidth(width);
		this.setDisplayHeight(height);
		this.setFullScreen(fullScreen);
		
		if ((Display.getDisplayMode().getWidth() == this.getDisplayWidth()) && 
				(Display.getDisplayMode().getHeight() == this.getDisplayHeight()) &&
				(Display.isFullscreen() == this.isFullScreen())) {
			return;
		}
		try {
			DisplayMode targetDisplayMode = null;
			
			if (fullScreen) {
				DisplayMode[] modes = Display.getAvailableDisplayModes();
				int freq = 0;
				
				for (int i = 0; i < modes.length; i++) {
					DisplayMode current = modes[i];
					
					if ((current.getWidth() == this.getDisplayWidth()) && (current.getHeight() == this.getDisplayHeight())) {
						if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
							if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
								targetDisplayMode = current;
								freq = targetDisplayMode.getFrequency();
							}
						}
						if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
								(current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
							targetDisplayMode = current;
							break;
						}
					}
				}
			} else {
				targetDisplayMode = new DisplayMode(this.getDisplayWidth(), this.getDisplayHeight());
			}
			
			if (targetDisplayMode == null) {
				System.out.println("Failed to find value mode: " + width + " x " + height + "fs = " + fullScreen);
				return;
			}
			
			Display.setDisplayMode(targetDisplayMode);
			Display.setFullscreen(fullScreen);
			
		} catch(LWJGLException e) {
			System.out.println("Unable to setup mode " + width + " x " + 
					height + "fullScreen = " + fullScreen + e);
		}
	}
	
}
