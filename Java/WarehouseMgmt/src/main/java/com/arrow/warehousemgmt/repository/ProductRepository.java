package com.arrow.warehousemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arrow.warehousemgmt.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
