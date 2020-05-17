package com.arrow.warehousemgmt.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5174217714621601807L;
	
	private final String jwttoken;
}