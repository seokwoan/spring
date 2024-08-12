/**
 * 
 */

let inputType = [];
let inputName = [];

$(function(){
	$("#del").on( "click" , function(){
		var isOk = confirm( "정말로 삭제하시겠습니까?" );
		
		if( isOk ){
			$("#fm").submit();
		}
		
	});
	
	
	$("#modify").on( "click" , function(){
		$.each( $(".value") , function( i , v ){ // i - 인덱스, v - i인덱스의 값
			var text = $(v).text().trim();
			
			if( inputType[i] === "number" ){
				text = text.replace ( /[^0-9]/g ,""); // 천단위 콤마표식 제거
			}
				
			$(v).html( "<input type='" + inputType[i] + "' name='" + inputName[i] + "' value='" + text + "'>" );
			
		});	
		
		// 클래스명이 value인 td내부 설정
		$(this).attr( "id" , "mod" );
		
		var url = $("#fm").attr( "action" ); // form태그의 action값 가져오기
		
		url = url.replace( "delete" , "update" ); // 주소 변경 /book/update 또는 /coffe/update
		
		$("#fm").attr( "action" , url ); // 변경된 주소로 바꿔줌
		
		$(this).off( "click" );
		
		$("#mod").on( "click" , function(){
			$("#fm").submit();
		});
		
	});

});