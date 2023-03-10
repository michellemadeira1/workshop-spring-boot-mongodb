package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{
	
	@Query("{'title': {$regex: ?0 , $option: 'i'}}")
	List<Post>searchTitle(String text);
	
	List<Post>findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ {field: {$gte: ?1} },{field: { $lte: ?2} }, { } ]  } , {$or: [{'title': {$regex: ?0 , $option: 'i'} },{'body': {$regex: ?0 , $option: 'i'} },{'comments.text': {$regex: ?0 , $option: 'i'} } ] }")
	
	List<Post> fullSearch(String text , Date minDate, Date maxDate);
}
