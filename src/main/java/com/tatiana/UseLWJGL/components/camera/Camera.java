package com.tatiana.UseLWJGL.components.camera;

import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private static Vector3f position = new Vector3f(0, 0, 0.0f);
	private static Vector3f rotation = new Vector3f(0, 0, 0);
	private static float pitch = 0.0f;
	private static float yaw = 0.0f;
	
	private static float sensitivity = 0.15f;
	private static float movementSpeed = 2.5f;
	
	public Camera() {}
	
	public Camera(float x, float y, float z, float pitch, float yaw, 
			float sensitivity, float movementSpeed) {
		Camera.position = new Vector3f(x, y, z);
		Camera.pitch = pitch;
		Camera.yaw = yaw;
		Camera.movementSpeed = movementSpeed;
		Camera.sensitivity = sensitivity;
	}

	public static Vector3f getRotation() {
		return rotation;
	}

	public static void setRotation(Vector3f rotation) {
		Camera.rotation = rotation;
	}
	
	public static void setRotationX(float x) {
		Camera.rotation.x = x;
	}
	
	public static void setRotationY(float y) {
		Camera.rotation.y = y;
	}

	public static void setRotationZ(float z) {
		Camera.rotation.z = z;
	}

	public static Vector3f getPosition() {
		return position;
	}

	public static void setPosition(Vector3f position) {
		Camera.position = position;
	}
	
	public static void setPositionX(float x) {
		Camera.position.x = x;
	}
	
	public static void setPositionY(float y) {
		Camera.position.y = y;
	}
	
	public static void setPositionZ(float z) {
		Camera.position.z = z;
	}

	public static float getPitch() {
		return pitch;
	}

	public static void setPitch(float pitch) {
		Camera.pitch = pitch;
	}

	public static float getYaw() {
		return yaw;
	}

	public static void setYaw(float yaw) {
		Camera.yaw = yaw;
	}

	public static float getSensitivity() {
		return sensitivity;
	}

	public static void setSensitivity(float sensitivity) {
		Camera.sensitivity = sensitivity;
	}

	public static float getMovementSpeed() {
		return movementSpeed;
	}

	public static void setMovementSpeed(float movementSpeed) {
		Camera.movementSpeed = movementSpeed;
	}
	
	static float dx = 0.0f;
	static float dy = 0.0f;
	static float dt = 0.0f;
	static long lastTime = 0L;
	static long time = 0L;

	public static float getDx() {
		return dx;
	}

	public static void setDx(float dx) {
		Camera.dx = dx;
	}

	public static float getDy() {
		return dy;
	}

	public static void setDy(float dy) {
		Camera.dy = dy;
	}

	public static float getDt() {
		return dt;
	}

	public static void setDt(float dt) {
		Camera.dt = dt;
	}

	public static long getLastTime() {
		return lastTime;
	}

	public static void setLastTime(long lastTime) {
		Camera.lastTime = lastTime;
	}

	public static long getTime() {
		return time;
	}

	public static void setTime(long time) {
		Camera.time = time;
	}
	
	static boolean keydown;
	static boolean keyup;
	static boolean keyleft;
	static boolean keyright;
	static boolean keyspace;
	static boolean keyshift;
	static boolean keyslow;
	static boolean keyfast;

	public static boolean isKeydown() {
		return keydown;
	}

	public static void setKeydown(boolean keydown) {
		Camera.keydown = keydown;
	}

	public static boolean isKeyup() {
		return keyup;
	}

	public static void setKeyup(boolean keyup) {
		Camera.keyup = keyup;
	}

	public static boolean isKeyleft() {
		return keyleft;
	}

	public static void setKeyleft(boolean keyleft) {
		Camera.keyleft = keyleft;
	}

	public static boolean isKeyright() {
		return keyright;
	}

	public static void setKeyright(boolean keyright) {
		Camera.keyright = keyright;
	}

	public static boolean isKeyspace() {
		return keyspace;
	}

	public static void setKeyspace(boolean keyspace) {
		Camera.keyspace = keyspace;
	}

	public static boolean isKeyshift() {
		return keyshift;
	}

	public static void setKeyshift(boolean keyshift) {
		Camera.keyshift = keyshift;
	}

	public static boolean isKeyslow() {
		return keyslow;
	}

	public static void setKeyslow(boolean keyslow) {
		Camera.keyslow = keyslow;
	}

	public static boolean isKeyfast() {
		return keyfast;
	}

	public static void setKeyfast(boolean keyfast) {
		Camera.keyfast = keyfast;
	}
	
	static float speedCamera = 0.03f;

	public static float getSpeedCamera() {
		return speedCamera;
	}

	public static void setSpeedCamera(float speedCamera) {
		Camera.speedCamera = speedCamera;
	}
}
