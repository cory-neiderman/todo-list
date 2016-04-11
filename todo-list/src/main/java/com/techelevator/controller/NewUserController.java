package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCUserDAO;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("user")
public class NewUserController {
	
	UserDAO userDAO;
	
	@Autowired
	public NewUserController(JDBCUserDAO userDAO){
		this.userDAO = userDAO;
	}	
	
	@RequestMapping(path="/signUp", method=RequestMethod.GET)
	public String displaySignUpPage(){
		
		return "signUp";
	}
	
	@RequestMapping(path="newUserSignUp", method=RequestMethod.POST)
	public String createNewUser(Map<String, Object> model,
								@RequestParam(name="username") String username,
								@RequestParam(name="password") String password){
		
		
		userDAO.createNewUser(username, password);
		model.put("user", userDAO.getUserIdByNameAndPassword(username, password));
		
		return "redirect:/";
	}
}
