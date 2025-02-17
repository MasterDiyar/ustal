package com.songs.spotlify.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "albums")
public class Albums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String album;
    private int length;
    private String author;

    public Albums() {}

    public Albums(String album, int length, String author) {
        this.album = album;
        this.length = length;
        this.author = author;
    }

    public String toString(){
        return "Album{" +
                "album='" + album + '\'' +
                ", length='" + length + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
