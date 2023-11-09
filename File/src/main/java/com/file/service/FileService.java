package com.file.service;

//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.file.entity.FileProperty;
import com.file.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository propertyRepository;

	public ResponseEntity<String> loadAndSaveProperties() {

		HashMap<String, String> map = new HashMap<>();
		try {
//			InputStream inputStream = new ClassPathResource("application.properties").getInputStream();
//			int character;
//			StringBuilder line = new StringBuilder();
//
//			while ((character = inputStream.read()) != -1) {
//				char characterNew = (char) character;
//				if (characterNew == '\n') {
//					String[] content = line.toString().split("=");
//					if (content.length == 2) {
//						String key = content[0];
//						String value = content[1];
//						map.put(key, value);
//					}
//    				line.setLength(0);
//				} else {
//					line.append(characterNew);
//				}

			InputStream inputStream = new ClassPathResource("application.properties").getInputStream();
			int character;
			StringBuilder key = new StringBuilder();
			StringBuilder value = new StringBuilder();
			boolean isKey = true;

			while ((character = inputStream.read()) != -1) {
				char characterNew = (char) character;
				if (characterNew == '\n') {
					map.put(key.toString(), value.toString());
					key.setLength(0);
					value.setLength(0);
					isKey = true;
				} else if (characterNew == '=') {
					isKey = false;
				} else {
					if (isKey) {
						key.append(characterNew);
					} else {
						value.append(characterNew);
					}
				}
			}
			saveProperties(map);
			return ResponseEntity.ok("Properties loaded and saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Failed to load and save properties");
		}
	}

	public void saveProperties(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();

			FileProperty file = new FileProperty(); // FileProperty=entity
			file.setName(name);
			file.setValue(value);

			propertyRepository.save(file);
		}
	}
}
