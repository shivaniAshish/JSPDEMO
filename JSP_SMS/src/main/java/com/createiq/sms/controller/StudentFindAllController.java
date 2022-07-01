package com.createiq.sms.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.createiq.sms.model.Student;
import com.createiq.sms.service.StudentServiceImpl;
@WebServlet("/findAll")
public class StudentFindAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServiceImpl findallservice = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> allStudents = findallservice.getAllStudents();
		request.setAttribute("students", allStudents);
		request.getRequestDispatcher("sms-list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
