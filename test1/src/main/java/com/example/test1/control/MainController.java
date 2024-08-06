package com.example.test1.control;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test1.DTO.LoginDto;
import com.example.test1.DTO.MemberDTO;


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
	
	@GetMapping( "/login" )
	public String login() {
		return "login";
	}
	
	
	@PostMapping( "/login" )
	public String loginResult( @ModelAttribute LoginDto logindto ) {
		
		System.out.println( "입력한 아이디 : " + logindto.getId() );
		System.out.println( "입력한 비밀번호 : " + logindto.getPw() );
		
		return "loginResult";
	}


	// form 데이터 받아오는 방법1
//	@PostMapping( "/signUp" )
//	public String signUpSave( @RequestParam( "id" ) String id , @RequestParam( "pw" ) String pw , @RequestParam( "tel" ) String tel , @RequestParam( "birth") String birth ) {
//		
//		System.out.println( id );
//		System.out.println( pw );
//		System.out.println( tel );
//		System.out.println( birth );
//		
//		return "member/signUp";
//	}
	// 입력받는 변수가 많으면 매개변수가 늘어남
	
	
	// form 데이터 받아오는 방법2
//	@PostMapping( "/signUp" )
//	public String signUpSave( @ModelAttribute MemberDTO memberDto ) {
//								// @ModelAttribute 애노테이션으로 request를 통해 받은 값을 객체에 넣어줌
//		System.out.println( memberDto.getId());
//		
//		return "member/signUp";
//	}
	// 데이터 베이스 저장에 가장 좋은 방법
	
	// form 데이터 받아오는 방법3 -> 범용성이 넓다 / 데이터베이스 저장이 까다롭다
	@PostMapping( "/signUp" )
	public String signUpSave( @RequestParam Map< String , String > pm ) {
		
		System.out.println( "세번째 방법 : " + pm.get( "id" ) );
		
		return "member/signUp";
	}
	
	// form 데이터 받아오기 실습
	// 내용 : 로그인을 위해 로그인 페이지에서 아이디와 비밀번호를 입력하고 로그인 버튼을 클릭한다
	// DTO 클래스 : LoginDto
	// 뷰 페이지	: login.jsp - 로그인 form페이지
	//			: loginResult.jsp - 로그인 후 보여줄 페이지
	// loginResult.jsp에 <a href="/test"> 페이지 이동 </a> 넣기
	
	// 요청 주소 및 방식 :	로그인페이지 - GET방식, /login
	// 					로그인처리 - POST방식, /login
	
	
	
	
	
	// 주소 요청 : /signUp
	// 뷰 페이지 : member/signUp.jsp
	// 뷰 페이지 내용 : 아이디, 비밀번호, 연락처, 생년월일 입력
	
}


// 자바빈	: 클래스의 인스턴스 변수는 input의 name과 일치시켜준다
//		: 클래스의 기본 생성 메서드가 필요하다
//		: 인스턴스변수의 get, set 메서드
//		: 인스턴스변수의 제어자는 private












