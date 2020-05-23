package com.arrow.warehousemgmt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.arrow.warehousemgmt.model.Users;
import com.arrow.warehousemgmt.repository.UsersRepository;
import com.arrow.warehousemgmt.util.JwtTokenUtil;

@Service
public class AuthenticationService {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	public String authenticate(Users authenticationRequest) throws Exception {
		Users user = usersRepository.findById(authenticationRequest.getId()).get();
		if(!user.isActive()) {
			throw new Exception("USER_DISABLED", new Throwable());
		} else if(!authenticationRequest.getDepartment().equalsIgnoreCase(user.getDepartment())) {
			throw new Exception("INVALID_CREDENTIALS", new Throwable());
		}
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), ""));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		final UserDetails userDetails =  new User(user.getUsername(), "", new ArrayList<>());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}
}
