package com.movieAndGame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.Dto.GamePostDto;

@Mapper
public interface GamePostDaoImpl {

	public int save(GamePostDto gamePostDto);

}