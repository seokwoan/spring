package com.movieAndGame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.Dto.MovieMember;

@Mapper
public interface MovieMemberDao { // 마이바티스를 이용해 데이터베이스에 접근할때는 클래스가 아닌 인터페이스를 사용
								  // 마이바티스를 사용할 인터페이스는 @Mapper 애노테이션을 넣어준다

	public int insert( MovieMember movieMember ); // 회원가입을 위한 데이터 저장
}
