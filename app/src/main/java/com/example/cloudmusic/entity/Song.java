package com.example.cloudmusic.entity;

import java.io.Serializable;

public class Song implements Serializable {
    private Integer songId;
    private String songName;
    private String author;
    private String songUrl;
    private String songCover;

    public Song() {
    }

    public Song(Integer songId, String songName, String author, String songUrl, String songCover) {
        this.songId = songId;
        this.songName = songName;
        this.author = author;
        this.songUrl = songUrl;
        this.songCover = songCover;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getSongCover() {
        return songCover;
    }

    public void setSongCover(String songCover) {
        this.songCover = songCover;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", author='" + author + '\'' +
                ", songUrl='" + songUrl + '\'' +
                ", songCover='" + songCover + '\'' +
                '}';
    }
}
