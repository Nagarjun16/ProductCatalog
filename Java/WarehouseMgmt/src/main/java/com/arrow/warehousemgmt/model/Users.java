package com.arrow.warehousemgmt.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "arrorw_users")
@Data
public class Users {
	@Id
	@Column(name = "UserId", nullable = false)
	private long id;

	@Column(name = "Username", nullable = false)
	private String username;
	
	@Column(name = "Department", nullable = false)
	private String department;
	
	@Column(name = "RoleId", nullable = false)
	private long roleId;
	
	@Column(name = "Active", nullable = false)
	private boolean active;
	
	@Column(name = "Creationts")
	private Timestamp createdTimeStamp;

	@Column(name = "Updatedts")
	private Timestamp updatedTimeStamp;
}
