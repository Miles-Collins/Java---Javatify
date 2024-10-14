package com.javatify;

class UserInputHandler {

    public static void handleUserInput(String userInput, Song[] library) {
        switch (userInput.toLowerCase()) {
            case "h":
                System.out.println("");
                System.out.println("-->Home<--");
                break;
            case "s":
                System.out.println("");
                System.out.println("-->Search by title<--");
                System.out.print("Enter title: ");
                userInput = System.console().readLine();
                Search.searchByTitle(userInput, library);
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
                break;
            case "q":
                System.out.println("-->Quit<--");
                break;
            case "stop":
                AudioPlayer.stop();
                break;
            default:
                break;
        }
    }

    public static void skipSong() {
        Menu.skipSong();
        // Scanner input = new Scanner(System.in);

        AudioPlayer.playRandomSong(AudioPlayer.library);
    }

}
