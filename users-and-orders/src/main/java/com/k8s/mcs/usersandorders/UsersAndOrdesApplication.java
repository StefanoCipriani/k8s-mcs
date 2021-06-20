package com.k8s.mcs.usersandorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsersAndOrdesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersAndOrdesApplication.class, args);
	}

}
