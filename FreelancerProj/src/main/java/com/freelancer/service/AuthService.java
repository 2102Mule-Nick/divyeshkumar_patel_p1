package com.freelancer.service;

import com.freelancer.exception.InvalidPassword;
import com.freelancer.exception.UserNameTaken;
import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.User;

public interface AuthService {
	
	public boolean existingUser(User user);
	
	public User authenticateUser(User user) throws InvalidPassword, UserNotFound;
	
	public User registerUser(User user) throws UserNameTaken;
	
	public User updateUser(User user, String password);
	
	public boolean removeUser(User user);
	
	public User getCurrentUser();

}
