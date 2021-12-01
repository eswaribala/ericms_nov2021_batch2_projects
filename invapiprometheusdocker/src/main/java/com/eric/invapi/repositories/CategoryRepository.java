package com.eric.invapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.invapi.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
