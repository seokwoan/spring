package com.example.test1.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// @Ddata -> DTO에 필요한 함수를 만들어줌 get,set,tostring, equals 등등
@Setter
@Getter
@ToString
public class MemberDTO {

	private String id;
	private String pw;
	private String tel;
	private String birth;
	
}
