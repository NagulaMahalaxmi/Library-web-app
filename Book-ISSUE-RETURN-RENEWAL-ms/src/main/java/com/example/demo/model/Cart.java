package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartid;
	@Column
	private long bookid;
	@Column
	private String memberusername;
	@Column
	private String Status;

	public Cart(long cartid, long bookid, String memberusername, String status) {
		super();
		this.cartid = cartid;
		this.bookid = bookid;
		this.memberusername = memberusername;
		Status = status;
	}

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public long getCartid() {
		return cartid;
	}

	public void setCartid(long cartid) {
		this.cartid = cartid;
	}

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getMemberusername() {
		return memberusername;
	}

	public void setMemberusername(String memberusername) {
		this.memberusername = memberusername;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	

}
