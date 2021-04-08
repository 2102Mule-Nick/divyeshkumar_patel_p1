package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.User;

@Component
public class UserExtractor implements ResultSetExtractor<User> {

	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		User newUser = new User();
		
		newUser.setUserId(rs.getInt("user_id"));
		newUser.setFirstName(rs.getString("firstname"));
		newUser.setLastName(rs.getString("lastname"));
		newUser.setUsername(rs.getString("username"));
		newUser.setEmail(rs.getString("email"));
		newUser.setPassword(rs.getString("pass"));
		newUser.setSkillId(rs.getInt("skills_id"));
		return newUser;
	}
 
	
}
