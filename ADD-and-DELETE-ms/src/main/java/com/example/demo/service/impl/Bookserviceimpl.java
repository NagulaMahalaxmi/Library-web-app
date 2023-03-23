package com.example.demo.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.Bookrepository;
import com.example.demo.service.Bookservice;

@Service
public class Bookserviceimpl implements Bookservice {
	
	@Autowired
	private Bookrepository bookrepository;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookrepository.findAll();
	}

	@Override
	public Optional<Book> getBookByAccessnumber(Long access_number) {
		// TODO Auto-generated method stub
		return bookrepository.findById(access_number);
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookrepository.save(book);
	}

	@Override
	public void deleteBook(Long access_number) {
		// TODO Auto-generated method stub
		bookrepository.deleteById(access_number);
		
	}

	@Override
	public List<Book> getbookbyCategoryid(long categoryid) {
		// TODO Auto-generated method stub
		return bookrepository.getbookbyCategoryid(categoryid);
	}
	

	
}
