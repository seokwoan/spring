package com.movieAndGame.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.Dao.GamePostDaoImpl;
import com.movieAndGame.Dto.GamePostDto;

@Service
public class GamePostService {

	@Autowired
	private GamePostDaoImpl gamePostDaoImpl;
	
	public void write(@Valid GamePostDto gamePostDto) {
		gamePostDaoImpl.save(gamePostDto);
		
	}

}