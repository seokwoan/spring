package com.example.booktest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.booktest.DTO.BookDTO;
import com.example.booktest.service.BookService;

@Controller // @Controller 애노테이션이 있어야만 Mapping가능
public class BookController {
	
	@Autowired
	private BookService bookService;
	

	@GetMapping( "/" )
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView( "index" );
		
		List<BookDTO> list = bookService.selcetAll();
		mv.addObject( "list" , list );
		
		return mv;
		
	}
	
	
	@GetMapping( "/bookWrite" )
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView( "book/bookForm" );
		mv.addObject( "count" , 5 );
		return mv;
	}
	
	@PostMapping( "/enroll" )
	public String write( @ModelAttribute BookDTO bookDto ) {
		// form태그 안에 입력한 값은 BookDTO class의 객체에 저장되어있다.
		// 데이터 베이스에 저장하려면 BookDTO객체를 DAO에 넘겨서 저장하면된다.
		// control -> service -> DAO의 순서로 데이터를 넘겨서 데이터베이스에 저장한다
		
		bookService.bookSave( bookDto );
		
		return "index";
	}
	
	
}
