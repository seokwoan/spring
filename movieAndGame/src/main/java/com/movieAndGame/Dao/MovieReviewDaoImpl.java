package com.movieAndGame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.Dto.MovieReviewDto;

@Mapper
public interface MovieReviewDaoImpl {
	public int reviewSave(MovieReviewDto movieReviewDto);
	
	public List<MovieReviewDto> findAll();

	public MovieReviewDto findById( int id );
}
