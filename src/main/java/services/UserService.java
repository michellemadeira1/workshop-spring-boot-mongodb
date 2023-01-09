package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import dto.UserDTO;
import repository.UserRepository;
import services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
 }
	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("objeto não encontrado");
		}
		return user;
	}
	
	public User insert(User obj) {
      return repo.insert(obj);
	}
	 
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update (User obj) {
		User newObj = repo.findOne(obj.getId());
		updateData (newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	public User fromDTO(UserDTO objDto) {
		return new User (objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}