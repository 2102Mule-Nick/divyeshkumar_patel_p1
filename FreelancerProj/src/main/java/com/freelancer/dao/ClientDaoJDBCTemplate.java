package com.freelancer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.freelancer.dao.mapper.ClientRowMapper;
import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.Client;
import com.freelancer.pojo.User;

@Repository
public class ClientDaoJDBCTemplate implements ClientDao {

	private JdbcTemplate jdbcTemplate;
	
	private ClientRowMapper clientRowMapper;
	
	
	@Autowired
	public void setClientRowMapper(ClientRowMapper clientRowMapper) {
		this.clientRowMapper = clientRowMapper;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Client getClientByUsername(String username) throws UserNotFound {

		String sql ="select * from freelancer_client where username=?";
		List<Client> clientList = jdbcTemplate.query(sql, clientRowMapper,username);
		if(clientList.size()==0) {
			throw new UserNotFound();
			
		}
		return clientList.get(0);
		
	}

	@Override
	public void createClient(Client client) {
	String sql = "insert into freelancer_client(firstname,lastname,company,username,email,pass) values (?,?,?,?,?)";
	jdbcTemplate.update(sql, client.getFirstName(), client.getLastName(),client.getCompany(), client.getUsername(), client.getEmail(),
			client.getPassword());
	}

	@Override
	public void removeClient(Client client) {
		String sql = "delete from freelancer_client where username = ? and pass = ?";
		if (jdbcTemplate.update(sql, client.getUsername(), client.getPassword()) == 0) {
			System.out.println("Client deleted successfully");
		}
	}

	@Override
	public void updateClient(Client client, String new_password) {
		String sql = "update freelancer_client set pass =? where username =? and pass=?";
		jdbcTemplate.update(sql, new_password, client.getUsername(), client.getPassword());


	}

	@Override
	public List<Client> getAllClients() {
		String sql = "select * from freelancer_client";
		List<Client> allUsersList = jdbcTemplate.query(sql, clientRowMapper);
		
		return allUsersList;
		
	}

}
