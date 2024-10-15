package com.javatify;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class AudioPlayer {

    private static Player mp3Player;
    public static Song[] library;
    private static int currentIndex = 0;
    private static boolean isPaused = false;
    private static FileInputStream fis;

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
                        currentIndex = LibraryManager.returnIndex(song);
                        System.out.println("Current index: " + currentIndex);
                        mp3Player.play();
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

    public static void playNextSong(Song[] library) {
        if (library != null && library.length > 0) {
            if (currentIndex != library.length - 1) {
                currentIndex++;
                System.out.println("Current index: " + currentIndex);
                Song nextSong = library[currentIndex];
                Menu.nowPlaying(nextSong);
                play(nextSong);
            } else {
                currentIndex = 0;
                System.out.println("Current index: " + currentIndex);
                Song nextSong = library[currentIndex];
                Menu.nowPlaying(nextSong);
                play(nextSong);
            }
        }
    }

    public static void playPreviousSong(Song[] library) {
        if (library != null && library.length > 0) {
            if (currentIndex != 0) {
                currentIndex--;
                System.out.println("Current index: " + currentIndex);
                Song prevSong = library[currentIndex];
                Menu.nowPlaying(prevSong);
                play(prevSong);
            } else {
                currentIndex = library.length - 1;
                System.out.println("Current index: " + currentIndex);
                Song prevSong = library[currentIndex];
                Menu.nowPlaying(prevSong);
                play(prevSong);
            }
        }
    }

    public static void pause() {
        if (mp3Player != null && !isPaused) {
            try {
                mp3Player.close();
                isPaused = true;
                System.out.println("Song paused");
            } catch (Exception e) {
                System.out.println("Error pausing song: " + e.getMessage());
            }
        } else {
            System.out.println("Song is already paused");
        }
    }

    public static void resume() {
        if (mp3Player != null && isPaused) {
            try {
                mp3Player = new Player(fis);
                new Thread(() -> {
                    try {
                        mp3Player.play();
                    } catch (JavaLayerException e) {
                        System.out.println("Error resuming MP3: " + e.getMessage());
                    }
                }).start();
                isPaused = false;
                System.out.println("Song resumed");
            } catch (Exception e) {
                System.out.println("Error resuming song: " + e.getMessage());
            }
        }
    }

    public static void skipSong() {
        if (library != null && library.length > 0) {
            currentIndex = (currentIndex + 1) % library.length;
            Song nextSong = library[currentIndex];
            Menu.nowPlaying(nextSong);
            play(nextSong);
        }
    }

    public static void stop() {
        if (mp3Player != null) {
            mp3Player.close();
            mp3Player = null;
            System.out.println("Song stopped");
        }
    }

}
