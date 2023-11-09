package com.finzly.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finzly.entity.CsvFile;
import com.finzly.repository.UserRepository;

@Service
public class CsvService {

	@Autowired
	UserRepository repository;

	public boolean isCsvfile(MultipartFile file) {
		String type = "text/csv";
		if (!type.equals(file.getContentType()))
			return false;
		return true;
	}

	public ResponseEntity<String> uploadAndSaveCsv(MultipartFile file) {
		try {
			List<CsvFile> list = csvToList(file.getInputStream());
			repository.saveAll(list);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("File Not Uploaded");
	}

	private List<CsvFile> csvToList(InputStream inputStream) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());) {

			List<CSVRecord> record = csvParser.getRecords();
			List<CsvFile> list = new ArrayList<>();

			for (CSVRecord oneRecord : record) {
				CsvFile csv = new CsvFile(oneRecord.get("Name"), oneRecord.get("Code"));
				list.add(csv);
			}
			return list;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
