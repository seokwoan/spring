package com.example.booktest.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	// book 테이블 전체 데이터 가져오기 - 첫화면에 목록으로 출력하기 위해
	public List<BookDTO> select(){
		String sql = "select * from book";
		
		List<BookDTO> list = jt.query( sql , new BookDTORowMapper() );
	
		return list;
	}
	
	public void insert( BookDTO bookDto ) { // 도서정보 데이터 베이스 저장
		String sql = "insert into book( book_title , book_author , book_cost , book_page , publisher ) "
				+ "values( ? , ? , ? , ? , ? )";
		
		jt.update( sql , bookDto.getBookTitle() , bookDto.getBookAuthor() , bookDto.getBookCost(), bookDto.getBookPage(), bookDto.getPublisher() );
		// update method를 이용해서 sql문의 value를 넣어준다
	}
	
	public class BookDTORowMapper implements RowMapper<BookDTO>{
		// jdbc template은 데이터베이스에서 가져온 데이터를 객체에 저장해주는 작업을 해줘야한다
		
		@Override
		public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookDTO bdt = new BookDTO();
			bdt.setBookAuthor( rs.getString( "book_author" ) );
			bdt.setBookCost( rs.getInt( "book_cost" ) );
			bdt.setBookPage( rs.getInt( "book_page" ) );
			bdt.setBookTitle( rs.getString( "book_title" ) );
			bdt.setPublisher( rs.getString( "publisher" ) );
			bdt.setBookId( rs.getInt( "book_id" ) );
			
			return bdt;
		}
		
	}
	
	
	// 도서 상세 정보 가져오기 - 1권에 대해서만 ( book_id 컬럼으로 조회)
	// book_id 컬럼이 중복데이터를 가질수 없는 유일값( primary key)이기 때문에
	
	
	public BookDTO findId( int id ) {
		
		String sql = "select * from book where book_id=?";
		
		
		// jt.queryForObject( sql문 , mapper , ?에 넣어줄 값 );
		BookDTO data= jt.queryForObject( sql , 
				new RowMapper<BookDTO>() {
					@Override
					public BookDTO mapRow( ResultSet rs , int rowNum ) throws SQLException{
						BookDTO dto = new BookDTO();
						dto.setBookAuthor( rs.getString( "book_author" ) );
						dto.setBookCost( rs.getInt( "book_cost" ) );
						dto.setBookPage( rs.getInt( "book_page" ) );
						dto.setBookTitle( rs.getString( "book_title" ) );
						dto.setPublisher( rs.getString( "publisher" ) );
						dto.setBookId( rs.getInt( "book_id" ) );
						
						return dto;
					}
				}
				
				, id );
		
		return data;
		
	}
	
	// 도서 삭제
	public void delete( int bid ) {
		String sql = "delete from book where book_id=?";
	
		jt.update( sql , bid );		
	}

	// 수정한 도서의 정보를 데이터베이스에 수정하여 저장
	public void update(BookDTO bookDto) {
		String sql = "update book set book_title=? , book_author=? , book_cost=? , book_page=? , publisher=? where book_id=?";
		
		jt.update( sql , bookDto.getBookTitle(), bookDto.getBookAuthor() , bookDto.getBookCost() , bookDto.getBookPage() , bookDto.getPublisher() , bookDto.getBookId() );
		
	}

}