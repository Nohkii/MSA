package com.example.springedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication//(exclude=DataSourceAutoConfiguration.class)
@ComponentScan(basePackages={"com.example.springedu","thymeleaf.exam", "springws.exam"})
@MapperScan(value={"com.example.springedu.dao"})
@EnableScheduling
public class SpringeduApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringeduApplication.class, args);
	}

}
