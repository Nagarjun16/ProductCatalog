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
import com.arrow.warehousemgmt.repository.UsersRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	

	@GetMapping("/userlist")
	public List<Users> getAllusers() {

		return usersRepository.findAll();
	}

	@GetMapping("users/{id}")
	public ResponseEntity<Users> getuserbyId(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {

		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user Not Found For the Id:" + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("register")
	public Users createuser(@Valid @RequestBody Users user) {
		return usersRepository.save(user);
	}

	@PutMapping("updateuser/{id}")
	public ResponseEntity<Users> updateuser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody Users userDetails) throws ResourceNotFoundException {
		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user Not Found For Id:" + userId));
		final Users updateduser = usersRepository.save(user);
		return ResponseEntity.ok(updateduser);

	}

	@DeleteMapping("unregister/{id}")
	public Map<String, Boolean> deleteuser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {

		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user Not Found For The Id:" + userId));
		usersRepository.delete(user);

		Map<String, Boolean> response = new HashMap();

		response.put("Deleted", Boolean.TRUE);

		return response;

	}

	
}
