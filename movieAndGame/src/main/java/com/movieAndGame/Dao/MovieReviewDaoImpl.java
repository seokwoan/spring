package com.movieAndGame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.Dto.MovieReviewDto;

@Mapper
public interface MovieReviewDaoImpl {
	public int reviewSave(MovieReviewDto movieReviewDto);
}
