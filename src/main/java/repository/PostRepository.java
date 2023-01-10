package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Post;


public interface PostRepository  extends MongoRepository<Post, String>{
	Post findOne(String id);
}
