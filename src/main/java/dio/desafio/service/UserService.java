package dio.desafio.service;

import java.util.List;
import dio.desafio.model.User;

public interface UserService {
	public List<User> findAll();
	public User findById(Long id);
	public User create(User user);
	public User update(Long id, User user);
	public void delete(Long id);
}
