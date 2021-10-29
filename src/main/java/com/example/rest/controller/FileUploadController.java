package com.example.rest.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.helper.FileUpload;

@RestController
public class FileUploadController {

	
	@Autowired
	private FileUpload fileUpload;
	
	@PostMapping(value = "/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile){
		
		
		if(multipartFile.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request must contain file");
		}else {
		
			System.out.println(multipartFile.getOriginalFilename());
			System.out.println(multipartFile.getContentType());
	
			System.out.println(multipartFile.getName());
			
			try {
				
				boolean b = fileUpload.upload(multipartFile);
				if(b) {
					
					return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image").path(multipartFile.getOriginalFilename()).toUriString());
				}else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
			} catch (IOException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		
			
			
		}
		
	}
} 
