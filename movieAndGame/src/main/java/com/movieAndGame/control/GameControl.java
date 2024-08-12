package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.GameMember;


@Controller
@RequestMapping("/game")
public class GameControl {
	
	@GetMapping("")
	public String gameHome() {
		return "/game/index";
	}
	
	@GetMapping( "/login" )
	public String gameLogin( Model model ) {
		
		model.addAttribute( "member" , new GameMember() );
		
		return "game/member/login";
	}

}
