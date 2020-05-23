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
import com.arrow.warehousemgmt.model.Roles;
import com.arrow.warehousemgmt.service.RolesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RolesController {
	
	@Autowired
	private RolesService rolesService;

	@GetMapping("/roleslist")
	public List<Roles> getAllroles() {
		return rolesService.getAllroles();
	}

	@GetMapping("roles/{id}")
	public ResponseEntity<Roles> getRolebyId(@PathVariable(value = "id") Long roleId) throws ResourceNotFoundException {
		Roles role = rolesService.findRoleById(roleId);
		return ResponseEntity.ok().body(role);
	}

	@PostMapping("registerRole")
	public Roles registerRole(@Valid @RequestBody Roles role) {
		return rolesService.addRole(role);
	}

	@PutMapping("updaterole/{id}")
	public ResponseEntity<Roles> updateUser(@PathVariable(value = "id") Long roleId,
			@Valid @RequestBody Roles roleDetails) throws ResourceNotFoundException {
		final Roles updatedrole = rolesService.updateRole(roleId, roleDetails);
		return ResponseEntity.ok(updatedrole);
	}

	@DeleteMapping("unregisterrole/{id}")
	public Map<String, Boolean> deleterole(@PathVariable(value = "id") Long roleId) throws ResourceNotFoundException {
		rolesService.deleteRole(roleId);
		Map<String, Boolean> response = new HashMap();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

}
