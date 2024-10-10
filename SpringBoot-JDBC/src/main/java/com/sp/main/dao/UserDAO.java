package com.sp.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sp.main.model.User;
import com.sp.main.rowmapper.UserRowMapper;

@Repository
public class UserDAO 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addUser(User user)
	{
		String query ="INSERT INTO users(name, email, gender, city) VALUES(?,?,?,?)";
	    jdbcTemplate.update(query,user.getName(),user.getEmail(),user.getGender(),user.getCity());
	}
	
	public void editUser(User user)
	{
		String query="UPDATE users SET email=? WHERE name=?";
		jdbcTemplate.update(query,user.getEmail(),user.getName());
	}
	
	public void deleteUser(String name)
	{
		String query="DELETE FROM users WHERE name=?";
		jdbcTemplate.update(query,name);
	}
	
	public User readUserByName(String name)
	{
		String query="SELECT * FROM users WHERE name=?";
		return jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(User.class),name);
	}
	
	public List<User> readAllUsers()
	{
		String query="SELECT * FROM users";
		return jdbcTemplate.query(query,new UserRowMapper());
	}
}
