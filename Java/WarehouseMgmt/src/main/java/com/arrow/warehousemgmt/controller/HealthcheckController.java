package com.arrow.warehousemgmt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

	@Value("${jwt.clientSecret}")
	private String secret;
	
	@RequestMapping({"/healthcheck"})
	public String peformHealthcheck() {
		System.out.println(secret);
		return "OK";
	}
}
