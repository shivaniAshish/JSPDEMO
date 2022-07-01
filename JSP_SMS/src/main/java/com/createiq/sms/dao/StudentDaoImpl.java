package com.createiq.sms.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.createiq.sms.model.Student;
import com.createiq.sms.queries.StudentQueries;
import com.createiq.sms.util.ConnectionUtil;


public class StudentDaoImpl implements StudentDao {
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	@Override
	public Student save(Student student) {
		try {
			connection = ConnectionUtil.openConnection();
			ps = connection.prepareStatement(StudentQueries.INSERT_SQL);
			ps.setString(1, student.getName());
//			System.out.println(student.getName());
			ps.setString(2, student.getEmail());
//			System.out.println(student.getEmail());
			ps.setString(3, student.getCourseName());
			int result = ps.executeUpdate();
			System.out.println(result + " inserted....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, ps);
		}
		return student;
	}

	@Override
	public Student update(Student student) {
		try {
			connection = ConnectionUtil.openConnection();
			ps = connection.prepareStatement(StudentQueries.UPDATE_SQL);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCourseName());
			ps.setInt(4, student.getId());
			System.out.println("Update method in studImpl : "+student);
			int result = ps.executeUpdate();
			System.out.println("Number of records were updated ..."+result + " updated....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, ps);
		}
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {

			connection = ConnectionUtil.openConnection();
			ps = connection.prepareStatement(StudentQueries.SELECT_ALL);
			rs = ps.executeQuery();       
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setCourseName(rs.getString(4));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, ps, rs);
		}

		return students;
	}

	@Override
	public int delete(Integer id) {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			connection=ConnectionUtil.openConnection();
			ps=connection.prepareStatement(StudentQueries.DELETE_BY_ID);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public Student getById(int id) {
		Student student=new Student();
		try {
			connection = ConnectionUtil.openConnection();
			ps = connection.prepareStatement(StudentQueries.FIND_BY_ID);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setCourseName(rs.getString(4));
				System.out.println("student Data : "+ student);
				}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, ps);
		}
		return student;
		 
	}

	public static void main(String[] args) {
		StudentDaoImpl impl = new StudentDaoImpl();
//	List<Student> allStudents = impl.getAllStudents();
//	for (Student student : allStudents) {
//		System.out.println(student);
//	}
		System.out.println(impl.getById(102));
	}
}
