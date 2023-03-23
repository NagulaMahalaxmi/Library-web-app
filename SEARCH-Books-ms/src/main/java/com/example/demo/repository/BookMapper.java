
package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setAccess_number(rs.getLong("access_number"));
		book.setAuthor(rs.getString("author"));
		book.setKeyword(rs.getString("keyword"));
		book.setSubject(rs.getString("subject"));
		book.setTitle(rs.getString("title"));
		book.setCategory(rs.getString("category"));
		book.setBookurl(rs.getString("bookurl"));
		return book;
		
	}
	
	

	

}
