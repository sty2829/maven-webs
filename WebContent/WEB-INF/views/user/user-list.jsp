<%@page import="com.maven.web.dao.impl.UserDAOImpl"%>
<%@page import="com.maven.web.dao.UserDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>장르</th>
		<th>폰번호</th>
		<th>이메일</th>
		<th>주소</th>
		<th>등록일</th>
		<th>등록시간</th>
		<th>수정일</th>
		<th>수정시간</th>
	</tr>
<%
List<Map<String,String>> userList = (List<Map<String,String>>)request.getAttribute("userList");
for(Map<String,String> user : userList){	
%>
	<tr>
		<td><%=user.get("ui_num") %></td>
		<td><%=user.get("ui_name") %></td>
		<td><%=user.get("ui_id") %></td>
		<td><%=user.get("ui_pwd") %></td>
		<td><%=user.get("ui_genre") %></td>
		<td><%=user.get("phone") %></td>
		<td><%=user.get("ui_email") %></td>
		<td><%=user.get("ui_address") %></td>
		<td><%=user.get("credat") %></td>
		<td><%=user.get("cretim") %></td>
		<td><%=user.get("moddat") %></td>
		<td><%=user.get("modtim") %></td>
	</tr>
<%	
}
%>
</table>
</body>
</html>