/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public enum Bgm {
    MENUMUSIC("audio/bgm/menuMusic.wav"),
    VILLAGEMUSIC("audio/bgm/villageMusic.wav"),
    SEAMUSIC("audio/bgm/seaMusic.wav"),
    LAVAMUSIC("audio/bgm/lavaMusic.wav");

    public static enum Toggle {
        ON, OFF
    }

    public static Toggle soundSetting = Toggle.ON;

    private Clip clip;

    Bgm(String soundFileName) {
        try {

        // Use URL (instead of File) to read from disk and JAR.
            URL url = this.getClass().getClassLoader().getResource(soundFileName);

        // Set up an audio input stream piped from the sound file.
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);

        // Get a clip resource.
            clip = AudioSystem.getClip();

        // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }

// Play or Re-play the sound effect from the beginning, by rewinding.
    public void loop() {
        if (soundSetting != Toggle.OFF) {
            try {
                if (clip != null) {
                    new Thread() {
                        public void run() {
                            synchronized (clip) {
                                clip.stop();
                                clip.setFramePosition(0);
                                clip.loop(Clip.LOOP_CONTINUOUSLY);
                            }
                        }
                    }.start();
                }
            } catch (Exception e) {
            }
        }
    }

    public void stop() {
        if (clip == null) {
            return;
        }
        clip.stop();
    }

// Optional static method to pre-load all the sound files.
    static void init() {
        values(); // calls the constructor for all the elements
    }

}

