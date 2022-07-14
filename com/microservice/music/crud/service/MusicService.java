package com.microservice.music.crud.service;

import java.nio.file.Paths;
import java.util.List;

import org.springframework.data.mongodb.core.schema.MongoJsonSchema.ConflictResolutionFunction.Path;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microservice.music.crud.model.Music;

@Service
public interface MusicService {
	List<Music> getAllMusic();
	Music getMusicById(long musicId);
	Music createMusic(Music music);
	Music updateMusic(Music music);
	List<Music> getMusicByUploader(String musicUploader);
	void deleteMusic(long id);
	static String storeFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}
}
