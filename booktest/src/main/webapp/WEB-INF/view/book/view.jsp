<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>도서정보 보기</title>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/info.css">

<script src="/javascript/info.js"></script>

</head>


<body>

	<div id="wrap">
		<a href="/">HOME</a>
		
		
		<table id="viewBox">
			<tr>
				<td class="fieldName">책 제목</td>
				<td class="value">${book.getBookTitle() }</td>
			</tr>
			
			<tr>
				<td class="fieldName">저자</td>
				<td class="value">${book.bookAuthor }</td>
			</tr>
			
			<tr>
				<td class="fieldName">출판사</td>
				<td class="value">${book.getPublisher() }</td>
			</tr>
			
			<tr>
				<td class="fieldName">페이지 수</td>
				<td class="value">
					<fmt:formatNumber value="${book.getBookPage() }" pattern="#,###"/>
				</td>
			</tr>
			
			<tr>
				<td class="fieldName">가격</td>
				<td class="value">
					<fmt:setLocale value="" />
					<fmt:formatNumber value="${book.getBookCost() }" type="currency"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<button type="button" id="modify">수정</button>
					<button type="button" id="del">삭제</button>				
				</td>
			</tr>
				
		</table>
	
	</div>

</body>

</html>