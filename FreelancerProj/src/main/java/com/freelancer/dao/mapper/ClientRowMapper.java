package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.Client;

@Component
public class ClientRowMapper implements RowMapper<Client> {

	private ClientExtractor clientExtractor;

	@Autowired
	public void setClientExtractor(ClientExtractor clientExtractor) {
		this.clientExtractor = clientExtractor;
	}

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		return clientExtractor.extractData(rs);
	}
}
