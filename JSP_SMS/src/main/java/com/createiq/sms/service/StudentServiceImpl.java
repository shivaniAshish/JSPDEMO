package com.createiq.sms.service;

import java.util.List;

import com.createiq.sms.dao.StudentDaoImpl;
import com.createiq.sms.model.Student;

public class StudentServiceImpl implements StudentService {
private StudentDaoImpl daoImpl=new StudentDaoImpl();
	@Override
	public Student save(Student student) {
		return daoImpl.save(student);
	}

	@Override
	public Student update(Student student) {
		System.out.println("Updated method in service ly "+ daoImpl.update(student));
		return daoImpl.update(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return daoImpl.getAllStudents();
	}

	@Override
	public int delete(Integer id) {
		return daoImpl.delete(id);
	}

	public Student getById(int id) {
		
		return daoImpl.getById(id);
	}

}
