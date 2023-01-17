package com.cilazatta.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void deleteById(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public UserDTO update(UserDTO objDto) {
		UserDTO userDto = new UserDTO();
		User obj = userDto.fromDTO(objDto);

		Optional<User> newObj = repo.findById(obj.get_id());
		User newUser = newObj.orElseThrow(()->new ObjectNotFoundException("Objeto não Encontrado"));
		updateData(newUser, obj);
		repo.save(newUser);
		return new UserDTO(newUser);
	}

	private void updateData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
	}
	
}
