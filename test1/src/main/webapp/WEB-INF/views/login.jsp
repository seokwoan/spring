<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 나는 login </h1>

	<form method="post" action="/login">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<button>로그인</button>
	</form>
</body>
</html>

<!--
LoginDto 클래스 생성
	- 클래스에서 변수 생성 id, pw 

뷰페이지 생성 - 로그인.jsp
	- form태그 post
	- 클래스에서 생성한 변수명을 name으로 갖는 input태그
	- 로그인 버튼

뷰페이지 생성 - loginResult.jsp
	- a태그 만들기

Maincontroller 클래스에서 맵핑
	- @GetMapping -> login.jsp로 이동만 
	- @PostMapping -> 입력한 아이디, 비밀번호 콘솔출력, loginResult.jsp로 이동
-->