package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;

public interface Categoryservice {
	List<Category> getAllCategories();
	Category getCategoryById(long id);
	Category getCategoryByName(String CategoryName);

}