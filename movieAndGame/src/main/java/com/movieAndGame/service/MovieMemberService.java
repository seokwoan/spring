package com.movieAndGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.Dao.MovieMemberDao;
import com.movieAndGame.Dto.MovieMember;

@Service
public class MovieMemberService {
	
	@Autowired
	private MovieMemberDao movieMemberDao;
	
	// 회원가입 데이터베이스 저장
	public void signUpSave( MovieMember movieMember ) {
		movieMemberDao.insert( movieMember );
	}
	
}
