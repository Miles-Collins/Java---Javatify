package com.javatify;

public class Song {

    private String name;
    private String artist;
    private String year;
    private String genre;
    private String fileName;

    // serializes attributes into a string
    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name;
        s += ", ";
        s += "artist: " + artist;
        s += ", ";
        s += "artist: " + year;
        s += ", ";
        s += "artist: " + genre;
        s += ", ";
        s += "fileName: " + fileName;
        s += " }";

        return s;
    }

    public Song(String fileName) {
        this.fileName = fileName;
    }

    // getters
    public String name() {
        return this.name;
    }

    public String year() {
        return this.year;
    }

    public String genre() {
        return this.genre;
    }

    public String artist() {
        return this.artist;
    }

    public String fileName() {
        return this.fileName;
    }
}
