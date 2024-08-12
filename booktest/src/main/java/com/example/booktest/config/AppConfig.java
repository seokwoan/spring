package com.example.booktest.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration // 스프링에서 bean을 등록하는 클래스는 애노테이션이 필요하다
public class AppConfig {

	// jdbc 템플릿을 통한 데이터 베이스 접속
	@Bean
	public DataSource dateSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName( "com.mysql.cj.jdbc.Driver");
		ds.setUsername( "swgg" );
		ds.setPassword( "123456" );
		ds.setUrl( "jdbc:mysql://localhost:3306/swgg" );
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate( DataSource dataSource ) {
		return new JdbcTemplate( dataSource );
	}
	
}