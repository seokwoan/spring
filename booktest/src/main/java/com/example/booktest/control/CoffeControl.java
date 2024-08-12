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
import com.example.booktest.DTO.CoffeDto;
import com.example.booktest.service.CoffeService;

@Controller
public class CoffeControl {

	@Autowired
	private CoffeService csv;
	
	@GetMapping( "/coffe" )
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView( "/coffe/index" );
		
		List<CoffeDto> list = csv.selcetAll();
		mv.addObject( "list" , list );
		
		return mv;
	}
	
	
	
	
	@GetMapping( "/coffeReg" )
	public String coffe() {
		return "coffe/coffeInput";
	}
	
	@PostMapping( "/coffeEnroll" )
	public String coffe( @ModelAttribute CoffeDto cdt ) {
		
		csv.save( cdt );
		
		return "redirect:/coffe"; 
		// sendRedirect를 실행하는 문자열 "redirect:/(주소)"
		// 등록 후에 Mapping된 주소가 유지되는 forward방식이 아닌 이동한 페이지의 주소가 나오는 redirect방식 
	}
	
	
	@GetMapping( "/coffe/view" )
	public ModelAndView view( @RequestParam( value="menu" , required=false , defaultValue="0" ) int id ) {
		
		CoffeDto cdt = csv.menuView( id );
		if( cdt == null ) {
			cdt = new CoffeDto();
		}
		
		return new ModelAndView( "coffe/view" ).addObject( "menu" , cdt );
	}
	
	@GetMapping( "/coffe/delete" )
	public String menuDel( @RequestParam( "menu" ) int menu ) {
		csv.menuDel( menu );
		
		return "redirect:/coffe"; 
	}
	
	@GetMapping( "/coffe/update" )
	public String coffeUpdate( @ModelAttribute CoffeDto coffeDto , @RequestParam( "menu" ) int menu ) {
		coffeDto.setCoffeId( menu );
		csv.update( coffeDto );
		
		return "redirect:/coffe/view?menu=" + menu;
	}
	
	
}

//@Controller 애노테이션을 붙여줘야 class가 controller의 역할을 함
//@Service 애노테이션을 붙여줘야 class가 service의 역할을 함
//@Repository 애노테이션을 붙여줘야 class가 데이터베이스와 관련된 스프링프레임워크를 사용할 수 있다






