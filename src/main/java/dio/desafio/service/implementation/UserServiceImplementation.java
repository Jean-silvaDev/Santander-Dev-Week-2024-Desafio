package dio.desafio.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import dio.desafio.model.User;
import dio.desafio.model.repository.UserRepository;
import dio.desafio.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public User create(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User update(Long id, User user) {
		var userUpdate = this.userRepository.findById(id).get();
		mapping(user, userUpdate);
		return this.userRepository.save(userUpdate);
	}
	
	public void mapping(User user1, User user2) {
		user2.setName(user1.getName());
		user2.setBorn(user1.getBorn());
	}

	@Override
	public void delete(Long id) {
		this.userRepository.deleteById(id);
	}

}
