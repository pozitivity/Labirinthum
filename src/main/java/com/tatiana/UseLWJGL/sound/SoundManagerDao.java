package com.tatiana.UseLWJGL.sound;

public interface SoundManagerDao {
	public void loadWavEffect(String audioName);
	public void loadOggStreaming(String audioName);
	public void loopOggStream();
	public void stopOggStream();
}
