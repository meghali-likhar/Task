package com.example.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.example.Entity.Student;

@Repository
public class StudentDao {

//	@Autowired
//	private Environment env;

	@Autowired
	private Student student;

	@Autowired
	SessionFactory sf;

	/*
	 * INSERTION
	 */
	public String insertName(Student s) {
//		String fname = env.getProperty("name.Firstname","Not available");
//		String lname = env.getProperty("name.Lastname","Not available");	

		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(s);

		transaction.commit();
		session.close();
		return "data inserted successfuly!!";

	}

	/*
	 * READ USING CRITERIA
	 */
	public List<Student> getValue() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", 1));
		return criteria.list();
	}

	/*
	 * READ ALL
	 */
	public List<Student> getAllStudents() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Student");
		return query.list();
//		return session.createQuery("from Student").list();

	}

	/*
	 * READ BY CITY
	 */
	public Student getStudentByLocation(String city) {
		Session session = sf.openSession();
		Query query = session.createQuery("from Student where city= :city");
		query.setString("city", city);
		return (Student) query.uniqueResult();
	}

	/*
	 * GET BY >MARKS<
	 */
	public List<Student> getStudentByMarks() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Student where marks between '" + 80 + "' and '" + 89 + "'");
		return query.list();

	}

	/*
	 * UPDATE BY ID
	 */
	public String updateStudentCityById(int id, String city) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("update Student set city= :city where id= :id");
		query.setParameter("city", city);
		query.setInteger("id", id);
		int result = query.executeUpdate();

		transaction.commit();
		return "Student updated successful..." + result + " rows affected!!";
	}

	/*
	 * DELETE
	 */
	public String deleteStudentById(int id) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("delete from Student where id= :id");
		query.setInteger("id", id);
		int result = query.executeUpdate();

		transaction.commit();
		return "Student deleted successful..." + result + " rows affected!!";
	}

	/*
	 * GET BY >MARKS
	 */
	public List<Student> getStudentByMarksRange(int marks) {
		Session session = sf.openSession();
		Query query = session.createQuery("from Student where marks > :marks");
		query.setInteger("marks", marks);
		return query.list();
	}

}
