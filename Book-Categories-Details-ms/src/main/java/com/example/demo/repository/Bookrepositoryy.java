package com.example.demo.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;

@Repository
public class Bookrepositoryy {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Category> getAllCategories(){
		List<Category> category = jdbcTemplate.query("select * from categories_table", new CategoryMapper());
		return category;
		
	}
	
	public Category getCategoryById(long categoryId) {
		String sql = "select * from categories_table where category_id=?";
		Category category = jdbcTemplate.queryForObject(sql, new Object[] {categoryId}, new CategoryMapper());
		return category;
		
	}
	
	public Category getCategoryByName(String categoryName) {
		String sql = "select * from categories_table where category_name=?";
		Category category = jdbcTemplate.queryForObject(sql, new Object[] {categoryName}, new CategoryMapper());
		return category;
		
	}
	

}
