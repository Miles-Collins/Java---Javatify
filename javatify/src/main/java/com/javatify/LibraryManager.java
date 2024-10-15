package com.javatify;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

class LibraryManager {

    static Song[] library = null;

    public static Song[] readAudioLibrary() {
        String filePath = Config.getDirectoryPath() + "/audio-library.json";

        try {
            JsonReader reader = new JsonReader(new FileReader(filePath));
            library = new Gson().fromJson(reader, Song[].class);
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.printf("ERROR: unable to read the file %s\n", filePath);
        }

        return library;
    }

    public static int returnIndex(Song song) {
        for (int i = 0; i < library.length; i++) {
            if (library[i].name().equals(song.name()) && library[i].artist().equals(song.artist())) {
                return i;
            }
        }
        return -1;
    }
}
