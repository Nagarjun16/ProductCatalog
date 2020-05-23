package com.arrow.warehousemgmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arrow.warehousemgmt.exception.ResourceNotFoundException;
import com.arrow.warehousemgmt.model.ProjectTimeline;
import com.arrow.warehousemgmt.model.Users;
import com.arrow.warehousemgmt.service.ProjectTimelineService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectTimelineController {
	
	@Autowired
	private ProjectTimelineService projectTimelineService;
	
	@GetMapping("/projectslist")
	public List<ProjectTimeline> getProjectDetails() {
		return projectTimelineService.getProjectDetails();
	}

	@GetMapping("/projectslist/{id}")
	public ResponseEntity<ProjectTimeline> getProjectDetailsById(@PathVariable(value = "id") Long moduleId) throws ResourceNotFoundException {
		ProjectTimeline projectObj = projectTimelineService.getProjectDetailsById(moduleId);
		return ResponseEntity.ok().body(projectObj);
	}

	@PostMapping("/createnewproject")
	public ProjectTimeline createNewProject(@Valid @RequestBody ProjectTimeline projectObj) {
		return projectTimelineService.createNewProject(projectObj);
	}

	@PutMapping("/updateproject/{id}")
	public ResponseEntity<ProjectTimeline> updateUser(@PathVariable(value = "id") Long moduleId,
			@Valid @RequestBody ProjectTimeline parmprojectObj) throws ResourceNotFoundException {
		final ProjectTimeline projectObj = projectTimelineService.updateProjectDetails(moduleId, parmprojectObj);
		return ResponseEntity.ok(projectObj);
	}

	@DeleteMapping("/deleteProject/{id}")
	public Map<String, Boolean> deleteProject(@PathVariable(value = "id") Long moduleId) throws ResourceNotFoundException {
		projectTimelineService.deleteProject(moduleId);
		Map<String, Boolean> response = new HashMap();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

	
}
