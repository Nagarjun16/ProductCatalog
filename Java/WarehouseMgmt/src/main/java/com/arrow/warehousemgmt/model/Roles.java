package com.arrow.warehousemgmt.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "arrow_roles")
@Data
public class Roles {
	@Id
	@Column(name = "roleid", nullable = false)
	private long id;

	@Column(name = "rolename", nullable = false)
	private String rolename;
	
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name = "creationts")
	private Timestamp createdTimeStamp;

	@Column(name = "updatedts")
	private Timestamp updatedTimeStamp;
}
