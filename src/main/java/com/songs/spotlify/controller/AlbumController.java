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
    public String deleteAlbum(@ModelAttribute("delete_id") long delete_id) {
        albumService.deleteAlbum( delete_id);
        return "redirect:/main";
    }

    @GetMapping("main/edit")
    public String editAlbum(@ModelAttribute Albums album, Model model) {
        model.addAttribute("album", new Albums());
        albumService.deleteAlbum((long) album.getId());
        return "addit";
    }

    @PostMapping("/main/edit")
    public String edityAlbum(@ModelAttribute Albums albums, Model model) {
        albumService.saveAlbum(albums);
        model.addAttribute("albums", albums);
        return "redirect:/main";
    }

    @GetMapping("/main/search")
    public String getAlbum(@RequestParam String id, Model model) {
        Albums albums = albumService.getAlbumById(Integer.parseInt(id));
        model.addAttribute("albums", albums);
        return "index";
    }
    @GetMapping("main/add")
    public String addAlbum(Model model) {
        model.addAttribute("album", new Albums());
        return "addit";
    }

    @PostMapping("main/add")
    public String addAlbum(@ModelAttribute Albums albums, Model model) {
        albumService.saveAlbum(albums);
        model.addAttribute("albums", albums);
        return "redirect:/main";
    }

    @GetMapping("main/sort")
    public String sortAlbum(Model model) {
        model.addAttribute("albums", albumService.getAllSortedAlbums());
        return "index";
    }
}
