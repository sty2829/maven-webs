<%@page import="com.maven.web.dao.impl.TheaterDAOImpl"%>
<%@page import="com.maven.web.dao.TheaterDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="GET" action="/theater/theater-list">
	<input type="text" name="ti_name" placeholder="영화관"><br>
	<input type="text" name="ti_address" placeholder="주소"><br>
	<button>검색</button>
</form>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>극장명</th>
			<th>주소</th>
			<th>전화번호1</th>
			<th>전화번호2</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ti" items="${theaterList}">
			<tr>
				<td>${ti.ti_num}</td>
				<td>${ti.ti_name}</td>
				<td>${ti.ti_address}</td>
				<td>${ti.ti_phone1}</td>
				<td>${ti.ti_phone2}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>