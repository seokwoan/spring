package com.example.booktest.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.booktest.DTO.BookDTO;
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
	
	
	
	public List<CoffeDto> select(){
		String sql = "select * from coffe";
		
		List<CoffeDto> list = jt.query( sql , new CoffeDtoRowMapper() );
	
		return list;
	}
	
	
	
	public class CoffeDtoRowMapper implements RowMapper<CoffeDto>{
		
		@Override
		public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeDto cdt = new CoffeDto();
			cdt.setCoffe( rs.getString( "item_name" ) );
			cdt.setCoffeId( rs.getInt( "coffe_id" ) );
			cdt.setPrice( rs.getInt( "price" ) );
			cdt.setDecaffein( rs.getInt( "decaffein" ) );

			return cdt;
		}
		
	}
	
	
	public CoffeDto menuView( int id ) {
		
		String sql = "select * from coffe where coffe_id=?";
		
		CoffeDto cdt = jt.queryForObject( sql , 
				new RowMapper<CoffeDto>() {
					@Override
					public CoffeDto mapRow( ResultSet rs , int rowNum ) throws SQLException{
						CoffeDto coffeDto = new CoffeDto();
						coffeDto.setCoffeId( rs.getInt( "coffe_id") );
						coffeDto.setCoffe( rs.getString("item_name" ) );
						coffeDto.setPrice( rs.getInt( "price") );
						coffeDto.setDecaffein( rs.getInt( "decaffein" ) );
						
						return coffeDto;
					}
			
				}
				, id );
		return cdt;
		
	}
	
	public void menuDel( int id ) {
		String sql = "delete from coffe where coffe_id=?";
		
		jt.update( sql , id );
		
	}

}