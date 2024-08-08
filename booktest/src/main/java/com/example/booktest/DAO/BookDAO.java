package com.example.booktest.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.booktest.DTO.BookDTO;

@Repository  // 스프링에서 데이터 베이스를 다루는 class에 애노테이션을 해줘야 한다 애노테이션을 붙여야 스프링프레임워크를 사용할 수 있다
			 // Repository 애노테이션을 하면 Bean으로 등록된다.
public class BookDAO {
	
	// 의존성 주입 -> B클래스를 사용할때 A클래스 객체를 만들어서 사용 -> B클래스가 A클래스에 의존 
	
	// jdbc템플릿
	
	private final JdbcTemplate jt;
	
	@Autowired // bean에 있는 값을 가져오기 위해 필요하다
	public BookDAO( JdbcTemplate jdbcTemplate ) {
		this.jt = jdbcTemplate;
	}
	
	public void insert( BookDTO bookDto ) { // 도서정보 데이터 베이스 저장
		String sql = "insert into book( book_title , book_author , book_cost , book_page , publisher ) "
				+ "values( ? , ? , ? , ? , ? )";
		
		jt.update( sql , bookDto.getBookTitle() , bookDto.getBookAuthor() , bookDto.getBookCost(), bookDto.getBookPage(), bookDto.getPublisher() );
		// update method를 이용해서 sql문의 value를 넣어준다
	}
}