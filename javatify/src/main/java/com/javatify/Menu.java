package com.javatify;

public class Menu {

    static Song activeSong = null;

    public static void displayMenu() {
        System.out.println("");
        System.out.println("---- Javatify ----");
        System.out.println("[S]earch by title");
        System.out.println("[L]ibrary");
        System.out.println("[P]lay");
        System.out.println("[Q]uit");
        System.out.println("");
        System.out.print("Enter corresponding letter: ");
    }

    public static void displayPlaybackMenu() {
        System.out.println("");
        if (activeSong != null) {
            System.out.println("---- Now Playing " + activeSong.name() + " ----");
        } else {
            System.out.println("---- Now Playing ----");
        }
        System.out.println("[Next] song");
        System.out.println("[Prev]ious song");
        System.out.println("[Pause] playback");
        System.out.println("[Resume] playback");
        System.out.println("[Stop] playback");
        System.out.println("[H]ome");
        System.out.println("");
        System.out.print("Enter corresponding letter: ");
    }

    // public static void nowPlaying(Song song) {
    //     activeSong = song;
    //     System.out.println("");
    //     System.out.println("Now playing: " + song.name() + " by " + song.artist());
    // }
    public static void skipSong() {
        System.out.println("[S]kip song");
        System.out.println("Skipping song...");
    }

    static void displayLibrary(Song[] library) {
        for (int i = 0; i < library.length; i++) {
            System.out.println((i + 1) + ": " + library[i].name() + " by " + library[i].artist());
            System.out.println("    Genre: " + library[i].genre());
            System.out.println("    Release Year: " + library[i].year());
        }
    }

    public static void displaySearchMenu() {
        System.out.println("");
        System.out.println("-->Search by title<--");
        System.out.println("Enter song title to search for a song");
        System.out.println("or");
        System.out.println("Press [H]ome to return to main menu");
        System.out.print("Enter song title: ");
    }
}
