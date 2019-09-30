package com.albums.springAlbums.services;

import com.albums.springAlbums.models.Album;
import com.albums.springAlbums.models.User;
import com.albums.springAlbums.repository.UserRepository;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
    	RestTemplate restTemplate = new RestTemplate();
    	
    	
    	ResponseEntity<List<User>> userResponse =
    	        restTemplate.exchange("https://jsonplaceholder.typicode.com/users",
    	                    HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
    	            });
    	List<User> users = userResponse.getBody();
    	return users;
    }

    public List<Album> getAlbumsByUserId(Long userId) {
    	RestTemplate restTemplateAlbums = new RestTemplate();
    	
    	ResponseEntity<List<Album>> albumResponse =
    			restTemplateAlbums.exchange("https://jsonplaceholder.typicode.com/albums",
    	                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
    	            });
    	List<Album> albums = albumResponse.getBody();
    	
    	List<Album> albumsByUserId = albums.stream()
                .filter(album -> album.getUserId() == userId)
                .collect(Collectors.toList());
    	
    	return albumsByUserId;
    }
}



