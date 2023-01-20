package com.cilazatta.workshopmongo.services;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.workshopmongo.domain.Post;
import com.cilazatta.workshopmongo.repository.PostRepository;

import com.cilazatta.workshopmongo.services.exception.ObjectDateTimeParseException;
import com.cilazatta.workshopmongo.services.exception.ObjectNotFoundException;
import com.cilazatta.workshopmongo.services.util.DecoderURL;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public PostService() {
		
	}
	
	@Autowired
	public PostService(PostRepository repo) {
		postRepo = repo;
	}

	public List<Post> findByAll(){
		return postRepo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = postRepo.findById(id);
		return post.orElseThrow(()-> new ObjectNotFoundException("Post não Encontrado"));
	}
	
	public List<Post> findByTitle(String text){ 
		text = DecoderURL.decodeParam(text);
		return postRepo.findByTitleContaining(text);
	}
	
	public List<Post> findByDateAfter(String txtdate){
		Instant date =null;
		try {
			 date = Instant.parse(txtdate);
		} 
		catch (DateTimeParseException e) {
			throw new ObjectDateTimeParseException("Data não Compativel");
		}
		catch (Exception e) {
			throw new ObjectDateTimeParseException(e.getMessage());
		}
		return postRepo.findByDateAfter(date);
	}
	
	public List<Post> findByDateBefore(String txtdate){
		Instant date = null;
		try {
			date = Instant.parse(txtdate);	
		} 
		catch(DateTimeParseException e) {
			throw new ObjectDateTimeParseException("Data não Compativel");
		} 
		catch (Exception e) {
			throw new ObjectDateTimeParseException(e.getMessage());
		}
		return postRepo.findByDateBefore(date);
	}
	
	
}
