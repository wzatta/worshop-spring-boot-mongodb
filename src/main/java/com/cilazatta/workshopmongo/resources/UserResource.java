package com.cilazatta.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.workshopmongo.domain.User;
import com.cilazatta.workshopmongo.dto.UserDTO;
import com.cilazatta.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(w->new UserDTO(w)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		UserDTO userDto = new UserDTO(user);
		return ResponseEntity.ok().body(userDto);
	}
	

}
