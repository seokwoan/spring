package com.movieAndGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.Dao.MovieReviewDaoImpl;
import com.movieAndGame.Dto.MovieReviewDto;

@Service
public class MovieReviewService {
	
	@Autowired
	private MovieReviewDaoImpl movieReviewDao;
	
	public void save(MovieReviewDto movieReviewDto) {
		movieReviewDao.reviewSave(movieReviewDto);
	}
	
	// movie_review 테이블에서 데이터 가져와 컨트롤에 전달
	public List<MovieReviewDto> reviewList(){
		return movieReviewDao.findAll();
	}

	public MovieReviewDto finfById(int id) {
		return movieReviewDao.findById( id );
	}
}