package com.maven.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maven.web.dao.TheaterDAO;
import com.maven.web.dao.impl.TheaterDAOImpl;

public class TheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TheaterDAO theaterDAO = new TheaterDAOImpl(); 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		int idx = url.lastIndexOf("/");
		String cmd = url.substring(idx+1);
		String path = "";
		if("list".equals(cmd)) {
			List<Map<String, String>> theaterList = theaterDAO.getTheaterList();
			request.setAttribute("theaterList", theaterList);
			path = "/theater-list.jsp";
			
		}
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
