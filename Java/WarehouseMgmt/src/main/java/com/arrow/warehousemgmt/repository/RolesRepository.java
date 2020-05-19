package com.arrow.warehousemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arrow.warehousemgmt.model.Roles;


public interface RolesRepository extends JpaRepository<Roles, Long>{
	Roles findByRolename(String rolename);
}
