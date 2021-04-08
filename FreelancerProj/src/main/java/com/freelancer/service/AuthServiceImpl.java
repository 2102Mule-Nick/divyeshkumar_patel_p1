package com.freelancer.service;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.freelancer.dao.UserDao;
import com.freelancer.exception.InvalidPassword;
import com.freelancer.exception.UserNameTaken;
import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.User;

public class AuthServiceImpl implements AuthService {

	Logger log = Logger.getRootLogger();

	private UserDao userDao;
	
	private User currentUser;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean existingUser(User user) {
		log.trace("AuthServiceImpl.existingUser");
		try {
			if(userDao.getUserByUsername(user.getUsername())!=null) {
				log.info("User info returned!!");
				return true;
			}
		}catch(UserNotFound e) {
			return false;
		}
		return false;
	}

	@Override
	public User authenticateUser(User user) throws InvalidPassword, UserNotFound {
		User existingUser = userDao.getUserByUsername(user.getUsername());
		
		if(existingUser.getPassword().equals(user.getPassword())) {
			this.currentUser =existingUser;
			return existingUser;
		}
			
		throw new InvalidPassword();
	}

	@Override
	public User registerUser(User user) throws UserNameTaken {
		log.trace("Service to create new user called");
		userDao.createUser(user);
		return user;
	}

	@Override
	public User updateUser(User user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
