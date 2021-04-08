package com.freelancer.dao;

import java.util.List;

import com.freelancer.pojo.Project;

public interface ProjectDao {

	public Project getProjectByName(String projectName);

	public List<Project> getAllProjects();

	public void updateProject(Project project);

	public void removeProject(Project project);

	public Project addProject(Project project);
	
	public Project getProjectByClientName(String clientName);
	
	public Project getProjectBySkill(String skillName);

}
