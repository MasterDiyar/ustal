package com.songs.spotlify.controller;


import com.songs.spotlify.model.Albums;
import com.songs.spotlify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/main")
    public String getAlbums(Model model) {
        List<Albums> albumsList = albumService.getAllAlbums();

        model.addAttribute("albums", albumsList);
        return "index";
    }
    @PostMapping("/main{delete_id}")
    public String deleteAlbum(@ModelAttribute int delete_id) {
        albumService.deleteAlbum((long) delete_id);
        return "redirect:/main";
    }

    @GetMapping("main/edit")
    public String editAlbum(@ModelAttribute int edit_id) {
        albumService.deleteAlbum((long) edit_id);
        return "addit";
    }

    @PostMapping("/main/edit")
    public String editAlbum(@RequestParam String album, @RequestParam int length, @RequestParam String author, Albums albums) {
        albums.setAlbum(album);
        albums.setLength(length);
        albums.setAuthor(author);
        albumService.saveAlbum(albums);
        return "redirect:/main";
    }

    @GetMapping("/main/search")
    public String getAlbum(@RequestParam("id") int id, Model model) {
        Albums albums = albumService.getAlbumById(id);
        model.addAttribute("albums", albums);
        return "index";
    }
    @GetMapping("main/add")
    public String addAlbum(Model model) {
        model.addAttribute("album", new Albums());
        return "addit";
    }

    @PostMapping("main/add")
    public String addAlbum(@RequestParam String album, @RequestParam int length, @RequestParam String author, Albums albums) {
        albums.setAlbum(album);
        albums.setLength(length);
        albums.setAuthor(author);
        albumService.saveAlbum(albums);
        return "redirect:/main";
    }
}
