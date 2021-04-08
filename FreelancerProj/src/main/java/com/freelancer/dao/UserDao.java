package com.freelancer.dao;

import java.util.List;

import com.freelancer.exception.UserNameTaken;
import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.User;

public interface UserDao {

	public User getUserByUsername(String username) throws UserNotFound;

	public void createUser(User user) throws UserNameTaken;

	public void removeUser(User user);

	public void updateUser(User user, String new_password);

	public List<User> getAllUsers();

}
