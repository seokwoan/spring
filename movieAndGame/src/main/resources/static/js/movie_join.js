/**
 * 
 */

$(function(){
	
	$("#joinBt").attr( "disabled" , true ); // 회원가입버튼 비활성화
	
	
	$("#email").focus()	
	
	$(".inputField input").on( "focus" , function(){
		$(this).addClass( "active" );
		$(this).next().addClass( "focus" );
	});
	
	$(".inputField input").on( "blur" , function(){
		var text = $(this).val();
		if( text == '' ){
			$(this).removeClass( "active" );
			$(this).next().removeClass( "focus" );
		}
	});
	
	// 태어난 년도 select에 option태그 추가 
	// 1924~2024의 기간중 2005년을 기본값으로 설정
	
	$("#birthYear").empty();
	$("#birthMonth").empty();

	for( var i = 2024 ; i >=1924 ; i-- ){
		
		var selected = i == 2005 ? "selected" : "";
		
		$("#birthYear").append(`<option value="${i}" ${selected}>${i}</option>`)
		// option 태그에 selected가 있는 value가 기본값으로 출력
	}
	
	// 태어난 월
	// 1 ~ 12월 페이지를 보는 현재의 월을 기본값으로 설정
	
	var today = new Date();
	
	var month = today.getMonth() + 1;
	
	for( var i = 1 ; i <= 12 ; i++ ){
		var selected = i == month ? "selected" : "";
		$("#birthMonth").append( ` <option value="${i}" ${selected}>${i}</option> ` );
		
	}
	
	// 비밀번호와 비밀번호 확인 두곳의 값이 일치하는지 확인
	$("#password").on( "keyup" , function(){
		if( $(this).val() != $("#chk").val() ){
			$("#pw1").text( "비밀번호가 일치하지 않습니다." );
			$("#pw1").css( "color" , "red" );
			$("#pw2").empty();
		}
		else{
			$("#pw1").text( "비밀번호가 일치합니다.");
			$("#pw1").css( "color" , "green" );
			$("#pw2").empty();
			$("#joinBt").attr( "disabled" , false );
		}
		
	});
	
		
	// 비밀번호와 비밀번호 확인 두곳의 값이 일치하는지 확인
	$("#chk").on( "keyup" , function(){
		if( $(this).val() != $("#password").val() ){
			$("#pw2").text( "비밀번호가 일치하지 않습니다." );
			$("#pw2").css( "color" , "red" );
			$("#pw1").empty();
		}
		else{
			$("#pw2").text( "비밀번호가 일치합니다.");
			$("#pw2").css( "color" , "green" );
			$("#pw1").empty();
			$("#joinBt").attr( "disabled" , false );
		}
		
	});
	
});