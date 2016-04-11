package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	private List<Task> toDoList;
	
	public ToDoList(){
		toDoList = new ArrayList<>();
	}
	
	public void addTask(Task task){
		toDoList.add(task);
	}
	
	public List<Task> getToDoList(){
		return toDoList;
	}
	
	public Task getTaskByName(String name){
		return null;
		
	}
	
	public List<Task> getTasksByPriority(int priority){
		return null;
		
	}
	

}
