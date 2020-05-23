package com.arrow.warehousemgmt.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrow.warehousemgmt.exception.ResourceNotFoundException;
import com.arrow.warehousemgmt.model.ProjectTimeline;
import com.arrow.warehousemgmt.repository.ProjectTimelineRepository;

@Service
public class ProjectTimelineService {

	@Autowired
	private ProjectTimelineRepository projectTimelineRepository;

	public List<ProjectTimeline> getProjectDetails() {
		return projectTimelineRepository.findAll();
	}

	public ProjectTimeline getProjectDetailsById(Long moduleId) throws ResourceNotFoundException {
		ProjectTimeline projectDet = projectTimelineRepository.findById(moduleId)
				.orElseThrow(() -> new ResourceNotFoundException("Project Not Found For the Id:" + moduleId));
		return projectDet;
	}

	public ProjectTimeline createNewProject(ProjectTimeline projectObj) {
		java.sql.Date startDate = projectObj.getStartingDate() == null ? new java.sql.Date(new Date().getTime())
				: projectObj.getStartingDate();
		projectObj.setStartingDate(startDate);
		projectObj.setCreatedTimeStamp(new Timestamp(new Date().getTime()));
		projectObj.setUpdatedTimeStamp(new Timestamp(new Date().getTime()));
		return projectTimelineRepository.save(projectObj);
	}

	public ProjectTimeline updateProjectDetails(Long moduleId, ProjectTimeline parmProjectObj) throws ResourceNotFoundException {
		ProjectTimeline projectObj = projectTimelineRepository.findById(moduleId)
				.orElseThrow(() -> new ResourceNotFoundException("Project Not Found For Id:" + moduleId));
		projectObj.setUpdatedTimeStamp(new Timestamp(new Date().getTime()));
		projectObj.setYear(parmProjectObj.getYear());
		projectObj.setProjectname(parmProjectObj.getProjectname());
		projectObj.setProjectlead(parmProjectObj.getProjectlead());
		projectObj.setPhase(parmProjectObj.getPhase());
		java.sql.Date startDate = parmProjectObj.getStartingDate() == null ? projectObj.getStartingDate()
				: parmProjectObj.getStartingDate();
		projectObj.setStartingDate(startDate);
		projectObj.setEndingDate(parmProjectObj.getEndingDate());
		
		final ProjectTimeline updatedProjectObj = projectTimelineRepository.save(projectObj);
		return updatedProjectObj;
	}

	public void deleteProject(Long moduleId) throws ResourceNotFoundException {
		ProjectTimeline projectDet = projectTimelineRepository.findById(moduleId)
				.orElseThrow(() -> new ResourceNotFoundException("Project Not Found For the Id:" + moduleId));
		projectTimelineRepository.delete(projectDet);
	}

}
