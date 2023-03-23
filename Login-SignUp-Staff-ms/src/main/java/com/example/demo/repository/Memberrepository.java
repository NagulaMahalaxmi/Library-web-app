package com.example.demo.repository;


import java.sql.PreparedStatement;


import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AuthenticationRequest;

import com.example.demo.model.Staff;
@Repository
public class Memberrepository{
	@Autowired
	private JdbcTemplate temp;
	public UserDetails loadByusername(String username) {
		
		String sql="select* from staff where username=?";
		AuthenticationRequest auth = temp.queryForObject(sql, new Object[] {username},new AuthMapper() );
		return new User(auth.getUsername(),auth.getPassword(),new ArrayList<>());
	}
	
	public Integer Register(Staff staff) {
		try {
		String sql = "insert into staff(username,email,password) values(?,?,?)";
		return temp.execute(sql,new PreparedStatementCallback<Integer>() {
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, staff.getUsername());
				ps.setString(2, staff.getEmail());
				ps.setString(3, staff.getPassword());
				int a=ps.executeUpdate();
				return a;
			}
			
			});
		}
		
		
		catch(DuplicateKeyException e) {
			e.printStackTrace();
			return -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}
