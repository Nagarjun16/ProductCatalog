package com.arrow.warehousemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arrow.warehousemgmt.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
