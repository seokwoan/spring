package com.movieAndGame.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.GameMember;
import com.movieAndGame.service.GameMemberService;
import com.movieAndGame.Dto.GameMemberLogin;


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
	public String login( Model model , HttpServletRequest request ) {
		
		String preUri = request.getHeader("Referer");// 로그인 이전 페이지
		request.getSession().setAttribute("preUri", preUri);
		model.addAttribute("gameMemberLogin" , new GameMemberLogin());		
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
	
	//로그인
		@PostMapping("/signIn")
		public String signIn(@Valid GameMemberLogin gameMemberLogin,
				BindingResult bind , Model model , HttpSession session) {
			
			GameMember user = gameMemberService.login(gameMemberLogin);
			if(user == null) {
				bind.rejectValue("password","error.password","이메일 또는 비밀번호가 잘못 되었습니다.");
			}
			if(bind.hasErrors())
				return "game/member/login";
			
			// 로그인 성공시 로그인 화면 이전 방문 페이지 이동
			String preUri = (String)session.getAttribute("preUri");
			session.setAttribute("user", user);
			return "redirect:"+preUri;//"redirect:/game/index";
		}
}