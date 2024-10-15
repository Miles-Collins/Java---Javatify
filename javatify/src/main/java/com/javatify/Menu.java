package com.javatify;

public class Menu {

    public static void displayMenu() {
        System.out.println("");
        System.out.println("---- Javatify ----");
        System.out.println("[H]ome");
        System.out.println("[S]earch by title");
        System.out.println("[L]ibrary");
        System.out.println("[P]lay");
        System.out.println("[Q]uit");
        System.out.println("");
        System.out.print("Enter corresponding letter: ");
    }

    public static void displayPlaybackMenu() {
        System.out.println("");
        System.out.println("---- Now Playing ----");
        System.out.println("[Next] song");
        System.out.println("[Prev]ious song");
        System.out.println("[Pause] playback");
        System.out.println("[Resume] playback");
        System.out.println("[Stop] playback");
        System.out.println("[M]ain menu");
        System.out.println("");
        System.out.print("Enter corresponding letter: ");
    }

    public static void nowPlaying(Song song) {
        System.out.println("Now playing: " + song.name() + " by " + song.artist());
    }

    public static void skipSong() {
        System.out.println("[S]kip song");
        System.out.println("Skipping song...");
    }

    static void displayLibrary(Song[] library) {
        for (int i = 0; i < library.length; i++) {
            System.out.println((i + 1) + ": " + library[i].name() + " by " + library[i].artist());
        }
    }
}
