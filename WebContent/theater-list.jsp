<%@page import="com.maven.web.dao.impl.TheaterDAOImpl"%>
<%@page import="com.maven.web.dao.TheaterDAO"%>
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
		<th>극장명</th>
		<th>주소</th>
		<th>전화번호1</th>
		<th>전화번호2</th>
	</tr>
<%
List<Map<String,String>> theaterList = (List<Map<String,String>>)request.getAttribute("theaterList"); 
for(Map<String,String> theater : theaterList){
%>
	<tr>
		<td><%=theater.get("ti_num") %></td>
		<td><%=theater.get("ti_name") %></td>
		<td><%=theater.get("ti_address") %></td>
		<td><%=theater.get("ti_phone1") %></td>
		<td><%=theater.get("ti_phone2") %></td>
	</tr>
<%	
}
%>
</table>
</body>
</html>