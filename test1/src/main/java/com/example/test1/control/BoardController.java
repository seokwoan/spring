package com.example.test1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.test1.DTO.BoardViewDTO;

@Controller
public class BoardController {

	@GetMapping( "/board" )
	public ModelAndView boardHOME() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName( "board/boardList" );
	
	return mav;
		
	}
	
	@GetMapping( "/boardWrite" )
	public String boardWrite() {
		return "board/write";
	}
	
	@PostMapping( "/boardWrite" )
	public ModelAndView boardView( @ModelAttribute BoardViewDTO bv ) {
		ModelAndView mv = new ModelAndView( "board/view" );
		
		mv.addObject( "data" , bv ); 
		// 객체에 데이터가 전부 들어있어 get method로 따로 넣어줄 필요가 없다
		
//		mv.addObject( "title" , bv.getTitle() );
//		mv.addObject( "writer" , bv.getWriter() );
//		mv.addObject( "content" , bv.getContent() );
//		mv.addObject( "password" , bv.getBoardPw() );
		
		return mv;
	}
	
}
