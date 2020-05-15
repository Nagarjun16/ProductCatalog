package com.arrow.warehousemgmt.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId", nullable = false)
	private long id;

	@NotBlank(message = "First Name Can't be blank")
	@Size(min = 5, max = 30, message = "First Name between 5 and 30 characters")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "No Special characters allowed in name")
	@Column(name = "FirstName", nullable = false)
	private String firstName;

	@NotBlank(message = "Last Name Can't blank")
	@Size(min = 3, max = 15, message = "Last Name Between 3 and 15 characters")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "No Special characters allowed in name")
	@Column(name = "LastName", nullable = false)
	private String lastName;

	@Email(message = "Invalid EmailId")
	@Column(name = "EmailAddress", nullable = false)
	private String emailId;

	@NotBlank(message = "Password Can't be blank")
	@Size(min = 5, max = 30, message = "First Name between 5 and 30 characters")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "No Special characters allowed in name")
	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "CreatedDate")
	private Timestamp createdDate;

	@Column(name = "ModifiedDate")
	private Timestamp modifiedDate;
}
