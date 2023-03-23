package com.example.demo.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.BadRequestException;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.Cart;
import com.example.demo.model.Issue;
import com.example.demo.model.Member;
import com.example.demo.repository.Bookrepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.IssueRepository;
import com.example.demo.repository.Memberrepository;

@Service
public class LibraryService {
	
	@Autowired
	private IssueRepository issuerepository;
	@Autowired
	private Memberrepository memberrepository;
	@Autowired
	private Bookrepository bookrepository;
	
	@Autowired
	private CartRepository cartrepo;
	
	public List<Issue> getAllIssues(){
		return issuerepository.findAll();
	}
	
	
	
	public LibraryService(IssueRepository issuerepository, Memberrepository memberrepository,
			Bookrepository bookrepository, CartRepository cartrepo) {
		super();
		this.issuerepository = issuerepository;
		this.memberrepository = memberrepository;
		this.bookrepository = bookrepository;
		this.cartrepo=cartrepo;
		
	}


	public Issue issueBook(Long bookId,String username) throws BadRequestException{
		Book book = bookrepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found"));
		Member member = memberrepository.findByUsername(username);
		if(book.getQuantity()<=0) {
		throw new BadRequestException("Book not available for issue");
		}
		
		Issue issue = new Issue();
		issue.setBookid(bookId);
		issue.setMemberusername(username);
		issue.setIssue_date(LocalDate.now());
		issue.setReturn_date(LocalDate.now().plusDays(7));
		issue.setReturned(false);
		issuerepository.save(issue);
		book.setQuantity(book.getQuantity()-1);
		bookrepository.save(book);
		
		
		Cart cart = new Cart();
		cart.setBookid(bookId);
		cart.setMemberusername(username);
		cart.setStatus("Issued");
		cartrepo.save(cart);
		
		return issue;
		
		
	}
	
	
	public Issue returnBook(Long bookid,String memberusername) {
		Issue issue = issuerepository.findById(bookid).orElseThrow(()-> new NotFoundException("Book not found")) ;
		Member member = memberrepository.findByUsername(null);
		issue.setReturned(true);
		issue.setBookid(bookid);
		issue.setMemberusername(memberusername);
		issuerepository.save(issue);
		Book book = bookrepository.findById(bookid).orElseThrow(() -> new NotFoundException("Book not found"));
		book.setQuantity(book.getQuantity()+1);
		bookrepository.save(book);
		
		Cart cart = new Cart();
	    cart = cartrepo.getBybookIdMemberId(bookid, memberusername);
	    cart.setStatus("Returned");
		cartrepo.save(cart);
		
		return issue;
		
		
		
	}


	public Issue renewalBook(Long bookId,String memberusername) {
		// TODO Auto-generated method stub
		Issue issue = issuerepository.findById(bookId).orElseThrow(()-> new NotFoundException("Book not found"));
		Member member = memberrepository.findByUsername(memberusername);
		issue.setReturned(false);
		issue.setBookid(bookId);
		issue.setMemberusername(memberusername);
		issue.setReturn_date(issue.getReturn_date().plusDays(7));
		issuerepository.save(issue);
		Cart cart = new Cart();
	    cart = cartrepo.getBybookIdMemberId(bookId, memberusername);
		cart.setStatus("Renewed");
		cartrepo.save(cart);
		
		return issue;
		
	}
	
	public List<Cart> getCart(String memberusername,String status) {
		Cart cart = new Cart();
		List<Cart> res = cartrepo.getissuedbooksbyMemberId(memberusername, status);
		return res;
		
	}
	public List<Cart> findmemberid(long bookid) {
		return cartrepo.memberid(bookid);
	}
	
	public List<Cart> getusercart(String memberusername){
		Cart cart = new Cart();
		List<Cart> c = cartrepo.getbooksbyMember(memberusername);
		return c;
	}
}


























	
//	public void issueBook(Long bookId,Long memberid) throws BadRequestException {
//		Book book = bookrepository.findById(bookId).orElseThrow(()-> new NotFoundException("Book not found"));
//		Member member = memberrepository.findById(memberid).orElseThrow(() -> new NotFoundException("member not found"));
//		if(book.getQuantity()<=0) {
//			throw new BadRequestException("Book not available for issue");
//		}
//		
//		Issue issue = new Issue();
//		issue.setBook(book);
//		issue.setMember(member);
//		issue.setIssueDate(LocalDate.now());
//		issue.setReturnDate(LocalDate.now().plusDays(7));
//		issue.setReturned(false);
//		issuerepository.save(issue);
//		book.setQuantity(book.getQuantity()-1);
//		bookrepository.save(book);
//		
//		
//	}
//	
//	public void returnBook(Long bookid) {
//		Issue issue = issuerepository.findBookIdAndReturnedFalse(bookid).orElseThrow(() -> new NotFoundException("Book not found or already returned"));
//		issue.setReturned(true);
//		issuerepository.save(issue);
//		Book book = issue.getBook();
//		book.setQuantity(book.getQuantity()+1);
//		bookrepository.save(book);
//		
//	}
//	
//	public void renewalBook(Long bookId) {
//		Issue issue = issuerepository.findBookIdAndReturnedFalse(bookId).orElseThrow(() ->  new NotFoundException("Book not found or already returned"));
//		issue.setReturnDate(issue.getReturnDate().plusDays(7));
//		issuerepository.save(issue);
//		
//		
//	}


