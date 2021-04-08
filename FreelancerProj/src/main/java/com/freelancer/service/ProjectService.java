package com.freelancer.service;

import java.util.List;

import com.freelancer.pojo.Project;

public interface ProjectService {

	public List<Project> getAllProject();
	
	public Project getProjectByProjectName(String projectName);
	
	public void updateProject(Project project);
	
	public void removeProject(Project project);
	
	public Project createProject(Project project);
}
