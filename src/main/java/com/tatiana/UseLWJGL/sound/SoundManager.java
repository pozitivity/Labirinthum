package com.tatiana.UseLWJGL.sound;

import java.io.IOException;

import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.tatiana.UseLWJGL.util.Storage;

public class SoundManager implements SoundManagerDao{

	private Sound sound = new Sound();
	
	public void loadWavEffect(String audioName) {
		try {
			sound.setWavEffect(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("sound/" + audioName)));
		} catch (IOException e) {
			System.out.println("Load file failed");
			e.printStackTrace();
		}
	}
	
	public void loadOggStreaming(String audioName) {
		try {
			sound.setOggStream(AudioLoader.getStreamingAudio("OGG", ResourceLoader.getResource(Storage.PATH_PROJECTS_TO_SOUND.getString() + audioName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loopOggStream() {
		//if (!sound.getOggStream().isPlaying()) {
			sound.getOggStream().playAsMusic(1.0f, 1.0f, true);
		//}
	}
	
	public void stopOggStream() {
		sound.getOggStream().stop();
	}
	
}
