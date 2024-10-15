package com.javatify;

import java.util.Scanner;

public final class App {

    ;

    public static void main(String[] args) {
        Song[] library = LibraryManager.readAudioLibrary();
        Scanner input = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("q")) {
            if (UserInputHandler.isPlaying()) {
                Menu.displayPlaybackMenu();
                userInput = input.nextLine().toLowerCase();
                UserInputHandler.handlePlaybackInput(userInput, library);
            } else {
                Menu.displayMenu();
                userInput = input.nextLine().toLowerCase();
                UserInputHandler.handleUserInput(userInput, library);
            }
        }

        input.close();
    }
}
