package com.cilazatta.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.workshopmongo.domain.Post;
import com.cilazatta.workshopmongo.repository.PostRepository;
import com.cilazatta.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;

	public Post findById(String id) {
		Optional<Post> post = postRepo.findById(id);
		return post.orElseThrow(()-> new ObjectNotFoundException("Post não Encontrado"));
	}
}
