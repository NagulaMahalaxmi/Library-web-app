package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Book;

public interface Bookservice {
	List<Book> getAllBooks();
	Optional<Book> getBookByAccessnumber(Long access_number);
	Book createBook(Book book);
	void deleteBook(Long access_number);
	List<Book> getbookbyCategoryid(long categoryid);

}
