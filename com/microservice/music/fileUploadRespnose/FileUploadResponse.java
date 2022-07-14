package com.microservice.music.fileUploadRespnose;

public class FileUploadResponse {
	private String fileName,contentType;

	public FileUploadResponse(String fileName, String contentType) {
		super();
		this.fileName = fileName;
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
