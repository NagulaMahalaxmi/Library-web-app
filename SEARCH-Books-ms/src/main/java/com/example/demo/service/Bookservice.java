package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Book;

public interface Bookservice {
	
	List<Book> findAll();
	public List<Book> getByAccessNumber(Long access_number);
	public List<Book> getByTitle(String title);
	public List<Book> getByAuthor(String author);
	public List<Book> getBySubject(String subject);
	public List<Book> getByKeyword(String keyword);
	
	public List<Book> findBook(String subject,Long access_number,String title,String author,String keyword);

	
}
