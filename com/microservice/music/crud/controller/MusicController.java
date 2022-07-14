package com.microservice.music.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microservice.music.fileUploadRespnose.FileUploadResponse;
import com.microservice.music.crud.model.Music;
import com.microservice.music.crud.service.MusicService;

@RestController 
public class MusicController{
	
	@Autowired
	private MusicService musicService;
		
	public MusicController(MusicService musicService) {
		super();
		this.musicService = musicService;
		}
/*
	//Single file upload
	@PostMapping("/single/upload")
	FileUploadResponse singlefileUpload(@RequestParam("file")MultipartFile file){
		String fileName = MusicService.storeFile(file);
		String contentType = file.getContentType();
		FileUploadResponse response = new FileUploadResponse(fileName,contentType );
		return response;
	}
*/	
	//User Login
	@RequestMapping("/userLogin")
	public String userValidation() {
		return "User successfully logged in!";
	}
	
	//Admin Login
	@RequestMapping("/adminLogin")
	public String adminValidation() {
		return "Admin user successfully logged in!";
	}

	//List all music records
	@GetMapping("/music")
	public ResponseEntity<?> getAllMusic(){
		return ResponseEntity.ok().body(musicService.getAllMusic());
	}

	//Get music by Id	
	@GetMapping("/music/{musicId}")
	public Music getMusicById(@PathVariable long musicId){
		return musicService.getMusicById(musicId);
	}
	
	//Get all music specific to a Uploader
	@GetMapping("/music/uploader/{musicUploader}")
	public List<Music> getMusicByUploader(@PathVariable String musicUploader){
		return musicService.getMusicByUploader(musicUploader);
	}
	
	//Create a new music record
	@PostMapping("/music")
	public ResponseEntity<?> createMusic(@RequestBody Music music){
		return ResponseEntity.ok().body(this.musicService.createMusic(music));
	}
	
	//Update music record by music Id
	@PutMapping("/music/{id}")
	public ResponseEntity<Music> updateMusic(@PathVariable long id, @RequestBody Music music){
		music.setId(id);
		return ResponseEntity.ok().body(this.musicService.updateMusic(music));
	}
	
	//Delete music record by music Id
	@DeleteMapping("/music/{id}")
	public ResponseEntity<String> deleteMusic(@PathVariable long id){
		this.musicService.deleteMusic(id);
		return new ResponseEntity<String>("Music record deleted successfully.", HttpStatus.OK);
	}
}