package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.Bids;
@Component
public class BidsRowMapper implements RowMapper<Bids>{

	private BidsExtractor bidsExtractor;
	@Autowired
	public void setBidsExtractor(BidsExtractor bidsExtractor) {
		this.bidsExtractor = bidsExtractor;
	}

	@Override
	public Bids mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return bidsExtractor.extractData(rs);
	}

}
