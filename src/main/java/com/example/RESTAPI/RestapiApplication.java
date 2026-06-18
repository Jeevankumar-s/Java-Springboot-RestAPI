package com.example.RESTAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.example.UserManagement") used to scan for beans in neighbor folder 
@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
