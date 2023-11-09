package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.EmpDetails;
import com.example.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {
	@Autowired
	EmpService empservice;

	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody EmpDetails emp) {
		return empservice.addEmployee(emp);
	}

	@GetMapping("/getall")
	public List<EmpDetails> getAllEmp() {
		return empservice.getAllEmp();
	}

	@GetMapping("/getbyid/{id}")
	public Optional<EmpDetails> getEmpById(@PathVariable int id) {
		return empservice.getEmpById(id);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		return empservice.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable int id, @RequestBody EmpDetails employee) {
		return empservice.updateById(id, employee);
	}

}
