package com.portal.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "productName",nullable = false)
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
	
	public Product() {
		
	}

	public Product(String productName, String description, String features, String category, String supplier,
			String manufacturer, String review) {
		this.productName = productName;
		this.description = description;
		this.features = features;
		this.category = category;
		this.supplier = supplier;
		this.manufacturer = manufacturer;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", description=" + description + ", features=" + features
				+ ", category=" + category + ", supplier=" + supplier + ", manufacturer=" + manufacturer + ", review="
				+ review + "]";
	}
	
	
}
