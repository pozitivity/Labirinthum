package com.tatiana.UseLWJGL.sound.entity;

import org.newdawn.slick.openal.Audio;
 
public class Sound {
	
	/** The ogg sound effect */
    private Audio oggEffect;
    /** The wav sound effect */
    private static Audio wavEffect;
    /** The aif source effect */
    private Audio aifEffect;
    /** The ogg stream thats been loaded */
    private static Audio oggStream;
    /** The mod stream thats been loaded */
    private Audio modStream;
	public Audio getOggEffect() {
		return oggEffect;
	}
	public void setOggEffect(Audio oggEffect) {
		this.oggEffect = oggEffect;
	}
	public Audio getWavEffect() {
		return wavEffect;
	}
	public void setWavEffect(Audio wavEffect) {
		this.wavEffect = wavEffect;
	}
	public Audio getAifEffect() {
		return aifEffect;
	}
	public void setAifEffect(Audio aifEffect) {
		this.aifEffect = aifEffect;
	}
	public Audio getOggStream() {
		return oggStream;
	}
	public void setOggStream(Audio oggStream) {
		this.oggStream = oggStream;
	}
	public Audio getModStream() {
		return modStream;
	}
	public void setModStream(Audio modStream) {
		this.modStream = modStream;
	}
     
    
}
