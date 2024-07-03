package dio.desafio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.desafio.model.User;
import dio.desafio.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> findAll() {
		return this.userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		return this.userService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		var userCreated = this.userService.create(user);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(userCreated.getId()).toUri()).body(userCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user){
		return ResponseEntity.ok(this.userService.update(id, user));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		this.userService.delete(id);
	}
}
