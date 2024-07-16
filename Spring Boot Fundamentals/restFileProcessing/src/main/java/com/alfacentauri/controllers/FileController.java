package com.alfacentauri.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	
	@Value("${uploadDir}")
	private String UPLOAD_DIR;
	
	@PostMapping("/upload")
	public boolean upload(@RequestParam("file") MultipartFile file) {
		try {
			file.transferTo(new File(UPLOAD_DIR+file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<byte[]> download(@PathVariable("filename") String filename) {
		try {
			byte[] bytesData = Files.readAllBytes(new File(UPLOAD_DIR+filename).toPath());
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			
			return new ResponseEntity<byte[]>(bytesData, headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
