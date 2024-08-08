package com.example.booktest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booktest.DAO.CoffeDao;
import com.example.booktest.DTO.CoffeDto;

@Service
public class CoffeService {
	
	private final CoffeDao cda;
	
	@Autowired
	public CoffeService( CoffeDao cda ) {
		this.cda = cda;
	}
	
	public void save( CoffeDto cdt ) {
		cda.insert( cdt );
	}

}
