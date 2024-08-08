package com.example.booktest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booktest.DAO.BookDAO;
import com.example.booktest.DTO.BookDTO;

@Service // Service 애노테이션을 해주면 Bean으로 등록된다.
public class BookService {
	
	private final BookDAO bookDao;
	
	@Autowired
	public BookService( BookDAO bookDao ) {
		this.bookDao = bookDao;
	}
	
	// 도서 정보 
	public void bookSave( BookDTO bookDto ) {
		if( bookDto != null ) {
			// 도서 코드가 이미 데이터베이스에 저장 되어 있는지 확인 후 저장
			bookDao.insert( bookDto ); // DAO 클래스의 insert method 실행해서 저장
		}
	}

}
