package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL [] = new URL[20];

    public Sound() {
        soundURL[0] = getClass().getResource("/sounds/menuandgamesound.wav");
        soundURL[1] = getClass().getResource("/sounds/cavemusic.wav");
        soundURL[2] = getClass().getResource("/sounds/newarea.wav");
        soundURL[3] = getClass().getResource("/sounds/questiondiscovered.wav");
    }
    public  void setFile(int i){
    try {
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
        clip = AudioSystem.getClip();
        clip.open(ais);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    public void play(){
    clip.start();
    }
    public void loop(){
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
    clip.stop();
    }
}
