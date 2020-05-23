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
import com.arrow.warehousemgmt.model.Users;
import com.arrow.warehousemgmt.service.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping("/userlist")
	public List<Users> getAllusers() {
		return usersService.getAllusers();
	}

	@GetMapping("/userlist/{id}")
	public ResponseEntity<Users> getUserbyId(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		Users user = usersService.findUserById(userId);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/register")
	public Users registerUser(@Valid @RequestBody Users user) {
		return usersService.registerUser(user);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody Users userDetails) throws ResourceNotFoundException {
		final Users updateduser = usersService.updateUser(userId, userDetails);
		return ResponseEntity.ok(updateduser);
	}

	@DeleteMapping("/unregister/{id}")
	public Map<String, Boolean> deleteuser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		usersService.deleteUser(userId);
		Map<String, Boolean> response = new HashMap();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

}
