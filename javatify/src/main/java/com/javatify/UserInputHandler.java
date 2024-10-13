package com.javatify;

class UserInputHandler {

    public static void handleUserInput(String userInput, Song[] library) {
        switch (userInput.toLowerCase()) {
            case "h":
                System.out.println("-->Home<--");
                break;
            case "s":
                System.out.println("-->Search by title<--");
                Search.searchByTitle(userInput, library);
                break;
            case "l":
                System.out.println("-->Library<--");
                break;
            case "p":
                System.out.println("-->Play<--");
                AudioPlayer.play(library[3]);
                break;
            case "q":
                System.out.println("-->Quit<--");
                break;
            default:
                break;
        }
    }
}
