package com.file.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.entity.FileProperty;

@Repository
public interface FileRepository extends JpaRepository<FileProperty, Integer> {

	void save(Map<String, String> map);

}
