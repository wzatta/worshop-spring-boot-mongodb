package com.cilazatta.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cilazatta.workshopmongo.domain.User;
import com.cilazatta.workshopmongo.repository.UserRepository;

@Configuration
public class Instantatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown mongo","maria@gmail.com");
		User alex = new User(null, "Alex Green mongo","alex@gmail.com");
		User bob = new User(null, "Bob Grey mongo","bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
