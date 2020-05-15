package com.portal.employee.model;

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

@Entity
@Table(name="employees")
public class Employee {
	
	private long id;
	@NotBlank(message = "First Name Can't be blank")
	@Size(min = 5 , max = 30 , message = "First Name between 5 and 30 characters")
	@Pattern(regexp = "^[0-9a-zA-Z]+$" , message = "No Special characters allowed in name")
	private String firstName;
	@NotBlank(message = "Last Name Can't blank")
	@Size(min=3, max = 15 , message = "Last Name Between 3 and 15 characters")
	@Pattern(regexp = "^[0-9a-zA-Z]+$" , message = "No Special characters allowed in name")
	private String lastName;
	@Email(message="Invalid EmailId")
	private String emailId;
	
	public Employee() {
		
	}
	
	public Employee(String firstName,String lastName,String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name ="first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
	
}
