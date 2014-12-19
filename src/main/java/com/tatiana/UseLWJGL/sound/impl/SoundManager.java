package com.tatiana.UseLWJGL.sound.impl;

import com.tatiana.UseLWJGL.sound.dao.SoundManagerDao;
import com.tatiana.UseLWJGL.sound.entity.Sound;
public class SoundManager implements SoundManagerDao{

	Sound sound = new Sound();
	
	public void playOgg(boolean loop) {
		sound.getOggStream().playAsMusic(1.0f, 1.0f, loop);
	}

	public void stopOgg() {
		sound.getOggStream().stop();
	}
}
