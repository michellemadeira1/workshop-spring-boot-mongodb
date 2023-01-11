package services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import domain.Post;
import repository.PostRepository;
import services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("objeto não encontrado");
		}
		return user;
	}
	
}