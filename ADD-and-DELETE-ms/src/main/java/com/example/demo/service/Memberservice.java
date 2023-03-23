package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Member;

public interface Memberservice {

//	Optional<Member> getMemberId(Long id);
	void deleteMember(String username);
	Member createMember(Member member);
	List<Member> getAllMembers();
	

}
