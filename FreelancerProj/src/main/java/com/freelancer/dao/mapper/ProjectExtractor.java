package com.freelancer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.freelancer.pojo.Project;

@Component
public class ProjectExtractor implements ResultSetExtractor<Project> {

	@Override
	public Project extractData(ResultSet rs) throws SQLException, DataAccessException {

		Project newProject = new Project();

		newProject.setProjectId(rs.getInt("project_id"));
		newProject.setProjectName(rs.getString("project_name"));
		newProject.setDescription(rs.getString("project_description"));
		newProject.setDuration(rs.getInt("duration"));
		newProject.setClientId(rs.getInt("client_id"));
		newProject.setPostingDate(rs.getString("posting_date"));
		newProject.setSkillId(rs.getInt("skill_id"));
		newProject.setAvailable(rs.getBoolean("available"));
		return newProject;
	}

}
