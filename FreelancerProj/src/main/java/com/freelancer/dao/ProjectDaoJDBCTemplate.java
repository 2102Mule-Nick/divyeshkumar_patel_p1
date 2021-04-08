package com.freelancer.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.freelancer.dao.mapper.ProjectRowMapper;
import com.freelancer.pojo.Project;

@Repository
public class ProjectDaoJDBCTemplate implements ProjectDao {

	private JdbcTemplate jdbcTemplate;

	private ProjectRowMapper projectRowMapper;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setProjectRowMapper(ProjectRowMapper projectRowMapper) {
		this.projectRowMapper = projectRowMapper;
	}

	@Override
	public Project getProjectByName(String projectName) {

		String sql = "SELECT * FROM freelancer_projects WHERE project_name = ?";
		List<Project> projectList = jdbcTemplate.query(sql, projectRowMapper, projectName);

		return projectList.get(0);

	}

	@Override
	public List<Project> getAllProjects() {
		String sql = "SELECT * FROM freelancer_projects";

		List<Project> projectList = jdbcTemplate.query(sql, projectRowMapper);

		return projectList;
		
	}

	@Override
	public void updateProject(Project project) {
		String sql = "update freelancer_projects project_name =?, project_description=?, duration =?,posting_date =? where project_id=?";

		Project updateProject = this.getProjectByName(project.getProjectName());

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getDescription());
			ps.setInt(3, project.getDuration());
			ps.setString(4, project.getPostingDate());
			ps.setInt(5, project.getProjectId());
			return ps;
		});
	}

	@Override
	public void removeProject(Project project) {

		String sql = "UPDATE item SET available = FALSE WHERE product_id = ?";

		Project removeItem = this.getProjectByName(project.getProjectName()); // added this code since the item might
																				// not have the
		// product_id associated with it yet

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, removeItem.getProjectId());
			return ps;
		});
	}

	@Override
	public Project addProject(Project project) {
		String sql = "insert into project(project_name, project_description, duration, client_id,posting_date,skill_id,available) values (?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getDescription());
			ps.setInt(3, project.getDuration());
			ps.setInt(4, project.getClientId());
			ps.setString(5, project.getPostingDate());
			ps.setInt(6, project.getSkillId());
			ps.setBoolean(7, project.isAvailable());
			return ps;
		}, keyHolder);
		project.setProjectId((int) keyHolder.getKeys().get("project_id"));
		return project;

	}

	@Override
	public Project getProjectByClientName(String clientName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProjectBySkill(String skillName) {
		// TODO Auto-generated method stub
		return null;
	}

}
