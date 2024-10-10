package com.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.main.dao.UserDAO;
import com.sp.main.model.User;

@Service
public class UserService 
{
   @Autowired
   private UserDAO userDao;
   
   public void addUser(User user)
   {
	   userDao.addUser(user);
   }
   
   public void editUser(User user)
   {
	   userDao.editUser(user);
   }
   
   public void deleteUser(String name)
   {
	   userDao.deleteUser(name);
   }
   
   public User readUserByName(String name) 
   {
	    return userDao.readUserByName(name); 
   }
   
   public List<User> readAllUsers()
   {
	    return userDao.readAllUsers();
   }
}
