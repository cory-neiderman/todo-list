package com.techelevator.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCTaskDAO;
import com.techelevator.model.Task;
import com.techelevator.model.TaskDAO;
import com.techelevator.model.User;

@Controller
@Transactional
@SessionAttributes({"task", "user"})
public class AddTaskController {
	
	private TaskDAO taskDAO;
	
	@Autowired
	public AddTaskController(JDBCTaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
	
	
	@RequestMapping(path="/addTask", method=RequestMethod.GET)
	public String displayAddTaskPage(){
		
		
		return "addTask";
	}
	

	@RequestMapping(path="/newTask", method=RequestMethod.POST)
	public String addNewTask(Map<String, Object> model,
								@RequestParam(name="taskPriority") int taskPriority,
								@RequestParam(name="taskDescription") String taskDescription,
								
								@RequestParam(name="dueDate") String dueDate){
		
		User user = (User)model.get("user");
		
		Task task = new Task();
		task.setPriority(taskPriority);
		task.setDescription(taskDescription);
		task.setDueDate(LocalDate.parse(dueDate));
		task.setIsCompleted(false);
		task.setDateCreated(LocalDate.now());
		task.setNameOfCreator(user.getUsername());
		task.setUserId(user.getUserId());
		model.put("task", task);
		return "redirect:/newTaskConfirmation";
	}
	
	@RequestMapping(path="/newTaskConfirmation", method=RequestMethod.GET)
	public String showSummaryPage() {
		return "newTaskConfirmation";
	}

	@RequestMapping(path="/finalizeNewTask", method=RequestMethod.POST)
	public String finalizeNewTask(Map<String, Object> model) {
		
		Task task = (Task)model.get("task");
		taskDAO.add(task);
		
		return "redirect: homePage";
	}
	
}
