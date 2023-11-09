package com.finzly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finzly.entity.CsvFile;

@Repository
public interface UserRepository extends JpaRepository<CsvFile, Integer> {

}
