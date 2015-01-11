package com.tatiana.UseLWJGL.components.camera;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import com.tatiana.UseLWJGL.timing.Timer;

public class CameraControl {

	static float delta = 0.1f; 
	
	static float speed = 2.0f;
	static boolean falling = false;
	
	public void rotation() {
		// вращение
	      GL11.glRotatef(Camera.getRotation().x, 1.0f, 0.0f, 0.0f);
	      GL11.glRotatef(Camera.getRotation().y, 0.0f, 1.0f, 0.0f);
	      GL11.glRotatef(Camera.getRotation().z, 0.0f, 0.0f, 1.0f);
	      // позиция
	      GL11.glTranslatef(- Camera.getPosition().x, 
	    		  - Camera.getPosition().y, - Camera.getPosition().z); 
	}
	
	public static void blockDimension() {
		// first triangle
		if (Camera.getPosition().z < 10 && Camera.getPosition().z > -70) {
			if (Camera.getPosition().x > 4) {
				Camera.setPositionX(4);
			}
			if (Camera.getPosition().x < -4) {
				Camera.setPositionX(-4);
			}
		}
		// room back wall
		if (Camera.getPosition().z > -75 && Camera.getPosition().z < -70) {
			if (Camera.getPosition().x > -6 & Camera.getPosition().x < 6 
					&& Camera.getPosition().z > -72) {
				Camera.setPositionZ(Camera.getPosition().z);
			} else {
				if (Camera.getPosition().z > -72) {
					Camera.setPositionZ(-72);
				}
			}
		}
		
		// room front wall
		if (Camera.getPosition().z < -127) {
			Camera.setPositionZ(-127);
		}
		
		// room right and left
		if (Camera.getPosition().z < -70 && Camera.getPosition().z > -130) {
			
			if (Camera.getPosition().z < -95 && Camera.getPosition().z > -105 
					&& Camera.getPosition().x < -27) {
				Camera.setPositionX(Camera.getPosition().x);
			} else {
				if (Camera.getPosition().x > 27) {
					Camera.setPositionX(27);
				}
				if (Camera.getPosition().x < -27) {
					Camera.setPositionX(-27);
				}
			}
		}
		
		// left triangle
		if (Camera.getPosition().x < -30 && Camera.getPosition().x > -90) {
			if (Camera.getPosition().z > -96) {
				Camera.setPositionZ(-96);
			}
			if (Camera.getPosition().z < -104) {
				Camera.setPositionZ(-104);
			}
		}
		
		// falling
		if (Camera.getPosition().x < -75 && Camera.getPosition().x > -90) {
			falling = true;
		}
	}
	
	public static void falling() {
		if (falling) {
			Camera.setPositionY(Camera.getPosition().y - 0.3f);
		}
		
		if (Camera.getPosition().y < -100) {
			Camera.setPosition(new Vector3f(0.0f, 0.0f, 0.0f));
			falling = false;
		}
	}
	
	public static void move(float distance) {
		
		falling();
		
		blockDimension();
		
		if (Camera.isKeyfast()) {
			if (Camera.getSpeedCamera() < 0.1f) 
			Camera.setSpeedCamera(Camera.getSpeedCamera() * 2);
			Camera.setKeyfast(false);
		} else if (Camera.isKeyslow()) {
			if (Camera.getSpeedCamera() > 0.02f)
				Camera.setSpeedCamera(Camera.getSpeedCamera() / 2);
			Camera.setKeyslow(false);
		} 
		
		if (Camera.isKeydown()) {
			Camera.setPositionX(Camera.getPosition().x - distance * 
					(float) (Math.sin(Camera.getRotation().y * Math.PI / 180)));
			Camera.setPositionZ(Camera.getPosition().z - ( - distance * 
					(float) (Math.cos(Camera.getRotation().y * Math.PI / 180))));
			Camera.setKeydown(false);
		}
		if (Camera.isKeyup()) {
			Camera.setPositionX(Camera.getPosition().x + distance * 
					(float) (Math.sin(Camera.getRotation().y * Math.PI / 180)));
			Camera.setPositionZ(Camera.getPosition().z + ( - distance * 
					(float) (Math.cos(Camera.getRotation().y * Math.PI / 180))));
			Camera.setKeyup(false);
		}
		if (Camera.isKeyright()) {
			Camera.setPositionX(Camera.getPosition().x + distance * 
					(float) (Math.sin((Camera.getRotation().y + 90) * Math.PI / 180)));
			Camera.setPositionZ(Camera.getPosition().z + ( - distance * 
					(float) (Math.cos(Camera.getRotation().y + 90) * Math.PI / 180)));
			Camera.setKeyright(false);
		}
		
		if(Camera.isKeyleft()) {
			Camera.setPositionX(Camera.getPosition().x + distance * 
					(float) (Math.sin((Camera.getRotation().y - 90) * Math.PI / 180)));
			Camera.setPositionZ(Camera.getPosition().z + ( - distance * 
					(float) (Math.cos(Camera.getRotation().y - 90) * Math.PI / 180)));
			Camera.setKeyleft(false);
		}
		
		Timer.updateFPS();
		
	}
}
