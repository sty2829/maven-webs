<%@page import="com.maven.web.dao.impl.UserDAOImpl"%>
<%@page import="com.maven.web.dao.UserDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="GET" action="/user/user-list">
	<input type="text" name="ui_name" placeholder="이름"><br>
	<input type="text" name="ui_id" placeholder="아이디"><br>
	<input type="text" name="ui_address" placeholder="주소"><br>
	<input type="text" name="ui_phone" placeholder="폰번호"><br>
	<button>검색</button>
</form>
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
<c:forEach var="user" items="${userList }">
	<tr>
		<td>${user.ui_num}</td>
		<td>${user.ui_name}</td>
		<td>${user.ui_id}</td>
		<td>${user.ui_pwd}</td>
		<td>${user.ui_genre}</td>
		<td>${user.phone}</td>
		<td>${user.ui_email}</td>
		<td>${user.ui_address}</td>
		<td>${user.credat}</td>
		<td>${user.cretim}</td>
		<td>${user.moddat}</td>
		<td>${user.modtim}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>