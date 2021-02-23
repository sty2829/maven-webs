<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
	<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
	<div class="container">
		<h3>로그인</h3>
		<div>
			<input type="text" id="id" placeholder="아이디">		
		</div>
		<div>
			<input type="password" id="pwd" placeholder="비밀번호">		
		</div>
		<div style="margin-top:10px">
			<button onclick="login()">로그인</button>
		</div>
	</div>
<script>
function login(){
	var id = document.querySelector('#id').value;
	var pwd = document.querySelector('#pwd').value;
	var param = {
			id : id,
			pwd : pwd
	}
	param = JSON.stringify(param);
		
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/user/login');
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200 ){
			var res = JSON.parse(xhr.responseText);
			if(res.result == 1){
				alert('로그인에 성공하였습니다');
				location.href = '/';
			}else{
				alert('로그인에 실패하였습니다');
			}
			
		}
	}
	xhr.setRequestHeader('content-type', 'application/json')
	xhr.send(param);
}

</script>
</body>
</html>