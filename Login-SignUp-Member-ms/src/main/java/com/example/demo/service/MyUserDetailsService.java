package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.Memberrepository;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private Memberrepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserDetails member = repo.loadByusername(username);
    	if(member==null) {
    		throw new UsernameNotFoundException("User not found");
    	}
        return member;
    }
   
    public String register(Member member) {
    	int response=repo.Register(member);
    	if(response> 0) {
    		return "success";
    	}
    	else if(response < 0) {
    		return "Account already exists with provided details";
    	}
    	else {
    		return "failure";
    	}
    }
    
    
}