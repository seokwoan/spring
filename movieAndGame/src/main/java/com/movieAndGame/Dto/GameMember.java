package com.movieAndGame.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameMember {
	
	@Email( message="이메일을 확인하세요" )
	private String email;
	
	@Size( min=5 , max=13 , message="비밀번호는 5~13자리로 입력하세요" )
	@Pattern( regexp="^[a-zA-Z0-9]*$" , message="비밀번호는 영어 대소문자와 숫자만 입력하세요" )
	private String password;
	
	@Pattern( regexp="^[a-z]*$" , message="닉네임은 영어 소문자만 입력하세요" )
	private String nickName;

}


//마이바티스
//
//application.properties에서 연결할 데이터베이스 및 mybatis경로 설정 
//	-> 설정한 경로에 xml파일 생성
//
//interface 생성
//	-> @Mapper애노테이션, 추상메소드 생성 매개변수는 저장할 데이터의 class
//
//mybatis mapper 폴더 생성 resource폴더의 하위에 위치
//	->  mapper폴더에 xml파일 생성 
//	-> 	xml파일 내용
//		<?xml version="1.0" encoding="UTF-8" ?>
//		<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
//		<mapper namespace="interface경로">
//			<insert id="interface함수명" parameterType="매개변수 타입 class 경로" >
//				<sql문>				
//			</insert>
//		</mapper>
//
//Service 생성 
//	-> @Autowired로 interface객체 생성, interface의 추상메소드를 실행하는 method 생성
//
//Controller -> @Autowired로 Service객체 생성, Service의 method를 실행하는 method 생성