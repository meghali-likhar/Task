package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private int age;
	private String city;
	private int marks;

	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public int getMarks() {
		return marks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", age=" + age + ", city=" + city + ", marks=" + marks + "]";
	}

}
