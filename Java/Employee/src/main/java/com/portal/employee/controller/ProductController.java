package com.portal.employee.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.employee.exception.ResourceNotFoundException;
import com.portal.employee.model.Employee;
import com.portal.employee.model.Product;
import com.portal.employee.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found For The Id: " + productId));

		return ResponseEntity.ok().body(product);
	}

	@PostMapping("products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}

	@DeleteMapping("products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found For The Id: " + productId));
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;

	}
}
