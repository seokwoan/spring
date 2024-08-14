package com.movieAndGame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.Dto.GameMember;

@Mapper
public interface GameMemberDao {

	public int insert( GameMember gameMember );
}
