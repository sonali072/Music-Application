package com.microservice.music.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "SongDetails")
public class Music {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title,artist,genre,uploader,uploadDate;
	private double length;
	
	//Constructors
	public Music( long id, String title, String artist, String genre, String uploader, String uploadDate,
			 double length) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.uploader = uploader;
		this.uploadDate = uploadDate;
		this.length = length;
	}
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	
	//toString method()
	@Override
	public String toString() {
		return "Music [id=" + id +", title=" + title + ", artist=" + artist + ", genre=" + genre + ", uploader="
				+ uploader + ", uploadDate=" + uploadDate +  ", length=" + length + "]";
	}
}
