package com.cilazatta.workshopmongo.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContaining(String text);
	List<Post> findByDateAfter(Instant date);
	List<Post> findByDateBefore(Instant date);
}
