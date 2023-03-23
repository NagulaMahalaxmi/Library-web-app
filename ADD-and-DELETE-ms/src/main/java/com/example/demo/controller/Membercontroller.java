package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.service.Memberservice;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/Members")
public class Membercontroller {
	private final Memberservice memberservice;

	public Membercontroller(Memberservice memberservice) {
		this.memberservice = memberservice;
	}
	

   @GetMapping
   public List<Member> getAllMembers(){
	   return memberservice.getAllMembers();
   }
	
	@PostMapping
	public Member createMember(@RequestBody Member member) {
		return memberservice.createMember(member);
	}
	@DeleteMapping("{username}")
	public void deleteMember(@PathVariable("username") String username) {
		memberservice.deleteMember(username);
	}
	

}
