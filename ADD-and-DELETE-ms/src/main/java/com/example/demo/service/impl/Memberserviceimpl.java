package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.Memberrepository;
import com.example.demo.service.Memberservice;

@Service
public class Memberserviceimpl implements Memberservice {
	private final Memberrepository memberrepository;
	

	public Memberserviceimpl(Memberrepository memberrepository) {
		this.memberrepository = memberrepository;
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return memberrepository.findAll();
	}

//	@Override
//	public Optional<Member> getMemberId(Long id) {
//		// TODO Auto-generated method stub
//		return memberrepository.getById(id);
//	}

	@Override
	//@PreAuthorize("hasRole('STAFF')")
	public Member createMember(Member member) {
		// TODO Auto-generated method stub
		return memberrepository.save(member);
	}

//	@Override
//	//@PreAuthorize("hasRole('STAFF')")
	public void deleteMember(String username) {
		// TODO Auto-generated method stub
		memberrepository.deleteById(username);
		
	}

}
