package com.example.demo.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

import com.example.demo.repository.Bookrepositoryy;
import com.example.demo.service.Bookservice;



@Service
public class Bookserviceimpl implements Bookservice {
	
	@Autowired
	private Bookrepositoryy bookrepository;
	
	

	public Bookserviceimpl(Bookrepositoryy bookrepository) {
		super();
		this.bookrepository = bookrepository;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookrepository.findAll();
	}

	@Override
	public List<Book> getByAccessNumber(Long access_number) {
		// TODO Auto-generated method stub
		return bookrepository.getByAccessNumber(access_number);
	}

	@Override
	public List<Book> getByTitle(String title) {
		// TODO Auto-generated method stub
		return bookrepository.findByTitle(title);
	}

	@Override
	public List<Book> getByAuthor(String author) {
		// TODO Auto-generated method stub
		return bookrepository.findByAuthor(author);
	}

	@Override
	public List<Book> getBySubject(String subject) {
		// TODO Auto-generated method stub
		return bookrepository.findBySubject(subject);
	}

	@Override
	public List<Book> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return bookrepository.findByKeyword(keyword);
	}

	@Override
	public List<Book> findBook(String subject, Long access_number, String title, String author, String keyword) {
		// TODO Auto-generated method stub
		return bookrepository.findBook(subject, access_number, title, author, keyword);
	}
	

	


}

//@Override
//public List<Book> findAll() {
//	// TODO Auto-generated method stub
//	return bookrepository.getAllBooks();
//}

//@Override
//public Book getByTitle(String title) {
//	// TODO Auto-generated method stub
//	return bookrepository.findByTitle(title);
//}

//@Override
//public Book getByAuthor(String author) {
//	// TODO Auto-generated method stub
//	return bookrepository.findByAuthor(author);
//}
//
//@Override
//public Book getBySubject(String subject) {
//	// TODO Auto-generated method stub
//	return bookrepository.findBySubject(subject);
//}
//
//@Override
//public Book getByKeyword(String keyword) {
//	// TODO Auto-generated method stub
//	return bookrepository.findByKeyword(keyword);
//}
//
//@Override
//public Book getByAccessNumber(Long access_number) {
//	// TODO Auto-generated method stub
//	return bookrepository.getByAccessNumber(access_number);
//}

