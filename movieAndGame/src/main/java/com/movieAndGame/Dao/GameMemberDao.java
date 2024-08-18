package com.movieAndGame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.Dto.GameMember;
import com.movieAndGame.Dto.GameMemberLogin;

@Mapper
public interface GameMemberDao {

	public int insert( GameMember gameMember );
	public GameMember login(GameMemberLogin gameMemberLogin);// 로그인
}
