package com.maven.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.maven.web.dao.UserDAO;
import com.maven.web.dao.impl.UserDAOImpl;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();
    private UserDAO userDAO = new UserDAOImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		int idx = url.lastIndexOf("/");
		String cmd = url.substring(idx+1);
		if(cmd!=null) {
			if("user-list".equals(cmd)) {
				Map<String,String> pUser = new HashMap<>();
				pUser.put("ui_id", request.getParameter("ui_id"));
				pUser.put("ui_name", request.getParameter("ui_name"));
				pUser.put("ui_phone", request.getParameter("ui_phone"));
				pUser.put("ui_address", request.getParameter("ui_address"));
				System.out.println(pUser);
				List<Map<String, String>> userList = userDAO.getUserList(pUser);
				request.setAttribute("userList", userList);
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views" + url);
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		int idx = url.lastIndexOf("/");
		String cmd = url.substring(idx+1);
		Map<String,String> rMap = new HashMap<>();
		if("login".equals(cmd)) {
			BufferedReader br = request.getReader();
			String str = null;
			String json = "";
			while((str = br.readLine()) != null ) {
				json += str;
			}
			System.out.println(json);
			Map<String,String> user = gson.fromJson(json, Map.class);
			String id = user.get("id");
			String pwd = user.get("pwd");
			rMap.put("result", "0");
			if("id".equals(id)) {
				if("pwd".equals(pwd)) {
					HttpSession hs = request.getSession();
					hs.setAttribute("name", "두더지");
					rMap.put("result", "1");
				}
			}
		}
		response.setContentType("application/json;charSet=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(gson.toJson(rMap));
	}
}
