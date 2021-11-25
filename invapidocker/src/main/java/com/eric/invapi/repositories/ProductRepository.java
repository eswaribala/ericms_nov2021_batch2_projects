package com.eric.invapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.invapi.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
