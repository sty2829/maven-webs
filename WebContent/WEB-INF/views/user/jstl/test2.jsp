<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<String> strList = new ArrayList<>();
request.setAttribute("list", strList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty list }">내용이 없슈~</c:if>
<c:if test="${!empty list }">내용이 있어영 개꿀이쥬..</c:if>
</body>
</html>