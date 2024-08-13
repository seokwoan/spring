package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.MovieMember;

@Controller
@RequestMapping("/movie") // 시작을 movie하는 주소의 처리를 전부 해줌 컨트롤러에서 mapping을 할때 movie를 안적어도됨
public class MovieControl {

	@GetMapping( "/index" )
	public String Home( Model model) {
		return "movie/index";
	}
	
	@GetMapping( "/login" )
	public String loginHome( Model model ) {
		
		model.addAttribute( "member" , new MovieMember() );
		
		return "movie/member/login";
	}
	
	@GetMapping( "/signUp" )
	public String signUp( Model model ) {
		
		return "movie/member/join";
	}
}
