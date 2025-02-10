package com.songs.spotlify.repository;

import com.songs.spotlify.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Albums, Long> {

}
