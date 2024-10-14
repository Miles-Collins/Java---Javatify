package com.javatify;

public class Search {

    public static void searchByTitle(String title, Song[] library) {
        for (Song song : library) {
            if (song.name().toLowerCase().contains(title.toLowerCase())) {
                Menu.nowPlaying(song);
                AudioPlayer.play(song);
            }
        }
    }
}
