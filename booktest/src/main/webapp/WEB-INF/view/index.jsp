<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>도서관리</title>

<link rel="stylesheet" href="/css/default.css">

</head>

<body>

	<a href="/coffeReg">커피등록</a>
	<!-- 
		컨트롤 : CoffeControl
		서비스 : CoffeService
		DTO : CoffeDto
		DAO : CoffeDao
	 -->

	<div id="wrap">
		<h2>도서관</h2>
		
		<div id="mainTitle">
			<h3>등록 도서 목록</h3>
			<a href="/bookWrite" id="enroll">도서등록</a>
		</div>
		
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="bList">
					<span class="title">자바의 기초</span>
					<span class="auth">홍길동</span>
					<span class="bookCOde">ㅈc03홍2934</span>
					<span class="category">컴퓨터 프로그램언어</span>
				</li>
				
				<li class="bList">
					<span class="title">안드로이드sdk</span>
					<span class="auth">김유신</span>
					<span class="bookCOde">ㅇc84김9384</span>
					<span class="category">컴퓨터 운영체제</span>
				</li>
				
				<li class="bList">
					<span class="title">C언어 도장깨기</span>
					<span class="auth">최배달</span>
					<span class="bookCOde">ㅆc12최2384</span>
					<span class="category"></span>
				</li>
				
				<li class="bList">
					<span class="title">Who Am I</span>
					<span class="auth">토비 맥과이어</span>
					<span class="bookCOde">ㅎg11토0084</span>
					<span class="category">철학</span>
				</li>
				
				<li class="bList">
					<span class="title">카카오는 왜 노란색인가</span>
					<span class="auth">카카오안티</span>
					<span class="bookCOde">ㅋr90카1123</span>
					<span class="category">미술</span>
				</li>
				
			</ul>	
				
		</div>
		
	</div>






</body>

</html>













































