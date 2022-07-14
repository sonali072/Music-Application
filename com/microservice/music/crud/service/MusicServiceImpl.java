package com.microservice.music.crud.service;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema.ConflictResolutionFunction.Path;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.music.crud.model.Music;
import com.microservice.music.crud.repository.MusicRepository;

@Service
@Transactional
public  class MusicServiceImpl implements MusicService {
	
	@Autowired
	
	private MusicRepository musicRepository;
	
	//Constructor
	public MusicServiceImpl(MusicRepository musicRepository) {
		super();
		this.musicRepository = musicRepository;
	}
	/*
	Path fileStoragePath ;
	public MusicServiceImpl(@Value("(${file.storage.location.temp})")String fileStorageLocation) {
		fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
	}
	*/
	
	//Create music
	public Music createMusic(Music music) {
		Music newMusic = this.musicRepository.save(music);
		return newMusic;
	}
	
	//Update music
	public Music updateMusic(Music music) {
		Optional<Music> musicDb = this.musicRepository.findById(music.getId());
		
		Music existingMusic = musicDb.get();
		existingMusic.setId(music.getId());
		existingMusic.setTitle(music.getTitle());
		existingMusic.setArtist(music.getArtist());
		existingMusic.setGenre(music.getGenre());
		existingMusic.setLength(music.getLength());
		existingMusic.setUploader(music.getUploader());
		existingMusic.setUploadDate(music.getUploadDate());
		musicRepository.save(existingMusic);

		return existingMusic;		
	}
	
	//List of all songs
	public List<Music> getAllMusic() {
		List<Music> musicList = null;
		musicList = musicRepository.findAll();
		return musicList;
	}

	//Get music by music Id
	public Music getMusicById(long musicId) {
		Optional<Music> musicDb = null;
		musicDb = this.musicRepository.findById(musicId);
		return musicDb.get();
	}	
	
	//Get music according to a specific uploader
	public List<Music> getMusicByUploader(String musicUploader) {
		return musicRepository.findByUploader(musicUploader);
	}
	
	//Delete music
	@Override
	public void deleteMusic(long id) {
		// TODO Auto-generated method stub
		Optional<Music> musicDb = this.musicRepository.findById(id);
		this.musicRepository.delete(musicDb.get());
	}
}
