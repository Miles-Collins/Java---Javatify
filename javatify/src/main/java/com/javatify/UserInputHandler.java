package com.javatify;

import java.util.Scanner;

class UserInputHandler {

    private static boolean isPlaying = false;

    public static void handleUserInput(String userInput, Song[] library) {
        if (isPlaying) {
            handlePlaybackInput(userInput, library);
        } else {
            handleMainMenuInput(userInput, library);
        }
    }

    public static void handleMainMenuInput(String userInput, Song[] library) {
        switch (userInput.toLowerCase()) {
            case "h":
                System.out.println("");
                System.out.println("-->Home<--");
                break;
            case "s":
                Menu.displaySearchMenu();
                Scanner input = new Scanner(System.in);
                userInput = input.nextLine();
                if (userInput.toLowerCase().equals("h")) {
                    break;
                }
                Search.searchByTitle(userInput, library);
                isPlaying = true;
                break;
            case "l":
                System.out.println("");
                System.out.println("-->Library<--");
                Menu.displayLibrary(library);
                break;
            case "p":
                System.out.println("");
                System.out.println("-->Play<--");
                AudioPlayer.playRandomSong(library);
                isPlaying = true;
                break;
            case "q":
                System.out.println("-->Quit<--");
                AudioPlayer.stop();
                break;
            case "stop":
                AudioPlayer.stop();
                break;
            default:
                break;
        }
    }

    public static void handlePlaybackInput(String userInput, Song[] library) {
        switch (userInput.toLowerCase()) {
            case "next":
                AudioPlayer.playNextSong(library);
                break;
            case "prev":
                AudioPlayer.playPreviousSong(library);
                break;
            case "pause":
                AudioPlayer.pause();
                break;
            case "resume":
                AudioPlayer.resume();
                break;
            case "stop":
                AudioPlayer.stop();
                isPlaying = false;
                break;
            case "m":
                isPlaying = false;
                break;
            default:
                break;
        }
    }

    public static void skipSong() {
        Menu.skipSong();
        AudioPlayer.playRandomSong(AudioPlayer.library);
    }

    public static boolean isPlaying() {
        return isPlaying;
    }
}
