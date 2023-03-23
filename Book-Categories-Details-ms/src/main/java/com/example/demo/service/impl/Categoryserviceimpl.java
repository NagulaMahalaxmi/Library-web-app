package com.example.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFound;
import com.example.demo.model.Category;

import com.example.demo.repository.Bookrepositoryy;
import com.example.demo.service.Categoryservice;

@Service
public class Categoryserviceimpl implements Categoryservice{
	
	@Autowired
	 private Bookrepositoryy bookrepository;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return bookrepository.getAllCategories();
	}

	@Override
	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return bookrepository.getCategoryById(id);
				//orElseThrow(()->new ResourceNotFound("category","id",id));
	}
	
	

	@Override
	public Category getCategoryByName(String CategoryName) {
		// TODO Auto-generated method stub
		return bookrepository.getCategoryByName(CategoryName);
	}

}
