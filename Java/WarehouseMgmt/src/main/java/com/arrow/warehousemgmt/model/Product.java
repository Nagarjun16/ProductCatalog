package com.arrow.warehousemgmt.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
	
	@Id
	@Column(name="ProductId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ProductName",nullable = false)
	@NotBlank(message = "Last Name Can't blank")
	@Size(min=3, max = 15 , message = "Last Name Between 3 and 30 characters")
	@Pattern(regexp = "^[0-9a-zA-Z]+$" , message = "No Special characters allowed in name")
	private String productName;
	
	@Column(name="description",nullable = false)
	@NotBlank(message = "Last Name Can't blank")
	@Size(min=3, max = 100 , message = "Description Between 5 and 100 characters")
	private String description;
	
	@Column(name = "features",nullable = false)
	@NotBlank(message = "features Can't blank")
	@Size(min=3, max = 100 , message = "features Between 5 and 100 characters")
	private String features;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "supplier" , nullable = true )
	private String supplier;
	
	@Column(name = "manufacturer", nullable = true)
	private String manufacturer;
	
	@Column(name = "review" , nullable = true)
	private String review;
	
	@Column(name="CreatedDate")
	private Timestamp createdDate;
	
	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;
}
