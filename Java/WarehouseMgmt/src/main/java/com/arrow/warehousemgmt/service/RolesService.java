package com.arrow.warehousemgmt.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrow.warehousemgmt.exception.ResourceNotFoundException;
import com.arrow.warehousemgmt.model.Roles;

import com.arrow.warehousemgmt.repository.RolesRepository;

@Service
public class RolesService {

	@Autowired
	private RolesRepository rolesRepository;

	public List<Roles> getAllroles() {
		return rolesRepository.findAll();
	}

	public Roles findRoleById(Long roleId) throws ResourceNotFoundException {
		Roles role = rolesRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("role Not Found For the Id:" + roleId));
		return role;
	}

	public Roles addRole(Roles role) {
		role.setCreatedTimeStamp(new Timestamp(new Date().getTime()));
		role.setUpdatedTimeStamp(new Timestamp(new Date().getTime()));
		return rolesRepository.save(role);
	}

	public Roles updateRole(Long roleId, Roles paramRoleDetails) throws ResourceNotFoundException {
		Roles role = rolesRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("role Not Found For Id:" + roleId));
		role.setUpdatedTimeStamp(new Timestamp(new Date().getTime()));
		role.setActive(paramRoleDetails.isActive());
		role.setRolename(paramRoleDetails.getRolename());
		final Roles updatedrole = rolesRepository.save(role);
		return updatedrole;
	}

	public void deleteRole(Long roleId) throws ResourceNotFoundException {
		Roles role = rolesRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("role Not Found For The Id:" + roleId));
		rolesRepository.delete(role);
	}

}
