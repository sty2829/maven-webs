<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="msg" value="안뇽"/>
<c:set var="num" value="1"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${msg }<br>
<c:out value="${msg}"/><br>
<c:forEach var="idx" begin="1" end="10" step="3">
	${idx}<br>
</c:forEach>
<c:choose>
	<c:when test="${num eq '0'}">
		num는 0 이구나
	</c:when>
	<c:when test="${num eq '1'}">
		num는 1 이구나
	</c:when>
	<c:when test="${num  eq '2'}">
		num는 2 이구나
	</c:when>
	<c:otherwise>
		idx값은 대채뭐임?
	</c:otherwise>
</c:choose>

</body>
</html>