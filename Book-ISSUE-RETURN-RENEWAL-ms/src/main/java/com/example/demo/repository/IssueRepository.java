package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {

	//Issue findBookIdAndReturnedFalse(Long bookId);
	
	

}
