package com.example.cloudmusic.entity;

import java.util.List;

public class Album {
    private Integer albumId;
    private String albumName;
    private String albumCover;
    private String playVolume;
    private List<Song> songList;

    public Album() {
    }

    public Album(Integer albumId, String albumName, String albumCover, String playVolume, List<Song> songList) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumCover = albumCover;
        this.playVolume = playVolume;
        this.songList = songList;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public String getPlayVolume() {
        return playVolume;
    }

    public void setPlayVolume(String playVolume) {
        this.playVolume = playVolume;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumCover='" + albumCover + '\'' +
                ", playVolume='" + playVolume + '\'' +
                ", songList=" + songList +
                '}';
    }
}
