package com.example.booktest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping( "/book/view" )
	public ModelAndView view( @RequestParam( value="id" , required=false , defaultValue="0" ) int id ) {
		// @RequestParam( value="id" , required=false , defaultValue="0" )
		//                파라미터의 이름 , 필수요소인가 없으면 true( false - 없어도 가능하다) , defaultValue 파라미터가 없을때 기본값을 넣어줌
		
		BookDTO data = bookService.getBook( id );
		if( data == null ) {
			data = new BookDTO(); 
			// getBook 메서드에서 반환값이 null 저정된다면 view.jsp에서 변수의 값이 null이기 때문에
			// get method 호출이 안되어 오류가 발생한다.
			// 오류가 발생되지 않게 하기 위하여 빈 값이 있는 객체를 만들어줌
		}
		
		return new ModelAndView( "book/view" ).addObject( "book" , data );
	}
	
	// 도서 삭제
	@GetMapping( "/book/delete" )
	public String bookRemove( @RequestParam( "id" ) int bid ) {
		bookService.remove( bid );
		return "redirect:/"; // redirect는 주소가 바뀜
//		return "<script> alert('삭제되었습니다'); location.href='/'; <script>";
	}
	
	
	// 도서 수정
	@GetMapping( "/book/update" )
	public String bookUpdate( @ModelAttribute BookDTO bookDto , @RequestParam( "id" ) int id ) {
		bookDto.setBookId( id );
		bookService.update( bookDto );
		
		return "redirect:/book/view?id=" + id; // 도서 상세페이지 이동
	}

}