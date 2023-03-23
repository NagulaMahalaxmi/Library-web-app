package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;
@Repository
public interface Bookrepository extends JpaRepository<Book,Long> {

	void save(Long bookid);
	

}
