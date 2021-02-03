package com.intelligents.haunting;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

class MusicPlayer {

    private Clip clip;

    MusicPlayer(String filepath) {

        {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filepath));
                clip = AudioSystem.getClip();
                clip.open(audioStream);
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    void startMusic() {
        clip.start();
    }

    void pauseMusic() {
        clip.stop();
    }

    void quitMusic() {
        clip.close();
    }

    void playSoundEffect() {
        clip.setMicrosecondPosition(0);
        clip.start();
    }

}