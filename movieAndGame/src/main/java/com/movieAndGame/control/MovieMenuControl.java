package com.movieAndGame.control;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.Dto.MovieMember;
import com.movieAndGame.Dto.MovieReviewDto;
import com.movieAndGame.service.MovieReviewService;

@Controller
@RequestMapping("/movieMenu")
public class MovieMenuControl {

	@Autowired
	private MovieReviewService reviewService;
	
	// 글 내용작성후 저장 요청
	@GetMapping("/write")
	public String reviewWrite(@Valid MovieReviewDto movieReviewDto,
			BindingResult bind, Model model) {
		
		if(bind.hasErrors()) { // form데잍 값이 유효하지않다면
			return "movie/review/write";
		}
		reviewService.save(movieReviewDto);
		return "redirect:/movieMenu/review";
	}
	
	// 리뷰 첫페이지( 리뷰 목록 )
	@GetMapping("/review")
	public String reviewMain(Model model) {
		
		List<MovieReviewDto> list = reviewService.reviewList();
		model.addAttribute( "reviewList" , list );
		
		return "movie/review/index";
	}
	
	// 리뷰작성페이지 요청
	@GetMapping("/reviewWrite")
	public String write(Model model, HttpSession session) {
		
		if(session.getAttribute("user") ==null) {// 로그인 상태가 아니면 로그인페이지이동
			return "redirect:/movie/login";
		}
		
		MovieReviewDto dto = new MovieReviewDto();		
		String name = ((MovieMember)session.getAttribute("user")).getName();
		dto.setWriter(name);
		
		model.addAttribute("movieReviewDto",dto);
		
		return "movie/review/write";
	}
	
	@GetMapping( "/view/{id}" ) 
	// @PathVariable을 통해 주소의 {id}의 값을 가져온다 주소의{?}값과 @pathvariable의 변수명과 같아야한다
	// @PathVariable은 하나의 값만 받을 수 있다
	public String view( @PathVariable int id, Model model ) {
		
		MovieReviewDto dto = reviewService.finfById( id );
		model.addAttribute( "movieReviewDto" , dto );
		
		return "movie/review/detail";
	}
	
}
