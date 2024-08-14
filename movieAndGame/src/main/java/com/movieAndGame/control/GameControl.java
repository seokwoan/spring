package com.movieAndGame.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.GameMember;
import com.movieAndGame.Dto.MovieMember;
import com.movieAndGame.service.GameMemberService;


@Controller
@RequestMapping("/game")
public class GameControl {
	
	@Autowired
	private GameMemberService gameMemberService;
	
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
		
		model.addAttribute( "gameMember" , new GameMember() );
		
		return "game/member/join";
	}

	@PostMapping( "/signUp" )
	public String signUp( @Valid GameMember gameMember, BindingResult bindingResult , Model model ) {
								// BindingResult를 사용할때 만드는 객체는 클래스의 이름으로 해야 인식 가능하다
								// 객체의 이름이 클래스와 다를 경우 객체를 인식하지 못해 사용하지못해 에러가 뜬다
		if( bindingResult.hasErrors() ) {
			
			return "game/member/join";
		}
		
		gameMemberService.signUpSave( gameMember );
		
		return "redirect:/game/login";
	}
	
}