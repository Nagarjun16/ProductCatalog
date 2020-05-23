package com.arrow.warehousemgmt.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "single_window")
@Data
public class ProjectTimeline {
	@Id
	@Column(name="ModuleId", nullable = false)
	private Long id;
	
	@Column(name = "Year",nullable = false)
	@NotBlank(message = "Year Can't blank")
	private Date year;
	
	@Column(name="ProjectName",nullable = false)
	@NotBlank(message = "Project name can't blank")
	@Size(min=3, max = 100 , message = "Project name should be between 3 and 100 characters")
	private String projectname;
	
	@Column(name = "ProjectLead",nullable = false)
	@NotBlank(message = "Project lead name can't blank")
	@Size(min=3, max = 100 , message = "Project lead name should be between 3 and 100 characters")
	private String projectlead;
	
	@Column(name = "Phase", nullable = true)
	private String phase;
	
	@Column(name = "StartingDate",nullable = false)
	@NotBlank(message = "Starting Date Can't blank")
	private Date startingDate;
	
	@Column(name = "EndingDate",nullable = false)
	@NotBlank(message = "Ending Date Can't blank")
	private Date endingDate;

	@Column(name = "Creationts")
	private Timestamp createdTimeStamp;

	@Column(name = "Updatedts")
	private Timestamp updatedTimeStamp;
}
