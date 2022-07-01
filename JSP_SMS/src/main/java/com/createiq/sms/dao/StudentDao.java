package com.createiq.sms.dao;

import java.util.List;

import com.createiq.sms.model.Student;

public interface StudentDao {
	Student save(Student student);

	Student update(Student student);

	List<Student> getAllStudents();

	int delete(Integer id);
	
	 Student getById(int id);

}
