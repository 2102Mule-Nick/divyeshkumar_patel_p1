package com.freelancer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freelancer.dao.UserDaoJDBCTemplate;
import com.freelancer.exception.InvalidPassword;
import com.freelancer.exception.UserNameTaken;
import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.User;

@Controller
public class UserController {

	private UserDaoJDBCTemplate userDaoJdbc;

	@Autowired
	public void setUserDaoJdbc(UserDaoJDBCTemplate userDaoJdbc) {
		this.userDaoJdbc = userDaoJdbc;
	}

	// Gets all the freelancers registered
	@GetMapping("/freelancer-users/")
	@ResponseBody
	public List<User> getUsers() {

		// need to create a service - will call the service after creation
		return userDaoJdbc.getAllUsers();
	}

	// Gets the freelancer details by the username
	@GetMapping("/freelancer-users/{username}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		try {
			return ResponseEntity.ok(userDaoJdbc.getUserByUsername(username));
		} catch (UserNotFound e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/test")
	@ResponseBody
	public String testController() {
		return "Testing the Controller";
	}

	// creates a new freelancer user account
	@PostMapping("/freelancer-users/new/")
	@ResponseBody
	public ResponseEntity<String> createUser(@RequestBody User user) {
		userDaoJdbc.createUser(user);
		return ResponseEntity.ok("User Entered");
	}

	@PutMapping("/freelancer-user/update/{new_pass}")
	@ResponseBody
	public ResponseEntity<String> updatePassword(@RequestBody User user,
			@PathVariable("new_pass") String new_password) {
		try {

			userDaoJdbc.updateUser(user, new_password);
			return ResponseEntity.ok("User Updated");

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/freelancer-user/delete")
	@ResponseBody
	public void deleteUser(@RequestBody User user) {
		userDaoJdbc.removeUser(user);
	}
}
