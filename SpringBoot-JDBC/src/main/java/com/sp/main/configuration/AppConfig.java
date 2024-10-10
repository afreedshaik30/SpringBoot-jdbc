package com.sp.main.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sp.main.model.User;
import com.sp.main.service.UserService;

@Configuration
public class AppConfig 
{
   @Autowired
   private UserService userService;
   
   @Bean
   public CommandLineRunner commandLineRunner()
   {
	return args ->{
		// 1. add user
//		User add= new User("Alia","alia999@gmail.com","female","mumbai");
//      userService.addUser(add);
        
        // 2. edit user
//		User edit=new User();
//		edit.setEmail("salar111@gmail.com");
//		edit.setName("Salaar");
//		userService.editUser(edit);
		
		// 3. delete user
//		User delete=new User();
//		userService.deleteUser("Alia");
		
		// 4. read user by name
//		User userObj=userService.readUserByName("Asha");
//		System.out.println("user obj ---- "+userObj);
		
		// 5. read all users in a List 
		List<User> userList=userService.readAllUsers();
		for(User user: userList)
		{
			System.out.println(user);
		}
	};
   }
}
