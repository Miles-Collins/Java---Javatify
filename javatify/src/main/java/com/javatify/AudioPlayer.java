package com.javatify;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class AudioPlayer {

    private static Clip audioClip;

    public static void play(Song song) {
        if (audioClip != null) {
            audioClip.close();
        }

        try {
            audioClip = AudioSystem.getClip();
            File file = new File(Config.getDirectoryPath() + "/wav/" + song.fileName());
            AudioInputStream in = AudioSystem.getAudioInputStream(file);
            audioClip.open(in);
            audioClip.setMicrosecondPosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
