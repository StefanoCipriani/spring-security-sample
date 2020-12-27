package com.springsecurity.samples.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.samples.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
