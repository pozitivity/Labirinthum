package com.tatiana.UseLWJGL.sound.impl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.tatiana.UseLWJGL.sound.entity.Sound;
import com.tatiana.UseLWJGL.util.Storage;

public class SoundLoader {

	
	private Sound sound = new Sound();
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void loadWavEffect(String audioName) {
		try {
			sound.setWavEffect(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(Storage.PATH_PROJECTS_TO_SOUND.getString() + audioName)));
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public void loadOggStreaming(String audioName) {
		try {
			sound.setOggStream(AudioLoader.getStreamingAudio("OGG", ResourceLoader.getResource(Storage.PATH_PROJECTS_TO_SOUND.getString() + audioName)));
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
