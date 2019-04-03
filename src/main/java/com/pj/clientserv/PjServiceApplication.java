package com.pj.clientserv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.pj.clientserv.mapper"})
@SpringBootApplication
public class PjServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjServiceApplication.class, args);
	}

}
