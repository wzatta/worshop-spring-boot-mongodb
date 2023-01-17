package com.cilazatta.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cilazatta.workshopmongo.domain.User;
import com.cilazatta.workshopmongo.dto.UserDTO;
import com.cilazatta.workshopmongo.repository.UserRepository;
import com.cilazatta.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não Encontrado"));
		
	}
	
	public UserDTO insert(UserDTO objDto) {
		UserDTO userDto = new UserDTO();
		User use = userDto.fromDTO(objDto);
		use = repo.insert(use);
		
		return new UserDTO(use);
	}
}
