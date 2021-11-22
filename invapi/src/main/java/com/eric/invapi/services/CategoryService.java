package com.eric.invapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.invapi.models.Category;
import com.eric.invapi.models.Product;
import com.eric.invapi.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
	private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;
	public Category addCategory(Category category) {
		
		for(Product product:category.getProducts()) {
			
			product.setCategory(category);
			this.productService.addProduct(product);
			
		}
		return this.categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories(){
		return this.categoryRepository.findAll();
	}
	
	public Category getCategoryById(long categoryId){
		return this.categoryRepository.findById(categoryId).orElse(null);
	}
}
