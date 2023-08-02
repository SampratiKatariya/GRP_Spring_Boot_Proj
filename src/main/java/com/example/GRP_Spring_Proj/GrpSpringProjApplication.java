package com.example.GRP_Spring_Proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class GrpSpringProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpSpringProjApplication.class, args);
		System.out.println("Hello world!");
	}

}
