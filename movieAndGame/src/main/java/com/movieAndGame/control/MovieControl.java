package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.MovieMember;

@Controller
@RequestMapping("/movie") // 시작을 movie하는 주소의 처리를 전부 해줌 컨트롤러에서 mapping을 할때 movie를 안적어도됨
public class MovieControl {

	// 기본 페이지
	@GetMapping( "/index" )
	public String Home( Model model) {
		return "movie/index";
	}
	
	// 로그인 페이지
	@GetMapping( "/login" )
	public String loginHome( Model model ) {
		
		model.addAttribute( "member" , new MovieMember() );
		
		return "movie/member/login";
	}
	
	// 회원가입 페이지
	@GetMapping( "/signUp" )
	public String signUp( Model model ) {
		
		model.addAttribute( "movieMember" , new MovieMember() );
		
		return "movie/member/join";
	}
}