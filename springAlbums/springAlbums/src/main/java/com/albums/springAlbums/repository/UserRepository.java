package com.albums.springAlbums.repository;

import com.albums.springAlbums.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {



}