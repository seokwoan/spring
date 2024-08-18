package com.movieAndGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.Dao.GameMemberDao;
import com.movieAndGame.Dto.GameMember;
import com.movieAndGame.Dto.GameMemberLogin;

@Service
public class GameMemberService {

	@Autowired
	private GameMemberDao gameMemberDao;
	
	public void signUpSave( GameMember gameMember ) {
		gameMemberDao.insert( gameMember );
	}
	
	//로그인
	public GameMember login(GameMemberLogin gameMemberLogin) {
		return gameMemberDao.login(gameMemberLogin);
	}
}
