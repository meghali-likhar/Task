package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EmpDetails;

@Repository
public interface EmpRepository extends JpaRepository<EmpDetails, Integer> {

}
