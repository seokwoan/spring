<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/signUp">
		아이디 : <input type="text" id="id" name="id" placeholder="아이디"><br>
		비밀번호 : <input type="password" id="pw" name="pw" placeholder="비밀번호"><br>
		연락처 : <input type="text" id="tel" name="tel" placeholder="연락처"><br>
		생년월일 : <input type="date" id="birth" name="birth" placeholder="생년월일"><br>
		<button id="signUpButton">가입</button>
	</form>
	
</body>
</html>