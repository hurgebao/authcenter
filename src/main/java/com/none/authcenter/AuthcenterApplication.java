package com.none.authcenter;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.none.authcenter.dao")
public class AuthcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthcenterApplication.class, args);
	}

}
