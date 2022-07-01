package com.createiq.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.createiq.sms.model.Student;
import com.createiq.sms.service.StudentServiceImpl;

@WebServlet("/Update")
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentServiceImpl updateservice = new StudentServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("My id  : "+id );
		Student student =updateservice.getById(id);
		System.out.println("My id student : "+student );
		request.setAttribute("student", student);
		request.getRequestDispatcher("sms-update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentServiceImpl updateservice = new StudentServiceImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String course=request.getParameter("course");
		Student student=new Student(id,name, email, course);
		updateservice.update(student);
		request.setAttribute("msg", "record updated  successfully");
		request.getRequestDispatcher("findAll").forward(request, response);
	}

}
