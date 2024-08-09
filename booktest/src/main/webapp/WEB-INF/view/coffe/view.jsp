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

	<a href="/coffe">HOME</a>

	<div id="wrap">
		<h2>커피 상세 안내</h2>
		<dl id="menuWrap">
			<dt>${menu.getCoffe() }</dt>
			<dd>${menu.getPrice() }</dd>
			
			<c:test >
				<dd>${menu.getDecaffein() }</dd>
			</c:test>
			
		</dl>
	
	</div>





</body>


</html>

















