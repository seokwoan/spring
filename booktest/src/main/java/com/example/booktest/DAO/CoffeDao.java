package com.example.booktest.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.booktest.DTO.CoffeDto;

@Repository
public class CoffeDao {

	private final JdbcTemplate jt;
	
	@Autowired
	public CoffeDao( JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public void insert( CoffeDto cdt ) {
		String sql = "insert into coffe( item_name , price , decaffein ) values( ? , ? , ? )";
		
		jt.update( sql , cdt.getCoffe() , cdt.getPrice() , cdt.getDecaffein() );
	}
}
