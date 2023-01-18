package com.cilazatta.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cilazatta.workshopmongo.domain.Post;
import com.cilazatta.workshopmongo.domain.User;
import com.cilazatta.workshopmongo.dto.AuthorDTO;
import com.cilazatta.workshopmongo.repository.PostRepository;
import com.cilazatta.workshopmongo.repository.UserRepository;

@Configuration
public class Instantatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown mongo","maria@gmail.com");
		User alex = new User(null, "Alex Green mongo","alex@gmail.com");
		User bob = new User(null, "Bob Grey mongo","bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Instant.now(),"Partiu viagem","Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.now(),"Bom Dia", "Acordei feliz hoje!",new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
