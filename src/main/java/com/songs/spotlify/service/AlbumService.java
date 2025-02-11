package com.songs.spotlify.service;


import com.songs.spotlify.model.Albums;
import com.songs.spotlify.repository.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumsRepository albumsRepository;

    public List<Albums> getAllAlbums() {
        return albumsRepository.findAll();
    }

    public void saveAlbum(Albums album) {
        albumsRepository.save(album);
    }

    public Albums getAlbumById(long id) {
        List<Albums> albums = albumsRepository.findAll();
        for (Albums album : albums) {
            if (album.getId() == id) {
                return album;
            }
        }
        return null;
    }

    public void deleteAlbum(Long id) {
        albumsRepository.deleteById(id);
    }

    public Albums updateAlbum(Albums album) {
        deleteAlbum(album.getId());
        return albumsRepository.save(album);
    }

    public List<Albums> getAllSortedAlbums() {
        List<Albums> albums = albumsRepository.findAll();
        albums.sort(Comparator.comparing(Albums::getAlbum));
        return albums;
    }

}
