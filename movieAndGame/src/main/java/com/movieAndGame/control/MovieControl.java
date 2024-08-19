package com.movieAndGame.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.MovieMember;
import com.movieAndGame.service.MovieMemberService;

@Controller
@RequestMapping("/movie") // 시작을 movie하는 주소의 처리를 전부 해줌 컨트롤러에서 mapping을 할때 movie를 안적어도됨
public class MovieControl {

	@Autowired
	private MovieMemberService movieMemberService;
	
	// 기본 페이지
	@GetMapping( "/index" )
	public String Home( Model model) {
		return "movie/index";
	}
	
	// 로그인 페이지
	@GetMapping( "/login" )
	public String loginHome(Model model,HttpServletRequest request) {
		
		String preUri = request.getHeader("Referer");// 로그인 이전 페이지
		request.getSession().setAttribute("preUri", preUri);
		model.addAttribute("member" , new MovieMember() );
		
		return "movie/member/login";
	}
	
	// 회원가입 페이지
	@GetMapping( "/signUp" )
	public String signUp( Model model ) {
		
		model.addAttribute( "movieMember" , new MovieMember() );
		
		return "movie/member/join";
	}
	
	// 회원가입 작성
	@PostMapping( "/signUp" )
	public String signUp( @Valid MovieMember movieMember, BindingResult bindingResult , Model model ) {
						// @Valid - form에서 넘어온 객체의 유효성을 확인해줌 조건은 DTO에서 설정
						// BindingResult가 valid에서 생긴 오류를 받아줌, 반드시 valid의 뒤에 있어야 한다
		if( bindingResult.hasErrors() ) {
			// valid에서 에러가 있다면 bindingResult가 받아옴 -> hasErrors()가 참이면 에러가 있다
			System.out.println( "유효하지 않은 값이 입력되었다" );
			
			return "movie/member/join";
			
		}
		
		//데이터베이스에 저장
		boolean isDup = movieMemberService.signUpSave(movieMember);
		if( isDup) { // 이메일이 중복이라면 회원가입 페이지로 이동시킨다.
			bindingResult.rejectValue("email", "error.email","가입된 이메일 입니다.");
			return "movie/member/join";	
		}
		
		return "redirect:/movie/login";
	}
	
	// 로그인 처리 요청
	@PostMapping("/signIn")
	public String signIn(  MovieMember member, HttpSession session
			,Model model) {
		// 로그인 처리 - 데이터베이스에 이메일과 비번이 일치하는지 확인하고
		// 일치하면 세션 만들고 첫페이지로 이동 , 일치하지않으면 로그인 페이지로 돌려보내기
		
		MovieMember user = movieMemberService.login(member);
		if(user==null) { // 로그인 실패(이메일또는 비번 잘못)
			model.addAttribute("member",member);
			model.addAttribute("fail","a");    
			return "movie/member/login";
		}
		// 로그인 성공시 로그인 화면 이전 방문 페이지 이동
		String preUri = (String)session.getAttribute("preUri");
		session.setAttribute("user", user);
		return "redirect:"+preUri;//"redirect:/game/index";
	}
	
	
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/movie/index";
	}
	
}
