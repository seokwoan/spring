package com.movieAndGame.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieMember {

	@NotEmpty( message="이메일을 입력하세요" )
	private String email;
	
	@Size( min=4 ,  max=12 , message="비밀번호는 4 ~ 12자리로 입력하세요" )
	@Pattern( regexp="^[a-zA-Z0-9]*$" , message="영어 대소문자와 숫자만 입력하세요" )
	private String password;
	
	private String name;
	
	private int birthYear;
	
	private int birthMonth;
	
	@NotNull( message="연락처는 필수입니다" )
	private String tel;
	
}


/*
	Validation의 애노테이션
		- 데이터 유효성 검증
		
	@NotEmpty : null, 빈 문자열 불가
	
	@NotNull : null 불가 ( 빈 문자열, 공백 허용 ) 
	
	@Null : null만 허용
	 
	@NotBlank : null, 빈 문자열, 공백 불가
	
	@Min( value= ) : value 이하의 값만 허용
		@Min( value=10 , message="10이하만 입력하세요" )
		
	@Max( value= ) : value 이상의 값만 허용
		@Max( value=5 , mesaage="5이상만 입력하세요" )
	
	@Size( min= , max= ) : 길이를 제한 할때 사용 
		@Size( min=10 , max=20 , mesaage"10자 이상 20자 이하만 입력" )
		
	@Positive : 양수만 허용
	
	@PositiveOrZero : 양수와 0만 허용
	
	@Negative : 음수만 허용

	@NegativeOrZero : 음수와 0만 허용
	
	@Email : 이메일 형식검사, 빈문자열은 패스
	
	@Pattern( regexp= ) : 정규식 검사

*/