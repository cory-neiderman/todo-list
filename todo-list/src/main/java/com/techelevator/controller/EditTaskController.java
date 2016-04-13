package com.techelevator.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCTaskDAO;
import com.techelevator.model.Task;
import com.techelevator.model.TaskDAO;
import com.techelevator.model.User;


@RestController
@Transactional
@SessionAttributes({"task", "user"})
public class EditTaskController {
	
	private TaskDAO taskDAO;
	
	@Autowired
	public EditTaskController(JDBCTaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
	
	@RequestMapping(path="/editTask/edit", method=RequestMethod.GET)
	public List<Task> listTasksByUserId(Map<String, Object> model){
		
		User user = (User)model.get("user");
		
		return taskDAO.getTaskByUserId(user.getUserId());
		
	}
	
	@RequestMapping(path="/editTask/edit/{taskId}", method=RequestMethod.POST)
	public List<Task> listUpdatedTasks(Map<String, Object> model,
										@PathVariable int taskId){
		
		
		taskDAO.markTaskCompletedById(taskId);
		
		User user = (User)model.get("user");
		return taskDAO.getTaskByUserId(user.getUserId());
		
	}
	
	
}