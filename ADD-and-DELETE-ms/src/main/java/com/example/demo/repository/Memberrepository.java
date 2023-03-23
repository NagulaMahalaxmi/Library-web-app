package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Member;

@Repository
public interface Memberrepository extends JpaRepository<Member,String> {

}
