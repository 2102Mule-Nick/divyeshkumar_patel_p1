package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.Bids;

@Component
public class BidsExtractor implements ResultSetExtractor<Bids>{

	@Override
	public Bids extractData(ResultSet rs) throws SQLException, DataAccessException {
		Bids newBid = new Bids();
		newBid.setBidId(rs.getInt("bid_id"));
		newBid.setProjectId(rs.getInt("project_id"));
		newBid.setUserId(rs.getInt("user_id"));
		newBid.setAmount(rs.getInt("amount"));
		newBid.setMessage(rs.getString("message"));
		return null;
	}

}
