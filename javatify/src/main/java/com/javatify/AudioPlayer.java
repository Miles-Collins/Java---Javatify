package com.javatify;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class AudioPlayer {

    private static Player mp3Player;
    public static Song[] library;

    public static void play(Song song) {
        if (mp3Player != null) {
            mp3Player.close();
        }

        try {
            String filePath = Config.getDirectoryPath() + "/audio/" + song.fileName();
            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("File does not exist: " + filePath);
                return;
            }

            if (file.getName().endsWith(".mp3")) {
                FileInputStream fis = new FileInputStream(file);
                mp3Player = new Player(fis);
                new Thread(() -> {
                    try {
                        mp3Player.play();
                        playRandomSong(library);
                    } catch (JavaLayerException e) {
                        System.out.println("Error playing MP3: " + e.getMessage());
                    }
                }).start();
            } else {
                System.out.println("Unsupported file format: " + file.getName());
            }
        } catch (IOException | JavaLayerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void playRandomSong(Song[] library) {
        AudioPlayer.library = library;
        int randomIndex = (int) (Math.random() * library.length);
        Song randomSong = library[randomIndex];
        Menu.nowPlaying(randomSong);
        play(randomSong);
    }

    public static void stop() {
        if (mp3Player != null) {
            mp3Player.close();
            mp3Player = null;
            System.out.println("Song stopped");
        }
    }
}
