package com.example.authenticationmicroservice;

import com.example.authenticationmicroservice.Entity.Role;
import com.example.authenticationmicroservice.Entity.User;
import com.example.authenticationmicroservice.Service.RoleService;
import com.example.authenticationmicroservice.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AuthenticationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationMicroserviceApplication.class, args);
	}


	@Bean
	CommandLineRunner run(RoleService roleService , UserService userService){
		return args -> {
			// init roles list
			roleService.saveRole(new Role( null,"ADMIN"));
			roleService.saveRole(new Role( null,"USER"));

			// init users list
			userService.saveUser(new User(null ,"fakhri@gmail.com","fakhri123","fakhri" , new  ArrayList<>())) ;
			userService.saveUser(new User(null ,"jhon@gmail.com","jhon123","Jhon" , new  ArrayList<>())) ;
			userService.saveUser(new User(null ,"sarah@gmail.com","sarah123","sarah" , new  ArrayList<>())) ;


			//init role / users
			userService.addRoleToUser("fakhri" , "ADMIN" );
			userService.addRoleToUser("sarah" , "USER" );
			userService.addRoleToUser("Jhon" , "USER" );
		} ;
	}




}
