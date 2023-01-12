package resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import domain.Post;
import resources.util.URL;
import services.PostService;


@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Post>> findById(@PathVariable String id){
		Optional<Post> obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@GetMapping(value="titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam (value = "text", defaultValue="")String text){
		text= URL.decodeParam(text);
		List<Post>list = service.findByTitle(text);
		return ResponseEntity.ok().body(list); 
	}

}
