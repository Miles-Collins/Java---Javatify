package com.javatify;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

class LibraryManager {

    public static Song[] readAudioLibrary() {
        String filePath = Config.getDirectoryPath() + "/audio-library.json";
        Song[] library = null;

        try {
            JsonReader reader = new JsonReader(new FileReader(filePath));
            library = new Gson().fromJson(reader, Song[].class);
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.printf("ERROR: unable to read the file %s\n", filePath);
        }

        return library;
    }
}
