package com.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freelancer.dao.ProjectDao;
import com.freelancer.dao.ProjectDaoJDBCTemplate;
import com.freelancer.pojo.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private ProjectDaoJDBCTemplate projectDao;

	@Autowired
	public void setProjectDao(ProjectDaoJDBCTemplate projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public List<Project> getAllProject() {
		System.out.println("Inside the Project Service");
		return projectDao.getAllProjects();
	}

	@Override
	public Project getProjectByProjectName(String projectName) {

		return projectDao.getProjectByName(projectName);
	}

	@Override
	public void updateProject(Project project) {
		projectDao.updateProject(project);

	}

	@Override
	public void removeProject(Project project) {
		projectDao.removeProject(project);
	}

	@Override
	public Project createProject(Project project) {
		return projectDao.addProject(project);
		
	}

}
