package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.EmpDetails;
import com.example.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	EmpRepository empRepo;

	public ResponseEntity<String> addEmployee(EmpDetails emp) {
		try {
			empRepo.save(emp);
			return ResponseEntity.status(HttpStatus.OK).body("Employee added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Employee is not added");
		}
	}

	public List<EmpDetails> getAllEmp() {
		return empRepo.findAll();
	}

	public Optional<EmpDetails> getEmpById(int id) {
		return empRepo.findById(id);
	}

	public ResponseEntity<String> deleteById(int id) {
		try {
			empRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Employee is not deleted");
		}
	}

	public ResponseEntity<String> updateById(int id, EmpDetails employee) {
		try {
			EmpDetails empToUpdate = empRepo.getById(id);
			empToUpdate.setId(employee.getId());
			empToUpdate.setName(employee.getName());
			empToUpdate.setAge(employee.getAge());
			empToUpdate.setDepartment(employee.getDepartment());
			empToUpdate.setSalary(employee.getSalary());
			empRepo.save(empToUpdate);
			return ResponseEntity.status(HttpStatus.OK).body("Employee updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Employee is not updated");
		}
	}

}
