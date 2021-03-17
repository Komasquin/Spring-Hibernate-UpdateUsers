package com.example.UserManager.controllers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
//@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		
		logger.info("Getting all Users");
		Iterable<User> users = userService.GetAllUsers();
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "users";
    }
	
	@RequestMapping(value="/find", method=RequestMethod.POST)//url
	public String findUser(@RequestParam("user_id") int u_id, ModelMap mod) {
		logger.info("Searching for user");
		User user = userService.GetUserById(u_id);
		String whatToDo;
		if(user != null) {
		//Iterable<User> uList = Arrays.asList(user);
		mod.addAttribute("user", user);//attribute variable different from .jsp file
		whatToDo = "find";
		}else {
			whatToDo = "Error";
		}
		return whatToDo;//name of .jsp file
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)//url
	public String saveUser(@RequestParam("su_id") int su_id, @RequestParam("fName") String fName, @RequestParam("eMail") String eMail, @RequestParam("passWord") String passWord, ModelMap mod) {
		logger.info("Updating user info");
		User user = userService.GetUserById(su_id);
		user.setName(fName);
		user.setEmail(eMail);
		user.setPassword(passWord);
		userService.UpdateUser(user);
		Iterable<User> uList = userService.GetAllUsers();
		logger.info("Passing users to view");
		mod.addAttribute("users", uList);//attribute variable different from .jsp file
		return "users";//name of .jsp file
	}

}
