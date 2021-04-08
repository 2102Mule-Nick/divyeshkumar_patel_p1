package com.freelancer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freelancer.pojo.Project;
import com.freelancer.service.ProjectService;
import com.freelancer.service.ProjectServiceImpl;

@Controller
public class ProjectController {

	private ProjectService projectService;

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/projects")
	@ResponseBody
	public List<Project> getAllProjects() {
		// System.out.println("Getting all Projects");

		List<Project> projectList;
		projectList = projectService.getAllProject();
		return projectList;
	}

	@GetMapping("/projects/{name}")
	@ResponseBody
	public Project getProjectByName(@PathVariable String name) {

		System.out.println("Project Name" + name);
		Project project = projectService.getProjectByProjectName(name);
		return project;

	}

	@PutMapping("/projects/")
	@ResponseBody
	public String updateProject(@RequestBody Project project) {
		projectService.updateProject(project);

		return "Item updated successfully";
	}
	
	@PostMapping("/projects/")
	@ResponseBody
	public ResponseEntity<String> createProject(@RequestBody Project project){
		Project createdProject = projectService.createProject(project);
		return ResponseEntity.ok("Project posted successfully"+ createdProject.getProjectId());
	}
	
	@DeleteMapping("/projects/{name}")
	@ResponseBody
	public void removeProject(@PathVariable(name ="name") String name) {
		Project project=null;
		project.setProjectName(name);
		projectService.removeProject(project);
	}
}

