package com.example.booktest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.booktest.DTO.CoffeDto;
import com.example.booktest.service.CoffeService;

public class CoffeControl {

	@Autowired
	private CoffeService csv;
	
	@GetMapping("/coffeReg")
	public String coffe() {
		return "index";
	}
	
	@PostMapping( "/coffeEnroll" )
	public String coffe( @ModelAttribute CoffeDto cdt ) {
		
		csv.save( cdt );
		
		return "index";	
	}
}








