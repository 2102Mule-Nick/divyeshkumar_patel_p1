package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.User;

@Component
public class UserRowMapper implements RowMapper<User> {

	private UserExtractor userExtactor;

	@Autowired
	public void setUserExtactor(UserExtractor userExtactor) {
		this.userExtactor = userExtactor;
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		return userExtactor.extractData(rs);
	}

}
