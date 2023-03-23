package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long access_number;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private String subject;
	@Column
	private String keyword;
	@Column
	private String category;
	@Column
	private String bookurl;
	@Column
	private Long quantity;
	
	public Book() {
		
	}
	
	public Book(long access_number, String title, String author, String subject, String keyword, String category,
			String bookurl,Long quantity) {
		super();
		this.access_number = access_number;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.keyword = keyword;
		this.category = category;
		this.bookurl = bookurl;
		this.quantity=quantity;
	}

	public long getAccess_number() {
		return access_number;
	}

	public void setAccess_number(long access_number) {
		this.access_number = access_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookurl() {
		return bookurl;
	}

	public void setBookurl(String bookurl) {
		this.bookurl = bookurl;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	
	
	
	

}
