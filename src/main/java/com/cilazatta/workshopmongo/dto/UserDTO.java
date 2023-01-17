package com.cilazatta.workshopmongo.dto;

import java.io.Serializable;

import com.cilazatta.workshopmongo.domain.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String _id;
	private String name;
	private String email;
	
	public UserDTO() {
	}

	public UserDTO(User obj) {
		_id = obj.get_id();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.get_id(),objDto.getName(),objDto.getEmail());
	}
	
}
