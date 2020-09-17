package com.yc.C81lkblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.C81lkblog.dao")
public class C81LkblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(C81LkblogApplication.class, args);
	}

}
