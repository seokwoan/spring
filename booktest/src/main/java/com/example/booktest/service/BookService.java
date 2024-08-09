package com.example.booktest.service;

import java.util.List;

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
	
	
	// 도서정보 데이터베이스에서 가져온 데이터가 저장된 List를 control에 넘겨주기 
	public List<BookDTO> selcetAll(){
		return bookDao.select();
		
	}

	// 도서 정보 저장
	public void bookSave( BookDTO bookDto ) {
		if( bookDto != null ) {
			// 도서 코드가 이미 데이터베이스에 저장 되어 있는지 확인 후 저장
			bookDao.insert( bookDto ); // DAO 클래스의 insert method 실행해서 저장
		}
	}

	// 도서 상세 정보 가져오기 - id 파라미터값을 DAO에 넘겨서 조회하고 싶은 결과를 받아 control에 넘김
	public BookDTO getBook( int id ) {
		if( id != 0 ) { // id 파라미터값이 존재한다면 DAO를 통해 조회
			return bookDao.findId( id );
		}
		return null; // id 파라미터값 없이 주소요청이 들어온다면 null값을 반환 -> 조회 불가
	}
	
	
	
	
	
	
	
	
	

}





















