package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.GameMember;


@Controller
@RequestMapping("/game")
public class GameControl {
	
	// 기본 페이지
	@GetMapping("")
	public String gameHome( Model model ) {
		return "/game/index";
	}
	
	// 로그인 페이지
	@GetMapping( "/login" )
	public String gameLogin( Model model ) {
		
		model.addAttribute( "member" , new GameMember() );
		
		return "game/member/login";
	}
	
	// 회원가입 페이지
	@GetMapping( "/signUp" )
	public String gameSignUp( Model model ) {
		
		return "game/member/join";
	}

}
