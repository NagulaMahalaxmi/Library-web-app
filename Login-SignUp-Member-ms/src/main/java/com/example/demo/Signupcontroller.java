package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.service.MyUserDetailsService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class Signupcontroller {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@RequestMapping({"/signup"})
	public String Register(@RequestBody Member member) {
		return userDetailsService.register(member);
		
		
	}
	

}
