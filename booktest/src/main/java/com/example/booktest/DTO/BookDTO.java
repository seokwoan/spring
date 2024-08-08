package com.example.booktest.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

	// DTO는 사용자가 이용하는 데이터를 처리하기 위한 클래스
	private int bookId; // 데이터베이스에서 데이터를 가져올때 book_id를 받아줄 변수가 없어 에러가 뜸
	private String bookTitle; // 책 제목
	private String bookAuthor; // 저자
	private int bookCost; // 가격
	private int bookPage; // 페이지 수
	private String publisher; // 출판사
	
}
