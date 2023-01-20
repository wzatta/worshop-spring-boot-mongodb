package com.cilazatta.workshopmongo.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cilazatta.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContaining(String text);
	List<Post> findByDateAfter(Instant date);
	List<Post> findByDateBefore(Instant date);
	
	@Query("{'title': { $regex: ?0, $options: 'i'}}" )
	List<Post> searchTitle(String text);
}
