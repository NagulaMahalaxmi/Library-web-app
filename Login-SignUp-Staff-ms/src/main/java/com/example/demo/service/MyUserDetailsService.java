package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.demo.model.Staff;
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
   
    public String register(Staff staff) {
    	int response=repo.Register(staff);
    	if(response>0) {
    		return "success";
    	}
    	else if(response <0) {
    		return "Account already exists with provided details";
    	}
    	else {
    		return "failure";
    	}
    }
    
    
}