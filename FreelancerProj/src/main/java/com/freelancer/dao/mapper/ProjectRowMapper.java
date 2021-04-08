package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.Project;

@Component
public class ProjectRowMapper implements RowMapper<Project> {

	private ProjectExtractor projectExtractor;
	
	@Autowired
	public void setProjectExtractor(ProjectExtractor projectExtractor) {
		this.projectExtractor = projectExtractor;
	}


	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		return projectExtractor.extractData(rs);
	}

}
