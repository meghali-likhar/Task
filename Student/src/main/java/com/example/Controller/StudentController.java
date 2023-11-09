package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Student;
import com.example.Service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService service;

//	@Value("${Fisrtname}")
//	private String firstname;
//	
//	@Value("${Lastname}")
//	private String lastname;
//	
//	@GetMapping("getvalues")
//	public String getValueFromPropertiesUsingValues()
//	{
//		return "@Value Firtname: "+firstname+" Lastname: " +lastname ; 
//	}

	@GetMapping("getstudent")
	public List<Student> getValue() {
		return service.getValue();
	}

	@PostMapping("insertstudent")
	public String insertName(@RequestBody Student s) {
		return service.insertName(s);
	}

	@GetMapping("getallstudents")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	@GetMapping("getstudentbylocation/{city}")
	public Student getStudentByLocation(@PathVariable String city) {
		return service.getStudentByLocation(city);
	}

	@GetMapping("getstudentbymarksrange")
	public List<Student> getStudentByMarks() {
		return service.getStudentByMarks();
	}

	@PutMapping("updatecity/{id}")
	public String updateStudentCityById(@PathVariable int id, @RequestBody String city) {
		return service.updateStudentCityById(id, city);
	}

	@DeleteMapping("deletestudent/{id}")
	public String deleteStudentById(@PathVariable int id) {
		return service.deleteStudentById(id);
	}
	
	@GetMapping("getstudentbymarks/{marks}")
	public List<Student> getStudentByMarksRange(@PathVariable int marks) {
		return service.getStudentByMarksRange(marks);
	}
}
