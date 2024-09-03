package com.movieAndGame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.Dto.GamePostDto;

@Mapper
public interface GamePostDaoImpl {

	public int save(GamePostDto gamePostDto);

	public List<GamePostDto> findAll();

	public GamePostDto findById(int id);

}