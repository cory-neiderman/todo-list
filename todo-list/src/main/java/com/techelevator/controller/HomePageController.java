package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCTaskDAO;
import com.techelevator.model.JDBCUserDAO;
import com.techelevator.model.TaskDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("user")
public class HomePageController {
	
	TaskDAO taskDAO;
	
	@Autowired
	public HomePageController(JDBCTaskDAO taskDAO){
		this.taskDAO = taskDAO;
	}	

	
	@RequestMapping(path="/homePage", method=RequestMethod.GET)
	public String displayHomePage(Map<String, Object> model){
		
		User user = (User)model.get("user");
		
		
		model.put("taskList", taskDAO.getTaskByUserId(user.getUserId()));
		return "homePage";
	}
	
	@RequestMapping(path="/editTask", method=RequestMethod.GET)
	public String displayEditTaskPage(Map<String, Object>model){
		
		
		
		return "editTask";
		
		
	}
	
	
	
	
	

}
