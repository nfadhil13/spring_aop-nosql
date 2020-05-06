package com.spring_disc.disc.disc;

import com.spring_disc.disc.disc.controller.UserController;
import com.spring_disc.disc.disc.model.User;
import com.spring_disc.disc.disc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscApplication.class, args);

	}

}
