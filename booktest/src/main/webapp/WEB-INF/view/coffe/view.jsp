<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<script src="/javascript/info.js"></script>
<!-- book/view.jsp와 같은 스크립트파일을 가짐 -->

<script>
	inputType = [ "text" , "number" , "number" ];
	inputName = [ "coffe" , "price" , "decaffein" ];

</script>


</head>

<body>

	<form id="fm" method="get" action="/coffe/delete">
		<input type="hidden" name="menu" value="${menu.coffeId }">
		<!-- 같은 스크립트 파일을 가지므로 form태그의 액션과 hidden input의 value를 서로 다르게 넣어 같은 스크립트의
			 같은 함수를 사용해도 서로 다른 컨트롤로 작동함
		 -->

		<div id="wrap">
			<a href="/coffe">HOME</a>
			
			<h2>커피 상세 안내</h2>
			
			<table id="viewBox">
				<tr>
					<td class="fieldName">커피 종류</td>
					<td class="value">${menu.getCoffe() }</td>
				</tr>
				
				<tr>
					<td class="fieldName">금액</td>
					<td class="value">${menu.getPrice() }</td>
				</tr>
				
				<tr>
					<td class="fieldName">디카페인</td>
					<td class="value">${menu.getDecaffein() }</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<button type="button" id="modify">수정</button>
						<button type="button" id="del" data-menu="${menu.coffeId }">삭제</button>				
					</td>
				</tr>
					
			</table>
		
		</div>

	</form>

</body>


</html>