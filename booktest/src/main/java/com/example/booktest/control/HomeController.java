package com.example.booktest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.booktest.DTO.InfoDTO;
import com.example.booktest.DTO.bookDTO;

@Controller
public class HomeController {
	
	// 요청 주소와 메서드를 매핑(연결) 시켜준다.
	@GetMapping( "/home" )
	public String homeView() { // 뷰 페이지만 제공하는 경우 페이지이름만 넘긴다
		return "home";
	}
	
	@GetMapping( "/infoInput" )
	public ModelAndView info( @ModelAttribute InfoDTO info ) {
		// ModelAndView는 사용자에게 제공할 페이지와 데이터를 저장할수 있는 클래스다
		// 사용자에게 제공할 페이지는 객체 생성시 입력하거나 setViewName method를 통해 입력
		ModelAndView mv = new ModelAndView( "info" );
		// mv.setViewName( "info" ); method를 통해 입력
		
		int age = 2024 - Integer.parseInt( ( info.getUBirth().substring( 0 , 4 ) ) ) ;
		
		mv.addObject( "ageData" , age ); // view 페이지에 전달할 데이터 설정
		
		return mv;
		
	}


	@GetMapping( "/write" )
	public String book() {
		return "bookWrite";
	}
	
	@GetMapping( "/detail" )
	public ModelAndView book( @ModelAttribute bookDTO bookDto ) {
		ModelAndView book = new ModelAndView( "bookDetail" );
		
		book.addObject( "book" , bookDto );
		
		return book;
	}
	
}