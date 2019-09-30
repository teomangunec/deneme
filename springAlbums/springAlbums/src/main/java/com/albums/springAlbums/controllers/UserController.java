package com.albums.springAlbums.controllers;

import antlr.collections.List;

import com.albums.springAlbums.models.Album;
import com.albums.springAlbums.models.User;
import com.albums.springAlbums.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Iterable<User> list() {
        return userService.list();
    }
    
    @GetMapping("/users/{userId}/albums")
    @ResponseBody
    public Iterable<Album> getAlbumsByUserId(@PathVariable Long userId) {
        return userService.getAlbumsByUserId(userId);
    }

}