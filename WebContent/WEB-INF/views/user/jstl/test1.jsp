<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setAttribute("msg", "아싸~~");
request.setAttribute("test", "아싸~");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${msg eq test}">${msg}와 ${test}는 같군요</c:if>
<c:if test="${msg ne test}">${msg}와 ${test}는 다르군요</c:if>
</body>
</html>