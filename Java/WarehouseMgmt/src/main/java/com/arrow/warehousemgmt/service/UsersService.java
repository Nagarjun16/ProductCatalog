package com.arrow.warehousemgmt.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.arrow.warehousemgmt.exception.ResourceNotFoundException;
import com.arrow.warehousemgmt.model.Users;
import com.arrow.warehousemgmt.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public List<Users> getAllusers() {
		return usersRepository.findAll();
	}

	public Users findUserById(Long userId) throws ResourceNotFoundException {
		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user Not Found For the Id:" + userId));
		return user;
	}
	
	public Users registerUser(Users user) {
		user.setCreatedTimeStamp(new Timestamp(new Date().getTime()));
		user.setUpdatedTimeStamp(new Timestamp(new Date().getTime()));
		return usersRepository.save(user);
	}
	
	public Users updateUser(Long userId, Users paramUserDetails) throws ResourceNotFoundException {
		Users user = usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user Not Found For Id:" + userId));
		user.setUpdatedTimeStamp(new Timestamp(new Date().getTime()));
		user.setRoleId(paramUserDetails.getRoleId());
		user.setActive(paramUserDetails.isActive());
		user.setDepartment(paramUserDetails.getDepartment());
		user.setUsername(paramUserDetails.getUsername());

		final Users updateduser = usersRepository.save(user);
		return updateduser;
	}
	
	public void deleteUser(Long userId) throws ResourceNotFoundException {
		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user Not Found For The Id:" + userId));
		usersRepository.delete(user);
	}

}
