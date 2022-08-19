package com.hospital.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.api.model.Category;
import com.hospital.api.repository.CategoryRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200/"})
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public List<Category> getAllcategories()
	{
		return categoryRepository.findAll();
	}
	
	@PostMapping("/category")
	public Category postCategory(@RequestBody Category category)
	{
		return categoryRepository.save(category);
	}
}
