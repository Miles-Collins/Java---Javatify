package com.javatify;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Menu {

    static Song activeSong = null;

    public static void displayMenu() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Javatify");
        alert.setHeaderText(null);
        alert.setContentText("---- Javatify ----\n[S]earch by title\n[L]ibrary\n[P]lay\n[Q]uit");
        alert.showAndWait();
    }

    public static void displayPlaybackMenu() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Playback Menu");
        alert.setHeaderText(null);
        String nowPlaying = (activeSong != null) ? "---- Now Playing " + activeSong.name() + " ----" : "---- Now Playing ----";
        alert.setContentText(nowPlaying + "\n[Next] song\n[Prev]ious song\n[F]orward playback\n[Pause] playback\n[Resume] playback\n[Stop] playback\n[H]ome");
        alert.showAndWait();
    }

    public static void skipSong() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Skip Song");
        alert.setHeaderText(null);
        alert.setContentText("[S]kip song\nSkipping song...");
        alert.showAndWait();
    }

    static void displayLibrary(Song[] library) {
        StringBuilder libraryContent = new StringBuilder();
        for (int i = 0; i < library.length; i++) {
            libraryContent.append((i + 1)).append(": ").append(library[i].name()).append(" by ").append(library[i].artist()).append("\n")
                    .append("    Genre: ").append(library[i].genre()).append("\n")
                    .append("    Release Year: ").append(library[i].year()).append("\n");
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Library");
        alert.setHeaderText(null);
        alert.setContentText(libraryContent.toString());
        alert.showAndWait();
    }

    public static void displaySearchMenu() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Search Menu");
        alert.setHeaderText(null);
        alert.setContentText("-->Search by title<--\nEnter song title to search for a song\nor\nPress [H]ome to return to main menu");
        alert.showAndWait();
    }
}
