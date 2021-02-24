<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<Map<String,String>> userList = new ArrayList<>();
Map<String,String> user = new HashMap<>();
user.put("name", "길동");
user.put("age", "22");
userList.add(user);
user = new HashMap<>();
user.put("name", "꺽정");
user.put("age", "33");
userList.add(user);
request.setAttribute("userList", userList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>이름</th>
			<th>나이</th>			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.name}</td>			
				<td>${user.age}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>