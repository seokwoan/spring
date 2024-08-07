package com.example.booktest.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookinfoDTO {

	private String title;
	private String author;
	private String publisher;
	
}

//뷰 페이지
//bookWrite.jsp ->	도서정보 입력 페이지
//		책 제목, 저자, 출판사 입력
//bookDetail.jsp ->	도서정보 출력 페이지
//		책 제목, 출판사 출력
//
//요청 주소 
///write - GET ->	(도서정보 입력 페이지 제공)
///detail - GET ->	(도서정보 출력 페이지 제공)
//
//동작 흐름
//사용자가 localhost/write라고 브라우저에 입력하고 페이지에서
//도서 정보를 입력 후 버튼을 클릭한다.
//다음에 제공되는 페이지에서 사용자가 입력한 값이 출력 되어야 한다
//
//
//
//bookDTO 클래스
//- title, author, publisher 변수 생성 , get.set
//
//bookWrite
//- form method:get, action:/detail
//- input name title, author, ppublicsher
//
//homeController
//- @GetMapping /write -> String return bookWrite
//- @GetMapping /detail
//	-> @ModelAttribute bookDto 
//	-> setViewName bookDetail
//	-> addObject bookDto
//	-> return mv
//
//bookdetail
//- ${  }으로 출력