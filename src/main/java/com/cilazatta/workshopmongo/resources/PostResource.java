package com.cilazatta.workshopmongo.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.workshopmongo.domain.Post;
import com.cilazatta.workshopmongo.dto.PostDTO;
import com.cilazatta.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

		@Autowired
		private PostService service;

		@GetMapping
		public ResponseEntity<List<PostDTO>> findAll(){
			List<Post> list = service.findByAll();
			List<PostDTO>listDto = list.stream()
					.map(w-> new PostDTO(w)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}
		
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Post> findById(@PathVariable String id){
			Post post = service.findById(id);
			return ResponseEntity.ok().body(post);
		}
		
		@GetMapping(value = "/titlesearch")
		public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue = "") String text){
			//text = DecoderURL.decodeParam(text);
			List<Post> posts = service.findByTitle(text);
			return ResponseEntity.ok().body(posts);
		}
		
		@GetMapping(value = "/dateafter")
		public ResponseEntity<List<Post>> findByDateAfter(@RequestParam(value = "date",defaultValue = "") String date){
			List<Post> posts = service.findByDateAfter(date);
			return ResponseEntity.ok().body(posts);
		}

		@GetMapping(value = "/datebefore")
		public ResponseEntity<List<Post>> findByDateBefore(@RequestParam(value = "date",defaultValue = "") String date){
			List<Post> posts = service.findByDateBefore(date);
			return ResponseEntity.ok().body(posts);
		}
		
		
}
