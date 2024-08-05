package com.example.test1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	
	// JSP MVC패턴 주소 맵핑
	// 주소패턴과 서블렛클래스 연결 ( web, xml )
	// 주소패턴이 다양하면 서블렛클래스 갯수도 늘어난다
	// 주소 요청을 처리할 메서드 지정을 위해 Map, properties 같은 주소와 메서드를 1:1 지정하여 처리하기 위한
	// 객체 또는 파일이 필요하다
	// 어떤 주소요청인지 파악하기 위한 코드와 실행 코드도 작성해야 한다

	
	// 스프링에서의 주소 맵핑 ( 요청 주소와 처리내용을 연결하는 작업 )
	// @Controller 클래스에 지정
	// 요청방식에 따른 주소 맵핑 -> @GetMapping("/") 요청주소 처리할 메서드 정의와 반환값으로 보여줄 페이지 이름
	// @PostMapping("/")

	@GetMapping("/test") // Controller로 등록된 클래스에서 직접 매핑해줌
						 // JSP에서처럼 web.xml맵핑, 서블렛 등을 만들지 않아도 됨
	public String testFitrst() {
		return "test"; // 리턴에는 보여줄 jsp파일 이름
	}
	
	@GetMapping( "/aaa.g" )
	public String testTwo() {
		return "login";
	}
	
	@GetMapping( "/signUp" )
	public String singUp() {
		return "member/signUp";
	}
	
	@PostMapping( "/signUp" )
	public String signUpSave( @RequestParam( "id" ) String id , @RequestParam( "pw" ) String pw , @RequestParam( "tel" ) String tel , @RequestParam( "birth") String birth ) {
		
		System.out.println( id );
		System.out.println( pw );
		System.out.println( tel );
		System.out.println( birth );
		
		return "member/signUp";
	}
	
	
	// 주소 요청 : /signUp
	// 뷰 페이지 : member/signUp.jsp
	// 뷰 페이지 내용 : 아이디, 비밀번호, 연락처, 생년월일 입력
	
}















