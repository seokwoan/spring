package com.example.booktest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booktest.DAO.CoffeDao;
import com.example.booktest.DTO.BookDTO;
import com.example.booktest.DTO.CoffeDto;

@Service
public class CoffeService {
	
	private final CoffeDao cda;
	
	@Autowired
	public CoffeService( CoffeDao cda ) {
		this.cda = cda;
	}
	
	public void save( CoffeDto cdt ) {
		if( cdt != null ) {
			cda.insert( cdt );
		}	
	}
	
	public List<CoffeDto> selcetAll(){
		return cda.select();
		
	}
	
	public CoffeDto menuView( int id ) {
		if( id != 0 ) {
			return cda.menuView( id );
		}
		return null;
	}
	
	public void menuDel( int menu ) {
		cda.menuDel( menu );
	}
	

	public void update( CoffeDto coffeDto ) {
		cda.update( coffeDto );
		
	}	
}
