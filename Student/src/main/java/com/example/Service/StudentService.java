package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.StudentDao;
import com.example.Entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao sdao;

	public String insertName(Student s) {
		return sdao.insertName(s);
	}

	public List<Student> getValue() {
		return sdao.getValue();
	}

	public List<Student> getAllStudents() {
		return sdao.getAllStudents();
	}

	public Student getStudentByLocation(String city) {
		return sdao.getStudentByLocation(city);
	}

	public List<Student> getStudentByMarks() {
		return sdao.getStudentByMarks();
	}

	public String updateStudentCityById(int id, String city) {
		return sdao.updateStudentCityById(id, city);
	}

	public String deleteStudentById(int id) {
		return sdao.deleteStudentById(id);
	}

	public List<Student> getStudentByMarksRange(int marks) {
		return sdao.getStudentByMarksRange(marks);
	}

}
