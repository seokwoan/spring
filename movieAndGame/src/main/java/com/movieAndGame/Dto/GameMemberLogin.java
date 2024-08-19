package com.movieAndGame.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameMemberLogin {
	@NotBlank(message="이메일은 필수입니다.")
	private String email;
	
	@Size(min=6, max=12, message="비밀번호는 6~12자리입니다.")
	@Pattern(regexp="^[a-z0-9]*$", message="영어소문자와 숫자만 가능합니다.")
	private String password;

}