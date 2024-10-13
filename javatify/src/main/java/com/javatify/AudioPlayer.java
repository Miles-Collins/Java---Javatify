package com.javatify;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class AudioPlayer {

    private static Player mp3Player;

    public static void play(Song song) {
        if (mp3Player != null) {
            mp3Player.close();
        }

        try {
            File file = new File(Config.getDirectoryPath() + "/audio/" + song.fileName());
            if (file.getName().endsWith(".mp3")) {
                FileInputStream fis = new FileInputStream(file);
                mp3Player = new Player(fis);
                new Thread(() -> {
                    try {
                        mp3Player.play();
                    } catch (JavaLayerException e) {
                        System.out.println("Error playing MP3: " + e.getMessage());
                    }
                }).start();
            } else {
                System.out.println("Unsupported file format");
            }
        } catch (IOException | JavaLayerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
