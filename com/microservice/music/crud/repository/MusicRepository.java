package com.microservice.music.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.music.crud.model.Music;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MusicRepository extends MongoRepository<Music, Long>{

		List<Music> findByUploader(String musicUploader);
		List<Music> findByArtist(String musicArtist);
}