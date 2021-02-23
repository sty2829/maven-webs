<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
<%= session.getAttribute("name") %> 님 ㅎㅇ여
</body>
</html>