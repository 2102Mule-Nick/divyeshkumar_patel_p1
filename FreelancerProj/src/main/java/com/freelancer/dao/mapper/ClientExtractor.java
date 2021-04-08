package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.Client;

@Component
public class ClientExtractor implements ResultSetExtractor<Client> {

	@Override
	public Client extractData(ResultSet rs) throws SQLException, DataAccessException {
		Client newClient = new Client();

		newClient.setClientId(rs.getInt("client_id"));
		newClient.setFirstName(rs.getString("firstname"));
		newClient.setLastName(rs.getString("lastname"));
		newClient.setCompany(rs.getString("company"));
		newClient.setUsername(rs.getString("username"));
		newClient.setEmail(rs.getString("email"));
		newClient.setPassword(rs.getString("pass"));

		return newClient;
	}

}
