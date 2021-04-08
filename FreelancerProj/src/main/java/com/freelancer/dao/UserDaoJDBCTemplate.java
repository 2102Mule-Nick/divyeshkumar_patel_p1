package com.freelancer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.freelancer.dao.mapper.UserRowMapper;
import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.User;

@Repository
public class UserDaoJDBCTemplate implements UserDao {

	private JdbcTemplate jdbcTemplate;

	private UserRowMapper userRowMapper;

	@Autowired
	public void setUserRowMapper(UserRowMapper userRowMapper) {
		this.userRowMapper = userRowMapper;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {
		
		String sql ="select * from freelancer_user where username=?";
		List<User> userList = jdbcTemplate.query(sql, userRowMapper,username);
		if(userList.size()==0) {
			throw new UserNotFound();
			
		}
		return userList.get(0);
	}

	@Override
	public void createUser(User user) {
		String sql = "insert into freelancer_user(firstname,lastname,username,email,pass,skills_id) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),
				user.getPassword(),user.getSkillId());

	}

	@Override
	public void removeUser(User user) {
		String sql = "delete from freelancer_user where username = ? and pass = ?";
		if (jdbcTemplate.update(sql, user.getUsername(), user.getPassword()) == 0) {
			System.out.println("User deleted successfully");
		}

	}

	@Override
	public void updateUser(User user, String new_password) {
		String sql = "update freelancer_user set pass =? where username =? and pass=?";
		jdbcTemplate.update(sql, new_password, user.getUsername(), user.getPassword());

	}

	@Override
	public List<User> getAllUsers() {
		String sql = "select * from freelancer_user";
		List<User> allUsersList = jdbcTemplate.query(sql, userRowMapper);
		
		return allUsersList;
	}

	

}
