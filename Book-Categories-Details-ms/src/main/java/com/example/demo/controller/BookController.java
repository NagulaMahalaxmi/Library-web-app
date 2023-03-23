package com.example.demo.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Category;
import com.example.demo.service.Categoryservice;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping
public class BookController {
	
	@Autowired
	private Categoryservice categoryservice;
	
	
	

	@GetMapping
	public List<Category> getAllCategories(){
		return categoryservice.getAllCategories();
		
	}
	
	@GetMapping("/categoryid/{categoryid}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryid")Long id){
		return new  ResponseEntity<Category>(categoryservice.getCategoryById(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/categoryname/{Categoryname}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable("Categoryname") String categoryname){
		Category category=categoryservice.getCategoryByName(categoryname);
		if(category==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(category);
		
	}
	
	
	

}
