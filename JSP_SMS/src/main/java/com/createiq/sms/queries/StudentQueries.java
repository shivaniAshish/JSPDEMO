package com.createiq.sms.queries;

public interface StudentQueries {
	String SELECT_ALL = "select * from student";
	String INSERT_SQL = "insert into student (name, email, courseName) values(?,?,?)";
	String UPDATE_SQL = "update student set name=?, email=?, courseName=? where  id=?";
	String DELETE_BY_ID = "Delete from student where id=?";
	String FIND_BY_ID = "select * from student where id=?";
}
