package com.file.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.file.service.FileService;

@RestController
@RequestMapping("file")
public class FileController {
	@Autowired
	FileService fileService;

	@PostConstruct
	@PostMapping("insertdata")
	public ResponseEntity<String> loadAndSaveProperties() {
		return fileService.loadAndSaveProperties();
	}

}
