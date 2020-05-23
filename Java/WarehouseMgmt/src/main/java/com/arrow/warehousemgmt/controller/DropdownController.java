package com.arrow.warehousemgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arrow.warehousemgmt.model.DropDown;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dropdown")
public class DropdownController {
	
	@GetMapping("/departmentList")
	public ResponseEntity<List<DropDown>> getAllusers() {
		ArrayList<DropDown> returnList = new ArrayList<>();
		DropDown dropObj= new DropDown();
		dropObj.setLable("Admin");
		dropObj.setValue("Admin");
		returnList.add(dropObj);
		dropObj= new DropDown();
		dropObj.setLable("Employee");
		dropObj.setValue("Employee");
		returnList.add(dropObj);
		return ResponseEntity.ok().body(returnList);
	}
	
}
