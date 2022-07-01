package com.createiq.sms.controller;

import java.io.IOException;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.createiq.sms.model.Student;
import com.createiq.sms.service.StudentServiceImpl;

@WebServlet("/register")
public class StudentRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServiceImpl registerservice=new StudentServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String course=request.getParameter("course");
		Student student=new Student(name, email, course);
		registerservice.save(student);
		request.setAttribute("msg", "record saved  successfully");
		request.getRequestDispatcher("findAll").forward(request, response);
	}

}
