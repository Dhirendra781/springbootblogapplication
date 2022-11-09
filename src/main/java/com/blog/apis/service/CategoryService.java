package com.blog.apis.service;

import java.util.List;

import com.blog.apis.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategoryDto(Integer categoryId);
	
	//get
	public CategoryDto getCategory(Integer categoryId);
	
	//get all category
	public List<CategoryDto> getCategories();
	

}
