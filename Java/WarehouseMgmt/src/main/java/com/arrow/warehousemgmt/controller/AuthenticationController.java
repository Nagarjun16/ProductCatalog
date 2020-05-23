package com.arrow.warehousemgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arrow.warehousemgmt.model.LoginResponse;
import com.arrow.warehousemgmt.model.Users;
import com.arrow.warehousemgmt.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Users authenticationRequest) throws Exception {
		final String token = authenticationService.authenticate(authenticationRequest);
		return ResponseEntity.ok(new LoginResponse(token));
	}
	
}
